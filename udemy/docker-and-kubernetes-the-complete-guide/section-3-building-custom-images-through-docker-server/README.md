# Section 3 — Building Custom Images Through Docker Server

Summary of lectures 28–41. Up to now every image we used (hello-world, redis, busybox) was built
by other engineers. This section is about building **our own custom images** so we can run our own
applications inside our own personalized containers. The vehicle is a **Dockerfile**: a plain-text
file of configuration that we hand to the **Docker client** (the CLI), which passes it to the
**Docker server**, which does the heavy lifting and builds a usable image.

The worked example throughout is an image that runs **Redis server** on startup, built (somewhat)
from scratch on top of Alpine.

> **Every instruction takes the image from the previous step, creates a temporary container out of
> it, runs a command or changes its file system, snapshots the result, and saves it as the image
> for the next instruction.** The image produced by the last step is the final image. Caching,
> ordering, and even `docker commit` all fall out of this one flow.

---

## 28. Creating Docker Images

### The flow

```
Dockerfile  →  Docker client (CLI)  →  Docker server  →  usable image
```

- **Dockerfile** — a plain-text file with a few lines of configuration that define how our
  container behaves: what programs it contains and what it does when it starts up.
- **Docker client** — the `docker` CLI at our terminal; it provides the file to the server.
- **Docker server** — reads every line of configuration and builds the image that can then be
  used to start new containers.

### The Dockerfile template

All the complexity sits in the Dockerfile, but it's mostly just a few new commands — and just
about every Dockerfile we write will look the same:

1. **Specify a base image.**
2. **Run some commands** to install additional dependencies, software, or programs the container
   needs.
3. **Specify a startup command** — the command executed to boot up the container whenever one is
   created from the image.

---

## 29. Buildkit for Docker Desktop

Recent versions of Docker have **Buildkit enabled by default**, so build output looks slightly
different from the lecture videos.

### The final step

| Builder | Final output | Image ID |
| --- | --- | --- |
| Legacy (as in the lectures) | `---> fc60771eaa08` / `Successfully Built fc60771eaa08` | `fc60771eaa08` |
| Buildkit | `=> => exporting layers` / `=> => writing image sha256:ee59c34a…` | `ee59c34ada9890ca09145cc88ccb25d32b677fc3b61e921` |

Either ID is what you pass to `docker run`:

```sh
docker run fc60771eaa08
# or
docker run ee59c34ada9890ca09145cc88ccb25d32b677fc3b61e921
```

Buildkit also omits the `CMD` instruction from the visible output. That's cosmetic — it doesn't
affect the image.

### Seeing more output

Buildkit hides much of its progress (the legacy builder didn't). Some messages and errors
discussed in Section 4 are hidden by default. To see them:

```sh
docker build --progress=plain .
```

To also disable caching:

```sh
docker build --no-cache --progress=plain .
```

*Note: don't use `--no-cache` with Lecture 47, Minimizing Cache Busting.*

### Matching the course output

Disable Buildkit for a single build:

```sh
DOCKER_BUILDKIT=0 docker build .
```

### Further reading

- https://docs.docker.com/develop/develop-images/build_enhancements/
- https://docs.docker.com/engine/reference/commandline/build/#specifying-external-cache-sources
- https://www.docker.com/blog/advanced-dockerfiles-faster-builds-and-smaller-images-using-buildkit-and-multistage-builds/

---

## 30. Building a Dockerfile

**Goal:** a Dockerfile that creates an image which runs **Redis server** whenever it starts up.
We've already used the official `redis` image; this shows how to build that thing (somewhat) from
scratch.

### Setup

```sh
mkdir redis-image
cd redis-image
code .          # VS Code, if configured to launch from the command line
```

Any editor works — just open the `redis-image` directory. Create a file named **`Dockerfile`**:
capital **D**, **no extension** (no `.js`, no `.sh`, nothing).

### The Dockerfile

Comments start with `#` and follow the three-step template. The lecture deliberately writes it
"blind" first and explains it afterwards, since it's easier to understand once you've seen an
image built.

```dockerfile
# Use an existing docker image as a base
FROM alpine

# Download and install a dependency
RUN apk add --update redis

# Tell the image what to do when it starts as a container
CMD ["redis-server"]
```

### Build and run

From inside `redis-image`:

```sh
docker build .          # don't forget the trailing dot
```

Output streams by and ends with `Successfully built <id>`. Copy that ID and run it:

```sh
docker run <id>
```

You see the same Redis output as with the official image, ending with **`Ready to accept
connections`**. Stop the container with **Ctrl+C**.

---

## 31. Dockerfile Teardown

Every line in a Dockerfile has the same shape: an **instruction** followed by an **argument**.

- The **instruction** (a single word) tells the Docker server to do a specific preparation step on
  the image being created.
- The **argument** customizes how that instruction is executed.

| Instruction | Argument | Purpose |
| --- | --- | --- |
| **`FROM`** | `alpine` | Specify the Docker image to use as a **base**. |
| **`RUN`** | `apk add --update redis` | Execute a command **while preparing** the custom image. |
| **`CMD`** | `["redis-server"]` | Specify what should be executed when the image is used to **start up a new container**. |

`FROM`, `RUN`, and `CMD` are the three most important instructions to know. There are quite a
handful of others, and more will be introduced over the course.

---

## 32. What's a Base Image?

### The analogy

Writing a Dockerfile is like being handed a **brand-new computer with no operating system** and
told to install Google Chrome.

1. Turn it on → "no bootable drive / no operating system."
2. **Install an operating system.**
3. Open the default browser → go to chrome.google.com → download the installer.
4. Open a file explorer → execute the installer.
5. Run the Chrome executable.

Steps 3–5 all depend on the OS from step 2: without it there's no default browser, no file or
folder explorer, and no way to run an executable.

| Computer analogy | Dockerfile |
| --- | --- |
| Install an operating system | `FROM alpine` |
| Download and install Chrome | `RUN apk add --update redis` |
| Execute chrome.exe | `CMD ["redis-server"]` |

By default a new image is **empty** — no infrastructure, no programs to navigate a file system,
nothing to download, install, or configure dependencies. The **base image** gives an initial
starting point: an initial set of programs we can use to further customize the image.

### Why Alpine?

Why do you use Windows, macOS, or Ubuntu? Because its **set of pre-installed programs** suits your
needs. Same here: Alpine includes a default set of programs that is very useful for installing
and running Redis.

The most useful one appears on line two. **`apk add --update redis` is not a Docker command** — it
has nothing to do with Docker. `apk` is a **package manager that comes pre-installed on the Alpine
image**, and we use it to automatically download and install Redis. (In the video the instructor
guesses the name as "Apache Package something"; `apk` is Alpine's own package manager.)

---

## 33. The Build Process in Detail

### `docker build .`

- **`docker build`** — takes a Dockerfile and generates an image out of it (the CLI hands the file
  to the Docker server).
- **`.`** — the **build context**: the set of files and folders belonging to our project that we
  want to encapsulate in the container. Better examples come later as builds get more complex.

### Reading the (legacy) output

- There's **one step per line of configuration**: `Step 1/3`, `Step 2/3`, `Step 3/3`.
- **Step 1 (`FROM alpine`)** — the server checks the **local build cache** for an image called
  Alpine. It hasn't downloaded it before, so it reaches out to **Docker Hub** (the repository of
  free public images) and downloads it: `Pull complete`, `Downloaded newer image for
  alpine:latest`.
- **Steps 2 and 3** each show `Running in <id>` and later `Removing intermediate container <id>`
  with the **same ID**. That's the ID of a container. Step 1 has no such printout — so every
  instruction besides the first creates some container.

### What actually happens

Recall that an image is a **file system snapshot + a startup command**.

**Step 2 — `RUN apk add --update redis`**

1. The server looks at the image output by the previous step (the Alpine image).
2. It creates a **temporary container** from it (the `Running in …` line), with Alpine's file
   system snapshot inside.
3. The command runs inside that container **as its primary running process**. `apk` downloads and
   installs Redis and a couple of its dependencies onto the container's hard drive.
4. The container is **stopped**, its **file system snapshot** is taken and saved as a **temporary
   image** (ID `38ec…` in the lecture), and the intermediate container is thrown away.

The output of step 2 is a new image containing just the changes made during that step: Alpine
plus Redis.

**Step 3 — `CMD ["redis-server"]`**

1. Take the image from the previous step (`38ec…`) and create a new temporary container from it.
2. `CMD` **sets the primary command** of the container. It does **not** execute `redis-server` —
   it just tells the container, "if you were ever to run for real, `redis-server` should be your
   primary command."
3. Shut down the container, snapshot its **file system and its primary command**, and save it as
   an image (`fc60…`). Remove the intermediate container.

The final image `fc60…` has the full file system snapshot with Redis installed and a startup
command of `redis-server` — that's the `Successfully built` ID.

> Along **every step** with every additional instruction, we take the image generated during the
> previous step, create a new container out of it, execute a command in the container or make a
> change to its file system, take a snapshot of its file system, and save it as output for the next
> instruction. When there are no more instructions, the image from the last step is output as the
> final image.

---

## 34. A Brief Recap

The same flow, one more time (skip it if you've got it):

1. **`FROM alpine`** — the Docker server (daemon) downloads the Alpine image, used as a base
   because it comes with handy pre-installed programs.
2. **`RUN apk add --update redis`**
   - Get the image from the previous step (Alpine).
   - Create a very temporary container from it.
   - Execute `apk add --update redis` inside; Redis is installed into the container's file system.
   - Result: a container with a **modified file system**. Snapshot it, shut down the temporary
     container, and pass the image along — essentially Alpine with Redis on top.
3. **`CMD ["redis-server"]`**
   - Get the image from the previous step and create a temporary container from it.
   - Instead of executing a command (the purpose of `RUN`), `CMD` specifies what the image should
     do when started as a container: execute `redis-server`.
   - Result: a container with a **modified primary command**. Shut it down and take an image out of
     it.
4. No more instructions → the image generated by the last instruction is the output.

Not super critical to know in depth, but a good grasp of this flow makes the rest of Docker a lot
easier.

---

## 35. Quiz 4: On FROM

**Q1. What does the `FROM` command do?**
**Answer:** `FROM` copies the **filesystem snapshot and default command** from another image into
the custom image we are building. (Not only the filesystem; and not an OOP inheritance chain.)

**Q2 (tricky).** `hello-world`'s filesystem snapshot contains exactly one file, the `hello`
program, and no other programs. What happens building this?

```dockerfile
FROM hello-world
RUN apk add nodejs
CMD ["node", "-e", "console.log('hi there');"]
```

**Answer:** An **error during `RUN apk add nodejs`**, because the image doesn't have an `apk`
program — it didn't inherit `apk` from `hello-world`. (`hello-world` *is* a valid base image; it
just lacks the tools.)

---

## 36. Quiz 5: On the Alpine Images

**Q1. Why do we use `alpine` as a base image?**
**Answer:** **All of the above** — Alpine includes a default set of programs useful for setting up
a custom image, *and* it's a very small image, so Docker can create containers from it slightly
faster.

**Q2. Are all custom images required to use `alpine` as a base image?**
**Answer:** **No.**

---

## 37. Rebuilds with Cache

This is where Docker gets much of its **performance** when building images.

### Adding an instruction

Add a second, arbitrary dependency (nothing important about GCC — it's just a second dependency):

```dockerfile
FROM alpine
RUN apk add --update redis
RUN apk add --update gcc
CMD ["redis-server"]
```

The new step produces an image identical to the previous one plus GCC. Rebuild with
`docker build .`:

- **Step 1/4 (`FROM alpine`)** — no fetching; Alpine is already downloaded.
- **Step 2/4 (`redis`)** — no `Running in …`, no fetch, no install. Just **`Using cache`**. Docker
  knows the previous step yields the same image and the instruction is identical, and it already
  has the resulting image cached on the local machine — so it reuses it instead of redoing the
  work.
- **Step 3/4 (`gcc`)** — a new instruction. Something changed, so from here on the cache can't
  be used: create container, run command, snapshot, and so on.

### Rebuilding unchanged

Run `docker build .` a **third time** with no changes: the build is extremely fast. Every step —
Alpine, the Redis `RUN`, the GCC `RUN`, the `CMD` on top of the GCC step — comes from cache.

### Reordering breaks the cache

Move the GCC line **above** Redis:

```dockerfile
FROM alpine
RUN apk add --update gcc
RUN apk add --update redis
CMD ["redis-server"]
```

The end result still contains Alpine + GCC + Redis, but the **order of operations** changed.
Alpine comes from cache, but there's no cached "Alpine then GCC" image (last time GCC was added
after Redis). So on the fourth build, Docker reruns the GCC step, the Redis step, and the `CMD`.

> Any time we change the Dockerfile, we only rerun the series of steps **from the changed line on
> down**. If you expect to change your Dockerfile, put those changes **as far down as possible**.

A later example shows how reordering can dramatically change how long a rebuild takes.

---

## 38. Tagging an Image

Copying the ID from `Successfully built …` into `docker run <id>` works, but it's a pain compared
to `docker run redis` or `docker run hello-world`. **Tagging** gives the image a name we choose.

### The convention

```
<your Docker ID>/<project name>:<version>
```

- **Docker ID** — your Docker ID.
- **Project name** — anything you like (`redis`, `redis-server`, …).
- **Version** — traditionally a number; for the newest build, **`latest`**.

Images like `redis`, `hello-world`, and `busybox` have simpler names because they're **community
images** — created by the community and open-sourced for popular use. Any image **you** create is
always prefixed with your Docker ID.

### Building with a tag

```sh
docker build -t stephengrider/redis:latest .
```

Don't forget the trailing `.` — the build context is still required. The output says `Successfully
built <id>` and then `Successfully tagged stephengrider/redis:latest`. Run it by name:

```sh
docker run stephengrider/redis
```

The version can be left off; **`latest` is used by default**.

### Nitpick: what "the tag" is

We call the whole process **tagging the image**, and the flag is `-t`, but technically **only the
version on the end is the tag**. The rest (`stephengrider/redis`) is the **repository / project
name**. Worth knowing because documentation can be confusing on this.

---

## 39. Manual Image Generation with Docker Commit

Not something you'll do often (or ever) — but it clarifies the relationship between images and
containers. We use images to create containers, but the build process shows **the opposite is also
true**: we can take a container and generate an image from it. So we can manually emulate what the
Dockerfile does.

### Terminal 1 — make a container and modify it

```sh
docker run -it alpine sh
# inside the container's shell:
apk add --update redis
```

The running container's file system now includes Redis.

### Terminal 2 — commit it as an image

```sh
docker ps                                          # get the running container's ID
docker commit -c 'CMD ["redis-server"]' <container-id>
```

- **`docker commit`** — takes a snapshot of the running container and generates an image from it.
- **`-c`** — specifies the default command. Note the quoting: single quotes around the whole
  thing, double quotes around `redis-server` inside the square brackets.

The output is the (long) ID of the new image.

### ID shortcut

You **don't have to copy an entire ID or hash**. A segment of leading characters is assumed unique
enough for Docker to work out which one you mean:

```sh
docker run <first few characters of the image id>
```

That starts a container with Redis installed and `redis-server` as its default command — the usual
Redis output appears.

> In general you **don't use `docker commit`**. Use the Dockerfile approach, because it lets you
> easily rerun the series of steps in the future. The point here is just that there's a very fluid
> relationship between containers and images.

---

## 40. Quiz 6: Image Tags

**Q1.** A Python project written for *only Python 3.8* uses:

```dockerfile
FROM python
RUN ["python", "main.py"]
```

It works. Three years later you change the project, rebuild, and creating a container fails. One
possible reason?

**Answer:** No version of the `python` image was specified, so Docker automatically used the
**`latest`** tag. The initial build may have got Python 3.8, but the rebuild three years later
may have got Python 4.5 (or some future version).

---

## 41. Quiz 7: Image Tagging

**Q1. After `docker build . -t app1`, how do you run the image?**
**Answer:** `docker run app1`. (The command is valid — the flag can come after the context.)

**Q2. After `docker build .` prints `writing image sha256:9dfadec01fefd446b8a918b`, how do you tag
it `app1`?**
**Answer:** `docker tag 9dfa app1` — a short leading segment of the ID is enough.

**Q3. Which `tag` command follows naming conventions?**
**Answer:** `docker tag ece24c dockeruser/my-fancy-image` — Docker ID, slash, image name. (Not
`my-fancy-image` alone, and not `dockeruser:my-fancy-image`.)

**Q4. What's true of `dockeruser/webapp:1.4.3-alpine3.10`?**
**Answer:** This is image **version 1.4.3**, and it likely used a base image of **Alpine v3.10**.
