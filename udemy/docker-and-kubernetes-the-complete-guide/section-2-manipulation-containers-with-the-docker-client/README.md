# Section 2 — Manipulating Containers with the Docker Client

Summary of lectures 12–27. This section is a tour of the **Docker client (Docker CLI)** and the very
basic commands used to interact with containers and images: creating and running containers,
overriding the startup command, listing, restarting, stopping, and removing containers, reading
their logs, and running additional programs (including a shell) inside a running container. The
instructor warns up front that it's mostly "typing in commands and looking at the output," so the
value is in understanding what each command does to a container's **life cycle**.

Two mental models tie everything together:

- An **image** is a **file system snapshot** plus a **default startup command**.
- **Creating** a container is about the file system; **starting** it is about executing the startup
  command.

> Having a solid understanding of the life cycle of a container is gonna be so incredibly useful
> later on, when it really comes down to figuring out how to troubleshoot these things and debug a
> running container.

### Command cheat sheet

| Command | What it does |
| --- | --- |
| `docker run <image>` | Create **and** start a container from an image (= `docker create` + `docker start`), showing its output |
| `docker run <image> <command>` | Same, but **override** the image's default startup command |
| `docker ps` | List **running** containers |
| `docker ps --all` | List **all** containers ever created, including exited ones |
| `docker create <image>` | Prep the file system snapshot for a new container; prints the container ID |
| `docker start <id>` | Run the container's startup command; prints only the ID by default |
| `docker start -a <id>` | Start and **attach** — watch for output and print it to the terminal |
| `docker logs <id>` | Retrieve everything a container has emitted, **without** rerunning it |
| `docker stop <id>` | Send **SIGTERM**; falls back to kill after 10 seconds |
| `docker kill <id>` | Send **SIGKILL**; shut down immediately |
| `docker exec -it <id> <command>` | Execute an **additional** command inside a running container, with input attached |
| `docker exec -it <id> sh` | Open a **shell** inside a running container |
| `docker run -it <image> sh` | Start a new container with a shell as its primary process |

---

## 12. Docker Run in Detail

The first command: **create and run a container using an image**.

```sh
docker run <image name>
```

We've already done this once with `docker run hello-world` and saw its message on screen. With what
we now know about containers, here's what probably happened behind the scenes:

1. Somewhere on the hard disk is an image with a **file system snapshot** containing a single
   program (maybe called "hello world" — who knows what it's really called).
2. Docker took that snapshot and stuck it into the container (the grouping of resources).
3. It executed the startup command, so the running process was that hello world program.
4. The program ran and then **exited**.

There are a lot of variations and small subtleties around `docker run`, covered next.

---

## 13. Overriding Default Commands

Reminder: any time we `docker run` an image, we get both the file system snapshot **and** a default
command meant to execute after the container is created. You can **override** that default:

```sh
docker run <image name> <command>
```

Whatever default command is included inside the image is **not** executed.

### Trying it with busybox

```sh
docker run busybox echo hi there    # prints: hi there
docker run busybox echo bye there   # change the text as much as you please
docker run busybox ls               # lists files and folders in the container's root
```

`ls` prints folders like `bin`, `dev`, `etc`, `home`, `proc`, `root`, `sys`, `usr`, and `var`. If
you're on Windows these might look strange — and that's the point: **these folders don't belong to
your computer; they exist solely inside that container.** They come from the busybox image's
default file system snapshot, which was put in as the container's file system before `ls` ran.

### Why busybox and not hello-world?

```sh
docker run hello-world ls              # nasty error message
docker run hello-world echo hi there   # very similar error
```

The override commands work with busybox because **`ls` and `echo` are executables that exist inside
the busybox file system image**. The hello-world snapshot contains just one single program whose
only job is to print its message.

> These startup commands that we are executing are being based upon the file system included with
> the image. And if we try to execute a command inside the container that uses a program that is
> not contained within this file system, we're going to see that error.

---

## 14. Listing Running Containers

```sh
docker ps
```

Lists all **running** containers on your machine. So far it only shows table headers, because every
container we've run starts up and almost immediately exits (e.g. `docker run busybox echo hi
there`).

### Getting a long-running container

Override the startup command with something that keeps going:

```sh
docker run busybox ping google.com
```

This pings Google's servers and measures latency (about two or three milliseconds for the
instructor), and it keeps running for quite a long time. In a **second terminal window**,
`docker ps` now shows it. The columns:

| Column | Meaning |
| --- | --- |
| **Container ID** | Used for lots of other operations on a specific container |
| **Image** | The image the container was created from |
| **Command** | The startup command, here `ping google.com` |
| **Created** | How long ago it was created |
| **Status** | e.g. "Up 24 seconds" |
| **Ports** | Any ports opened for outside access (covered much later in the course) |
| **Names** | A **randomly generated name** to identify the container ("Epic Corey" for the instructor) |

Press **Ctrl+C** in the ping window to stop it; run `docker ps` again and it's gone.

### Listing every container

```sh
docker ps --all
```

Shows **all containers ever created** on the machine — ones shut down on our behalf or shut down
naturally, all with status **Exited**.

The most common use of `docker ps` is not just seeing what's running, but **getting the ID of a
running container**, because we very frequently need to issue commands on a specific container.

---

## 15. Container Lifecycle

`docker ps --all` begs the question: when and why does a container get shut down, and what happens
then? To answer it, start at the beginning — what happens when a container is **created**.

### `docker run` = `docker create` + `docker start`

Creating and running are **two separate processes**:

```sh
docker run <image>
# is identical to
docker create <image>
docker start <container id>
```

| Step | What it touches |
| --- | --- |
| **Create** | Takes the image's file system snapshot and **preps / sets it up** for use in the new container |
| **Start** | **Executes the startup command** (hello world, `echo hi there`, whatever process it is) |

> Creating a container is about the file system. Starting it is about actually executing the
> startup command.

### Trying it out

```sh
docker create hello-world
# prints a long string of characters: the ID of the container just created

docker start -a <that id>
# prints the familiar hello-world welcome message
```

Running `docker start <id>` **without** `-a` just prints the ID back.

- **`-a`** means **attach** to the container: watch for output coming from it and print it out at
  your terminal.

So there's a small difference in defaults:

- **`docker run`** shows you all the logs / information coming out of the container **by default**.
- **`docker start`** is the opposite — it does **not** show output unless you pass `-a`.

---

## 16. Restarting Stopped Containers

The instructor's `docker ps --all` list is down from about 30 exited containers to one, because they
cleared them out between videos (the command is shown next lecture). To get on level footing:

```sh
docker run busybox echo hi there
docker ps --all    # verify its status is Exited
```

### A stopped container isn't dead

When a container is exited, **we can still start it back up**:

```sh
docker start -a <container id>    # prints "hi there" again
```

Without `-a` you wouldn't see any output, so `-a` is more useful here.

What happened: the busybox file system snapshot was referenced inside the container at create/run
time; the override `echo hi there` became the container's primary command; it ran, completed, and
the container exited naturally. Running `docker start` again **reissued that same primary command**
inside the container.

### You can't replace the command on restart

Once a container has been created with its command, **that's it — the command is in place**.

```sh
docker start -a <container id> echo bye there   # does NOT work
```

Docker misinterprets this: it thinks you're trying to start up **multiple containers** at the same
time. Restarting an exited container always reissues the command it was first created with.

---

## 17. Removing Stopped Containers

`docker ps --all` shows two stopped containers. Stopped containers are essentially **just taking up
disk space**, so it can be to your advantage to entirely delete them rather than leave them in the
stopped state.

> **Note:** the transcript for this lecture ends mid-sentence at "To delete all these
> containers, …" — the actual command isn't included in the source file.

---

## 18. Retrieving Log Outputs

Catch with `docker create` + `docker start`: you only see output if you remember `-a`. Imagine the
start was an expensive process that took many minutes — forgetting `-a` means rerunning
`docker start -a` and waiting another couple of minutes.

The fix:

```sh
docker logs <container id>
```

**Retrieves all the information that has been emitted from a container.**

```sh
docker create busybox echo hi there
docker start <id>      # runs echo hi there and immediately exits
docker logs <id>       # prints: hi there
```

> By running `docker logs`, I'm not rerunning or restarting the container in any way, shape or
> form. I'm just getting a record of all the logs that have been emitted from that container.

`docker logs` will be used a lot for debugging and setting up new containers — it's a really good
way to inspect a container and see what's going on inside it.

---

## 19. Stopping Containers

An oddity: create and start a long-running container **without** attaching.

```sh
docker create busybox ping google.com
docker start <id>     # just echoes the ID back
docker logs <id>      # yep, it's running ping
docker ps             # container is running and continues to ping
```

Ping will go on forever. Previously we hit Ctrl+C or let the container stop itself (as with echo).
For a container running amok on its own, use **`docker stop`** or **`docker kill`**.

### stop vs. kill

```sh
docker stop <container id>
docker kill <container id>
```

Both send a signal to the **primary process** inside the container:

| Command | Signal | Meaning |
| --- | --- | --- |
| `docker stop` | **SIGTERM** (terminate signal) | Shut down **on your own time**. Gives the process a little time to clean up — many languages let your code listen for this signal and then save a file, emit a message, etc. |
| `docker kill` | **SIGKILL** (kill signal) | Shut down **right now**; no additional work allowed. |

- Ideally, **always stop with `docker stop`** so the process can shut itself down.
- Use `docker kill` if the container has locked up and isn't responding to `docker stop`.
- **If the container doesn't stop within 10 seconds of `docker stop`, Docker automatically falls
  back to `docker kill`.** Stop is Docker "being nice," but with only 10 seconds' grace.

### Demo

```sh
docker ps                  # ping google.com container still running
docker stop <id>           # waits ~10 seconds...
```

The wait happens because **`ping` doesn't properly respond to SIGTERM** — it just wants to run
forever — so after 10 seconds the kill signal is sent.

```sh
docker start <id>
docker kill <id>           # instantly dead, no grace period
```

Get the ID ahead of time with `docker ps`, then use stop or kill. The general recommendation is
`docker stop`; if the process won't shut down nicely, Docker falls back to kill anyway.

---

## 20. Quiz 2 — Container Management

| # | Question | Correct answer |
| --- | --- | --- |
| 1 | Debug a container that ran yesterday and exited, **without restarting it**? | `docker logs CONTAINER_ID` |
| 2 | Status **"Exited (0)"** in `docker ps -a` indicates what? | The container's main process **completed successfully** |
| 3 | Container `abc123` processes data files — how to run the same job again? | `docker start abc123` |
| 4 | Created with `docker create ubuntu echo "test"`; after starting once, can it run `echo "production"` instead? | **No** — you must create a new container; the command becomes part of the container's immutable configuration |

---

## 21. Multi-Command Containers

Earlier in the course we started **Redis** (an in-memory data store commonly used with web apps)
with Docker. There's an oddity around it.

### The normal, non-Docker way

With Redis installed locally (you probably don't have it — don't run these):

```sh
redis-server        # terminal 1: starts the in-memory server
redis-cli           # terminal 2: a prompt that reaches into the server
```

```
set mynumber 5
get mynumber        # 5
```

The **redis-cli** is the common way to poke into the server and inspect its data.

### With Docker

```sh
docker run redis
```

Ignore any warnings; just make sure the last line says **"Ready to accept connections."** That's the
Redis **server**. Now try to reach it with the CLI: typing `redis-cli` in the same window does
nothing, and running it in a second terminal gives "command not found" (or, for the instructor,
"Could not connect to Redis").

Why: **Redis is running only inside the container.** Outside the container we have no access to
anything going on inside it. To use the CLI we need to get into the container and **start up a
second program inside it**.

---

## 22. Executing Commands in Running Containers

```sh
docker exec -it <container id> <command>
```

- **`exec`** — short for **execute**; runs an **additional** command inside a running container.
- **`-it`** — allows us to type input directly into the container.

### Demo

```sh
docker ps                              # confirm redis is running, grab its ID
docker exec -it <container id> redis-cli
```

```
set myvalue 5
get myvalue         # 5
```

We now have a second running program inside the container, and `-it` lets keyboard input be sent
into it.

### Without `-it`

```sh
docker exec <container id> redis-cli
```

You're kicked straight back to your terminal. `redis-cli` started, realized it had **no possibility
of getting any text input**, and closed down entirely. This idea of attaching input turns out to be
rather important in the world of Docker.

---

## 23. The Purpose of the IT Flag

Every container runs inside a **Linux virtual machine**, so even on Mac or Windows, these processes
are really executing in a Linux world.

### stdin, stdout, stderr

Every process in a Linux environment has **three communication channels** attached:

| Channel | Direction | Example |
| --- | --- | --- |
| **stdin** | Into the process | What you type at the terminal is directed into redis-cli's stdin |
| **stdout** | Out of the process | Redirected to your terminal, shows up on screen |
| **stderr** | Out of the process, error in nature | Also redirected to show up on your terminal |

### `-it` is two flags

`-it` is 100% equivalent to `-i -t`; shortening it is just convention.

- **`-i`** — attach our terminal to the **stdin** channel of the new process, so whatever we type
  goes to redis-cli.
- **`-t`** — makes the text going in and coming out show up **nicely formatted**. It does a little
  more behind the scenes, but that's the effect.

### Demo with only `-i`

```sh
docker exec -i <container id> redis-cli
```

It waits for input, but there's no nicely formatted prompt/indentation and **no auto-complete**.
`set myvalue 5` still returns `OK` and `get myvalue` still returns the value — it's just not
pretty.

---

## 24. Getting a Command Prompt in a Container

Probably the **most common** use of `docker exec` in your own projects: getting **shell / terminal
access** to a running container, so you don't have to run `docker exec` again and again all day.

```sh
docker ps                        # get the redis container's ID
docker exec -it <container id> sh
```

You get a `#` prompt and can run typical Unix commands in the context of the container:

```sh
cd ~          # home directory (empty)
cd /
ls            # the container's root files and folders
echo hi there
export b=5
echo $b
redis-cli     # even start redis-cli from here
```

> When I make use of this `docker exec` command with `sh` over here I get full terminal access inside
> the context of the container, which is extremely powerful for debugging.

**Can't exit with Ctrl+C?** Try **Ctrl+D**.

### What is `sh`?

`sh` is a program executed inside the container: a **command processor, or shell**, which lets you
type commands and have them executed. You already use one on your own machine — **Bash** on macOS,
**Git Bash** or **PowerShell** on Windows; the instructor uses **Z shell**.

- Most containers you'll work with have **`sh`** already included.
- Some more complete images also include **`bash`**, so sometimes you can use Bash directly.

Expect to use `docker exec -it <id> sh` very often in your own Docker development.

---

## 25. Starting with a Shell

You can also get a shell **immediately when the container first starts**, using `docker run` with
`-it`:

```sh
docker run -it busybox sh
```

This means: create a new container from busybox, run the `sh` program (a shell) as the primary
command, and attach to its stdin. From the prompt you can `ls`, `ping google.com` (Ctrl+C to stop),
`echo` a message — whatever you want. Useful for getting an empty container with a shell and just
**poking around** with no other process running.

**Downside:** a shell as the startup command **displaces the default command**, so you probably
won't be running any other process. It's more common to start the container with its primary
process (e.g. your web server) and then **attach a shell with `docker exec`**.

---

## 26. Container Isolation

**Exiting a shell:** if Ctrl+C doesn't work, press **Ctrl+D** or type **`exit`**.

Recall the earlier namespacing example: Chrome and Node.js each needing their own version of
Python, each getting its own segment of the hard disk. The point to make crystal clear:

> Between two containers, they do not automatically share their file system.

### Demo

```sh
# terminal 1
docker run -it busybox sh
ls

# terminal 2
docker run -it busybox sh

# terminal 3
docker ps     # two separate containers, both running a shell

# terminal 1
touch hithere
ls            # hithere is listed

# terminal 2
ls            # hithere is NOT there
```

The two running containers have **completely separate file systems** with no sharing of data.
**Unless you specifically form up a connection between two containers**, consider them more or less
completely **isolated** from each other.

That wraps up the basics of the Docker client.

---

## 27. Quiz 3 — Docker Command Execution

| # | Question | Correct answer |
| --- | --- | --- |
| 1 | Check which npm packages are installed in a running Node.js container? | `docker exec CONTAINER_ID npm list` |
| 2 | Relationship between stdin, stdout, and the `-it` flags? | **`-i`** connects to stdin, **`-t`** formats the terminal output |
| 3 | Run without attach flags (such as `-a stderr`) — where does stderr output typically go? | Without proper flags, stderr output would be **lost** |
| 4 | Most flexible approach for troubleshooting a web app in a container? | `docker exec -it CONTAINER_ID sh` — shell access lets you inspect logs, config files, environment variables, network settings, and running services **from inside** the environment |
