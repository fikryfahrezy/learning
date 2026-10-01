# Section 5 — Docker Compose with Multiple Local Containers

Summary of lectures 55–66. The second project is a **Visits** app: a Node/Express web server that
shows how many times the page has been visited, with the count stored in a separate **Redis**
container. Two isolated containers can't talk to each other on their own, so the section brings in
**Docker Compose**: a separate CLI that reads a `docker-compose.yml` file, starts several containers
at once and **puts them on one network automatically**. After that the section covers the Compose
versions of the everyday commands (`up`, `up --build`, `up -d`, `down`, `ps`) and **restart
policies**, which bring a crashed container back up.

> **The purpose of Docker Compose is to essentially function as Docker CLI but allow you to issue
> multiple commands much more quickly.** Containers started from the same compose file reach each
> other **by service name**. `redis-server` in the YAML becomes the hostname in the Node code.

---

## 55. App Overview

### What we're building

A tiny web app whose page shows *"Number of visits: 10"*, meaning the page has been visited 10
times. It has two components:

- A **web server** (Node): responds to HTTP requests and generates the HTML.
- A **Redis server**: an in-memory data store, *"a tiny little database that sits entirely inside
  of memory"*. Its only job is to hold the visit count.

The count could live inside the Node app itself. Redis is used to make the project *"sufficiently
complicated"*.

### Why not one container with both?

Putting Node and Redis in **one container** works, but it breaks once you scale. To handle more
traffic you'd start more copies of that container, and each copy would have its **own
disconnected Redis**. One could think the page has been visited 99 times and another only 3.

The better design:

- **One single Redis instance** in its own container.
- **Node app in separate container(s)**. Scale by adding more Node containers, all connecting to
  the same Redis.

For the first iteration there's no scaling yet: **one Node container + one Redis container**.

---

## 56. App Server Starter Code

(Students who don't want to write JavaScript can skip ahead; the next lecture has the code to
copy.)

Create a project folder named `visits` with two files.

### `package.json`

```json
{
  "dependencies": {
    "express": "*",
    "redis": "2.8.0"
  },
  "scripts": {
    "start": "node index.js"
  }
}
```

- **`express`**: any version (`*`).
- **`redis`**: a **JavaScript client library** for connecting to a Redis server, reading from it
  and updating it. The course pins it to **2.8.0**.
- A single **`start`** script that runs `node index.js`.

### `index.js`

Put together from the lecture's narration. This is the callback-style API of the redis 2.x client:

```js
const express = require('express');
const redis = require('redis');

const app = express();
const client = redis.createClient();
client.set('visits', 0);

app.get('/', (req, res) => {
  client.get('visits', (err, visits) => {
    res.send('Number of visits is ' + visits);
    client.set('visits', parseInt(visits) + 1);
  });
});

app.listen(8081, () => {
  console.log('Listening on port 8081');
});
```

What it does:

- **`redis.createClient()`**: `client` is the connection to the Redis server. The host and port
  are filled in later, once the Docker side exists (lecture 60).
- **`client.set('visits', 0)`**: sets the counter to zero at startup. Otherwise the code would
  assume a value already exists.
- **Root route**: `client.get('visits', callback)` reads the count, sends it back, then stores
  `visits + 1`.
- **Gotcha:** Redis returns `visits` as a **string**, so it's wrapped in **`parseInt`** so that 1
  gets added to a number, not appended to a string.
- The app listens on **port 8081**.

---

## 57. Assembling a Dockerfile

This Dockerfile only builds the **Node app**. It has nothing to do with Redis. It's basically the
same as the one from the previous project:

```dockerfile
FROM node:alpine

WORKDIR '/app'

COPY package.json .
RUN npm install
COPY . .

CMD ["npm","start"]
```

- **`FROM node:alpine`**: the base image.
- **`WORKDIR '/app'`**: the working directory.
- **Copy `package.json` first, then `npm install`, then `COPY . .`**: this caching trick means
  `npm install` only runs again when `package.json` changes. Editing `index.js` doesn't trigger a
  reinstall.
- **`CMD ["npm","start"]`**: starts the server.

### Building and tagging

```sh
docker build .                                 # prints an image ID
docker build -t <docker-username>/visits:latest .
```

Red "notice" text and a few warnings during the build are fine to ignore. The image is **tagged**
so you don't have to carry the ID around.

---

## 58. Introducing Docker Compose

### The failure

```sh
docker run <docker-username>/visits     # :latest is optional
```

This fails right away with an error that the **Redis connection failed**, because no Redis server
is running. So start one in another terminal. It's the stock image from Docker Hub with no
customization:

```sh
docker run redis
```

Running the visits image again **still gives the same error**. The two containers are
**absolutely isolated processes** with no automatic communication between them. Some networking
has to be set up.

### Two options for connecting containers

| Option | Verdict |
| --- | --- |
| **Docker CLI's networking features** | Works, but *"a real pain in the neck"*: several commands that have to be run again every time you start the containers. The instructor says they have *"just about never seen people in industry"* use it to connect containers. |
| **Docker Compose** | What the course uses. |

### What Docker Compose is

- A **separate CLI tool** that gets installed along with Docker. Run `docker-compose` to see its
  commands.
- **Purpose 1:** saves you from typing long, repetitive Docker CLI commands and options (`run`,
  ports, tags, and so on).
- **Purpose 2:** makes it easy to **start multiple containers at the same time** and **connect
  them with networking automatically**, behind the scenes.

---

## 59. Docker Compose Files

The commands you'd otherwise run (`docker build`, `docker run`, …) get written, **in a special
syntax** (not copy-pasted), into a **`docker-compose.yml`** file in the project directory. The
Compose CLI parses it and creates the containers with that configuration.

The plan in plain words:

- Create a container called **`redis-server`** from the **`redis`** image on Docker Hub.
- Create a container called **`node-app`** from the **Dockerfile in the current directory**.
- Map ports from `node-app` to the local machine.

### `docker-compose.yml`

```yaml
version: '3'
services:
  redis-server:
    image: 'redis'
  node-app:
    build: .
    ports:
      - '4001:8081'
```

- **`version: '3'`**: a required line. It says which version of the Compose file format is used.
- **`services:`**: the section that says what Compose should create. A **service** is
  *essentially* a container. More precisely, it's **a type of container**.
- **`image: 'redis'`**: builds the service from an existing image.
- **`build: .`**: *"look in the current directory for a Dockerfile"* and build the image from it.
- **`ports:`**: a dash in YAML marks an **array** item, so a service can map many ports. The format
  is **`<local machine port>:<container port>`**. Here **4001** is used on the host so it's clearly
  different from 8081 in the container.

---

## 60. Networking with Docker Compose

### No network config needed

The file has no networking config at all. That's on purpose. **Services defined in the same compose
file are created on the same network** and *"have free access to communicate to each other"*, with
no ports opened between them. The `ports` entry only exposes the container to **your local
machine**.

### Connecting by service name

Normally `createClient` would get a connection URL such as `https://myredisserver.com`. With
Compose you just use the **service name**:

```js
const client = redis.createClient({
  host: 'redis-server',
  port: 6379
});
```

- Node, Express and the Redis client **have no idea what `redis-server` means**. The client just
  tries to connect to that hostname *"in good faith"*.
- **Docker sees the request**, recognizes `redis-server` as the other container's name and
  **redirects the connection** to that container.
- **`6379`** is Redis's **default port**. It's added only *"for completion's sake"*.

---

## 61. Docker Compose Commands

| Docker CLI | Docker Compose | Meaning |
| --- | --- | --- |
| `docker run <image>` | `docker-compose up` | Start every service in the compose file. No image name is needed, because Compose looks for the compose file in the current directory. |
| `docker build .` + `docker run <image>` | `docker-compose up --build` | **Rebuild** the images first so you get the latest changes, then start. |

### Running it

```sh
docker-compose up
```

Output to notice:

- **`Creating network visits_default`**: Compose **automatically creates a network** joining the
  services.
- It builds the image for the Node app, then creates **`visits_node-app_1`** and
  **`visits_redis-server_1`**, one instance of each service.
- Output from both services is interleaved in different colors: Redis prints *"ready to accept
  connections"* and Node prints *"Listening on port 8081"*.

Open **`localhost:4001`** (not 8081, since the mapping was changed). It shows *"Number of visits
is 0"*, and every refresh increments it.

> Anywhere you'd normally put a connection URL or URI (say, for a database driver in your web
> app), you can instead **list the name of the other container**, and Docker resolves the hostname
> for you.

---

## 62. Stopping Docker Compose Containers

The CLI way: `docker run -d redis` (detached, in the background), `docker ps`, then `docker stop
<id>` for each container. With several containers that's a pain. Compose starts and stops them as a
group:

| Docker CLI | Docker Compose |
| --- | --- |
| `docker run -d <image>` | `docker-compose up -d`: start all containers **in the background** |
| `docker stop <id>` (once per container) | `docker-compose down`: **stop and remove** all of them at once |

```sh
docker-compose up -d
docker ps              # two running containers
docker-compose down
docker ps              # nothing left
```

An easy way to remember it: the opposite of **up** is **down**. Many Docker CLI commands have a
**one-to-one** Compose equivalent.

---

## 63. Container Maintenance with Compose

How do you handle a container whose server **crashes or hangs**? To try it out, the root route is
made to crash on purpose:

```js
const process = require('process');
// ...
app.get('/', (req, res) => {
  process.exit(0);
  // ...
});
```

```sh
docker-compose up --build     # rebuild because the code changed
```

Visiting `localhost:4001` gives an error page. The terminal shows the Node container **exited with
code 0**, and `docker ps` in a second tab shows **only the Redis container is still running**.

---

## 64. Automatic Container Restarts

### Exit status codes

- **`0`**: the process exited **because we wanted it to**. Everything is okay.
- **Any non-zero value** (1, 2, 3, 300, 5000, …): the process exited **because an error
  occurred**.

This number decides whether some restart policies restart the container.

### Restart policies

Set **per service** in the compose file. Adding one to `node-app` doesn't affect `redis-server`.

| Policy | Behavior |
| --- | --- |
| **`"no"`** | The **default**. Never try to restart the container if it stops or crashes. |
| **`always`** | If the container stops **for any reason**, always try to restart it. |
| **`on-failure`** | Only restart if the container stopped with an **error code** (non-zero). |
| **`unless-stopped`** | Always restart **unless** we forcibly stopped it at the command line (`docker stop`). |

```yaml
  node-app:
    restart: always
    build: .
    ports:
      - '4001:8081'
```

### Trying `always`

Press Ctrl+C, run `docker-compose up`, and visit `localhost:4001` **in a new tab**. The instructor
notes Chrome sometimes doesn't hit the server again if you reuse the tab. The container exits, then
**restarts right away**.

You'll see **several "Listening on port 8081" messages**. The stopped container wasn't deleted.
Compose **reuses the same container** when it restarts it and reattaches to its stdout log, which
still holds the earlier messages.

### Trying `on-failure`

With `restart: on-failure` and `process.exit(0)` still in place, the container exits with code 0
and **is never restarted**, since that isn't a failure. To see a restart, change the code to any
non-zero number, and remember to use **`docker-compose up --build`** so the image is rebuilt.

### Why `"no"` needs quotes

The other policies can be written raw, but **`no` must be quoted** (single or double quotes). In
YAML a bare `no` is read as the **boolean `false`**, which is not the same as the string `"no"`.

### `always` vs `on-failure`

- **`always`**: for containers that should always be up, like a **public web server** you want
  available 100% of the time.
- **`on-failure`**: for a **worker process** that does a job (say, processing a file) and then
  **exits naturally**. When it finishes you don't want it started again, but if it crashes you do.

---

## 65. Container Status with Docker Compose

The Compose equivalent of `docker ps`:

```sh
docker-compose ps
```

It lists the status of the containers **belonging to this compose file**.

> Compose needs the `docker-compose.yml` as a reference to know which containers you mean. It
> **looks for the file in the current directory**.

Run `docker-compose ps` from a directory with no compose file (for example, one level up) and you
get an error: it has *"no idea what containers you're talking about"*. Many Compose commands have to
be **run from the directory that holds the compose file**.

---

## 66. Visits Application Updated for Redis v5+

An updated version for students who want current Redis versions. The resource
[`visits-redis-v5.zip`](./visits-redis-v5.zip) has the full project.

### `package.json`

```json
{
  "dependencies": {
    "express": "^5.1.0",
    "redis": "^5.8.3"
  },
  "scripts": {
    "start": "node index.js"
  }
}
```

### `index.js`

```js
const express = require("express");
const redis = require("redis");
const process = require("process");

const app = express();
const client = redis.createClient({
  socket: {
    host: "redis-server",
    port: 6379,
  },
});

client.connect();
client.set("visits", 0);

app.get("/", async (req, res) => {
  const visits = await client.get("visits");
  res.send("Number of visits " + visits);
  await client.set("visits", parseInt(visits) + 1);
});

app.listen(8081, () => {
  console.log("listening on port 8081");
});
```

### `docker-compose.yml`

```yaml
version: '3'
services:
  redis-server:
    image: 'redis'
  node-app:
    restart: on-failure
    build: .
    ports:
      - '4001:8081'
```

The **Dockerfile is unchanged** from lecture 57.

### What changed compared with the lecture code

| | Lectures (redis 2.8.0) | Redis v5+ version |
| --- | --- | --- |
| **Dependencies** | `express: "*"`, `redis: "2.8.0"` | `express: "^5.1.0"`, `redis: "^5.8.3"` |
| **Connection options** | `createClient({ host, port })` | Host and port go inside a **`socket`** object: `createClient({ socket: { host, port } })` |
| **Connecting** | Automatic on `createClient` | You call **`client.connect()`** yourself |
| **Reading and writing** | Callbacks: `client.get('visits', (err, visits) => …)` | Promises: the route handler is **`async`** and uses **`await client.get(...)`** / **`await client.set(...)`** |

Things that stay the same: the service name **`redis-server`** as the hostname, port **6379**,
resetting the counter to 0 at startup, **`parseInt`** on the string value, and port **8081**
mapped to **4001**. The zip's `index.js` still requires `process`, but the **`process.exit(0)`
crash line isn't there**. Its compose file uses **`restart: on-failure`**.
