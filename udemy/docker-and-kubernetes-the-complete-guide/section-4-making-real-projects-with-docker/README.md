# Section 4 — Making Real Projects with Docker

Summary of lectures 42–54. The project: build a **tiny Node.js web app**, wrap it in a Docker
container, and reach it from a browser on your local machine (no deployment yet). The Dockerfile is
written **deliberately wrong** at first, so you see the errors you're almost guaranteed to hit on
your own projects, and each one gets fixed in turn:

| Mistake | Symptom | Fix |
| --- | --- | --- |
| `alpine` base image | `npm: not found` | Use `node:alpine` |
| Project files never copied in | `no such file or directory ... package.json` | `COPY ./ ./` before `npm install` |
| No port mapping | Browser says "This site can't be reached" | `docker run -p 8080:8080 ...` |
| Files copied into `/` | Could overwrite system folders like `lib` | `WORKDIR /usr/app` |
| One big `COPY` before `npm install` | Any source edit reinstalls every dependency | Copy `package.json` first, the rest after |

> **The order of instructions in a Dockerfile matters.** Wherever possible, split up the `COPY`
> steps so each step only copies the bare minimum it needs, and a source code change doesn't bust
> the cache for your dependency install.

---

## 42. Project Outline

The goal is to create a small Node.js web application, put it inside a Docker container, and be
able to access it from a browser on your machine. Deployment is out of scope for now.

### The steps

1. Create a Node.js web app.
2. Write a Dockerfile.
3. Build an image from the Dockerfile.
4. Run the image as a container.
5. Connect to the web app from a browser.

If you don't know Node.js (you're more of a Java or Ruby person), that's fine. The JavaScript part
is optional: you can watch the server get built or just download the one or two files you need.

### Disclaimer: planned mistakes

> We're going to do some things in this project a little bit wrong... these are going to be some
> mistakes that I really expect you to make when you start working on Docker on your own projects.

Each error will be clearly flagged as intentional, along with an explanation of what went wrong and
how to fix it.

---

## 43. Node Server Setup

Make a new project folder called `simpleweb` and open it in your editor. (The instructor uses
`code .` because VS Code is set up to launch from the command line. Any editor is fine.)

### `package.json`

This file holds configuration for the Node app. It has one **dependency**, `express` (with `*`
meaning "any version"), and one **script**, `start`, which runs the server:

```json
{
  "dependencies": {
    "express": "*"
  },
  "scripts": {
    "start": "node index.js"
  }
}
```

### `index.js`

The server logic. It requires Express, creates an app, adds **one route handler** for the root
route that replies `Hi there`, and listens on **port 8080**:

```js
const express = require('express');

const app = express();

app.get('/', (req, res) => {
  res.send('Hi there');
});

app.listen(8080, () => {
  console.log('Listening on port 8080');
});
```

Once this runs, visiting the app in a browser should show `Hi there`.

---

## 44. Reminder on BuildKit

**BuildKit** hides much of its build progress, which the legacy builder didn't do. Some output
discussed in the upcoming lectures disappears quickly by default. To see it, pass the progress
flag:

```sh
docker build --progress=plain .
```

To turn off caching as well:

```sh
docker build --no-cache --progress=plain .
```

> *Note - Do not try to use the no-cache flag with Lecture 47 Minimizing Cache Busting*

(Minimizing cache busting is lecture 53 in this folder's numbering.) To **disable BuildKit** and
match the course output:

```sh
DOCKER_BUILDKIT=0 docker build .
```

---

## 45. A Few Planned Errors

### Two npm commands to know

| Command | What it does |
| --- | --- |
| `npm install` | Installs the project's dependencies. **npm** is informally called the Node package manager. |
| `npm start` | Starts the server by running the `start` script. |

Both assume **npm is already installed**, whether on your machine or inside the container.

### Mapping the Redis template onto Node

The Dockerfile template is the same one used for Redis: **specify a base image → run commands to
install dependencies → specify the startup command**.

| Step | Redis image | Node image (first attempt) |
| --- | --- | --- |
| Base image | `FROM alpine` | `FROM alpine` |
| Install dependencies | `RUN apk add redis` | `RUN npm install` |
| Startup command | `CMD ["redis-server"]` | `CMD ["npm", "start"]` |

The instructor warns that something in this plan "doesn't quite line up with... reality."

### Dockerfile, attempt 1

Create `Dockerfile` in `simpleweb`. It starts with a capital D and has no file extension.

```dockerfile
# Specify a base image
FROM alpine

# Install some dependencies
RUN npm install

# Default command
CMD ["npm", "start"]
```

In `CMD`, each part of the command is its own double-quoted string inside square brackets, with
commas between them.

### Building it

```sh
docker build .
```

The build fails almost immediately with **`npm: not found`**. That's the first planned error.

---

## 46. Base Image Issues

### Why npm is missing

The `RUN npm install` step runs inside a temporary container made from the `alpine` image, and
**alpine doesn't include npm**. You pick a base image based on the default programs you need to
build your image. Alpine is tiny (about **5 MB**). The slide shows a tumbleweed for what's in it:
a few basic Linux/Unix programs and the `apk` package manager, and not much else.

> When you are using the alpine image, and you expect to run some fancy web application depending
> upon node JS or depending upon Ruby or Java, chances are you are gonna have to do some additional
> fixes or some additional setup to get this thing working.

### Two ways to fix it

1. **Find a different base image** that already has Node and npm installed (use someone else's
   work).
2. **Keep alpine** and add a `RUN` command that installs Node.js and npm yourself.

The course takes option 1.

### The `node` image on Docker Hub

On **hub.docker.com**, click **Explore** and find the **official** `node` repository (or search for
it). It's an image with Node and npm already installed.

The **Supported tags** section lists every available version. Each **tag** gives you a different
Node.js version. For example, if your app needs Node 6.14:

```dockerfile
FROM node:6.14
```

The syntax is `repository:tag`. When a tag is called `alpine`, that's a **tag**, not the separate
`alpine` repository used before. So you write `node:alpine`.

### What "alpine" means as a tag

> Alpine is a term in the docker world for an image that is as small and compact as possible.

Many popular repositories offer alpine versions. The default `node` image might include extras like
git or text-editing tools. **`node:alpine`** is the most stripped-down version: essentially Node.js
and some very basic programs (maybe `ping`, `cat`, `ls`, a simple editor). This project only needs
Node and npm, so that's plenty.

### Attempt 2

```dockerfile
FROM node:alpine

RUN npm install

CMD ["npm", "start"]
```

Save and run `docker build .` again. The `node:alpine` image downloads and `npm install` starts, but
it now fails with **`no such file or directory ... package.json`**. The file is in the project
directory, but the container can't find it.

---

## 47. A Few Missing Files

npm needs `package.json` to know which dependencies to install, and it can't find it.

### What happens during the build

1. `FROM node:alpine` downloads the node image.
2. `RUN npm install` takes the **file system snapshot** from the previous step, puts it into a
   **temporary container**, and runs `npm install` there.

The only files in that container are **exactly what came out of the node image's file system
snapshot**. The container gets its own segment of the hard drive. The rest of your hard drive,
including `package.json`, isn't connected to it.

> When you are building an image, none of the files inside of your project directory are available
> inside the container by default... you cannot assume that any of these files are available unless
> you specifically allow it inside of your docker file.

The fix is one more instruction that makes `index.js` and `package.json` available before
`npm install` runs.

---

## 48. Copying Build Files

### The `COPY` instruction

**`COPY`** moves files and folders from your local file system into the file system of the
temporary container created during the build.

```dockerfile
COPY ./ ./
```

| Argument | Meaning |
| --- | --- |
| First (`./`) | Path on your machine, **relative to the build context** |
| Second (`./`) | Destination path inside the container |

The **build context** is the `.` you pass to `docker build`. Here that's `simpleweb`, so `./` in the
first argument means the `simpleweb` directory. The instructor admits this is "kind of like two
layers of indirection" and says later projects will show why you'd change the build context.

### Attempt 3

`package.json` has to be there *before* `npm install`, so `COPY` goes right above it:

```dockerfile
FROM node:alpine

COPY ./ ./
RUN npm install

CMD ["npm", "start"]
```

`docker build .` now runs the copy step and then `npm install`. A notice and a few npm warnings are
**totally fine**. The build ends with the new image's ID.

### Tagging and running

IDs are awkward to work with, so tag the image with `<your docker ID>/<project name>`:

```sh
docker build -t stephengrider/simpleweb .
docker run stephengrider/simpleweb
```

- `:latest` is added automatically if you leave the version off the tag.
- **Don't forget the `.`** at the end of the build command.

The container logs show `npm start` running `node index.js` and "Listening on port 8080." But
**`localhost:8080`** in the browser says **"This site can't be reached."** The image builds and the
container runs, but you still can't reach the app.

---

## 49. Container Port Mapping

### Why the browser can't reach it

Your browser requests `localhost:8080`, a port on your own machine. The container has its **own
isolated set of ports**. By default, **no incoming traffic** to your computer gets routed into a
container.

A **port mapping** says: when a request comes in on a given port on your local network,
automatically forward it to a port inside the container.

> This is only talking about **incoming** requests.

A container can reach the outside world by default. You saw this already when `npm install`
downloaded dependencies from the internet during the build. The only limit is on traffic coming
**in**.

### Port mapping is a runtime setting

You **don't** set up port forwarding in the Dockerfile. It's **strictly a runtime constraint**,
set when you start a container with `docker run`:

```sh
docker run -p <incoming port on your machine>:<port inside the container> <image id or name>
```

Stop the running container with **Ctrl+C**, then:

```sh
docker run -p 8080:8080 stephengrider/simpleweb
```

The terminal output looks the same as before, but `localhost:8080` now shows **`Hi there`**.
Requests get forwarded into the container, and the Node app handles them and responds.

### The two ports don't have to match

This is something you'll do often in production apps:

```sh
docker run -p 5000:8080 stephengrider/simpleweb
```

With this, `localhost:8080` gives an error and **`localhost:5000`** reaches the Node server, which
still listens on 8080 inside the container.

You can also change the **container-side** port (6000, 7000, and so on). If you do, the app has to
listen on that port too, so you'd update the `app.listen(8080, ...)` call in `index.js` to match.

> The one big thing to remember is that we have to specify it at runtime, not inside of the docker
> file.

The planned errors so far: a **bad base image**, **not copying `package.json`**, and **no port
forwarding**.

---

## 50. Quiz 8: Quiz on Docker Networking

| # | Question | Correct answer |
| --- | --- | --- |
| 1 | A microservice listens on port 3000 inside the container. Which command exposes it on host port 9000? | **`docker run -p 9000:3000 myapp`** (host port first, container port second) |
| 2 | Multiple containers all need to expose port 80. Which approach works? | **Map them to different host ports** (`8080:80`, `8081:80`, etc.) |
| 3 | Frontend (3000), backend (5000), and database (5432) run as separate containers on the same host. Which statement is correct? | **Each container has its own isolated network namespace** |

Wrong options to note: `-p 3000:9000` has the ports backwards, `docker build -p` puts a runtime flag
on the wrong command, and `--port 9000-3000` isn't the syntax. For Q3, containers do **not**
automatically share a network or talk to each other over `localhost`.

---

## 51. Specifying a Working Directory

### Looking inside the container

Start a shell in the container to see its files. There's no port mapping because the server isn't
started:

```sh
docker run -it stephengrider/simpleweb sh
ls
```

The prompt opens in the container's **root directory**, which now contains the `Dockerfile`,
`package-lock.json` (generated by npm), `package.json`, `index.js`, and `node_modules`. The
`COPY ./ ./` put everything **straight into `/`**.

### Why that's bad practice

If your project has a file or folder with the same name as part of the default file system (`var`,
`root`, `run`, `lib`), you could **accidentally overwrite existing files or folders** in the
container. A `lib` folder in your project is "super, super likely."

### The `WORKDIR` instruction

Instead of just changing the `COPY` destination, use the instruction built for this problem:

```dockerfile
WORKDIR /usr/app
```

**Every instruction after `WORKDIR` runs relative to that folder.** If the folder doesn't exist
in the container, it gets **created automatically**.

Why `/usr/app`? In the Node.js world it doesn't make a big difference where the app lives on
Linux, though there are places you shouldn't put it. The instructor calls the `usr` folder a safe
place. Some Linux diehards would say `var` or the home directory instead, but `/usr/app` will
"probably" be okay.

### Attempt 4

```dockerfile
FROM node:alpine

WORKDIR /usr/app

COPY ./ ./
RUN npm install

CMD ["npm", "start"]
```

Type `exit` to leave the shell, then rebuild (remember the tag) and run:

```sh
docker build -t stephengrider/simpleweb .
docker run -p 8080:8080 stephengrider/simpleweb
```

The new instruction sits **above** `COPY` and `npm install`, so **every step after it reruns with
no cache**, including a full dependency reinstall. `localhost:8080` still works.

### Checking with `docker exec`

In a second terminal window, find the container ID and start a shell in the **running** container:

```sh
docker ps
docker exec -it <container id> sh
```

`-it` connects standard in and gives you a nice-looking terminal. The shell opens **directly in
`/usr/app`**:

> That workdir instruction not only affects commands that are issued later on inside of our Docker
> file, it also affects commands that are executed inside the container later on through the
> Docker exec command.

`ls` shows the project files isolated in that folder. `cd /` followed by `ls` shows the root
directory with nothing that could conflict.

---

## 52. Unnecessary Rebuilds

### Source changes don't show up in the container

Run the container (`docker run -p 8080:8080 stephengrider/simpleweb`), then change the route in
`index.js` from `'Hi there'` to `'Bye there'` and save. Refreshing the browser still shows
**`Hi there`**.

The image, and the container made from it, is built from a **snapshot of the file system** taken
when `index.js` was copied in. Editing the file in your project directory **isn't reflected
automatically** in the container. Live updates need extra configuration, which the next project
covers.

### Rebuilding reinstalls everything

To get the change in, you have to rebuild. Watch what happens on `docker build`:

- Docker sees that a file copied during the `COPY ./ ./` step (step 3) **has changed**.
- So **that step and every step after it** rerun, including `npm install`.

You didn't touch any dependencies, only one source file. With one dependency, reinstalling takes a
few seconds. In a real project, `npm install` could take **several minutes**, and you wouldn't want
to wait for that on every source change.

---

## 53. Minimizing Cache Busting and Rebuilds

### Split the `COPY` in two

`npm install` only needs **`package.json`**. It doesn't care about `index.js` or anything else. So:

1. Copy **only `package.json`**.
2. Run `npm install`.
3. **Then** copy everything else.

### Final Dockerfile

```dockerfile
# Specify a base image
FROM node:alpine

WORKDIR /usr/app

# Install some dependencies
COPY ./package.json ./
RUN npm install
COPY ./ ./

# Default command
CMD ["npm", "start"]
```

`COPY ./package.json ./` looks in the build context directory for `package.json` and copies it into
the container's working directory.

Now you can change `index.js` as much as you want without invalidating the cache for the
`package.json` copy or `npm install`. `npm install` only reruns if **that step or a step above it**
changes, which in practice means **when `package.json` changes**.

### Verifying

```sh
docker build -t stephengrider/simpleweb .
```

| Build | What changed | Result |
| --- | --- | --- |
| 1st | Dockerfile edited | Some steps rerun, then the image is built and tagged |
| 2nd | Nothing | Very fast. Every step comes from the **cache** |
| 3rd | `index.js` changed to send `How are you doing?` | Fast. Only **step 5** (`COPY ./ ./`) and later steps rerun. **`npm install` is skipped** |

You still have to rebuild after source changes, since there's no hot reloading of project files into
the container yet.

> Yes it does make a difference the order in which you put down all these instructions into your
> Docker file and wherever possible it is kind of nice to segment out the copy operations to make
> sure that you are only copying the bare minimum for each successive step.

Showing the wrong way first was on purpose. Seeing the errors happen and then fixing them teaches
more than starting with the correct Dockerfile. Next up is a more advanced Docker project.

---

## 54. Quiz 9: Minimizing Cache Busting

**Setup:** a Python project has `requirements.txt` (dependencies installed by `pip`, which takes
several minutes, and **rarely changes**) and `main.py` (**changes very often**). The current
Dockerfile rebuilds slowly after every change to `main.py`:

```dockerfile
FROM python
WORKDIR /app
ADD ./ ./
RUN pip install -r requirements.txt
CMD ["python", "main.py"]
```

**Question:** how can you change the Dockerfile to speed up the build?

**Correct answer:** add `requirements.txt` by itself, install, *then* add `main.py`. This is the
same pattern as lecture 53:

```dockerfile
FROM python
WORKDIR /app
ADD ./requirements.txt ./
RUN pip install -r requirements.txt
ADD ./main.py ./
CMD ["python", "main.py"]
```

The wrong options:

- Adding `main.py` **before** the install and `requirements.txt` **after** it doesn't work, because
  `pip install` runs before `requirements.txt` exists in the image, and a change to `main.py` still
  busts the install step.
- `COPY ./* ./` before the install is the same single-copy problem as the original.
