# Section 1 — Dive Into Docker!

Summary of lectures 1–11. The section opens the two questions the whole course keeps answering:
**why do we use Docker?** and **what is Docker?** A quick Redis demo answers the first; the second
starts with two pieces of terminology — **image** and **container** — and a look at the two tools
that ship inside Docker Desktop, the **Docker client** and the **Docker server**. The rest of the
section installs Docker on macOS, Windows (WSL), or Linux and ends with a short quiz.

> **Docker makes it really easy to install and run software on any computer** — your laptop, a web
> server, or any cloud platform — without a whole bunch of setup or installation of dependencies.

---

## 01. Finished Code and Diagrams

- **Finished code** is attached to each applicable lecture throughout the course. If you get stuck,
  download it and compare against your own with a diff tool such as
  [Diffchecker](https://www.diffchecker.com/) or VSCode's built-in comparison.
- **Diagrams** from the course come as a zip file (extracted here in `./diagrams/`). Open them in
  [diagrams.net (formerly draw.io)](https://www.diagrams.net/):
  - **Open Existing Diagram** → pick the file from your computer, or
  - **File** → **Open From Device** → pick the file.
- If a diagram is missing, it's no longer available to share — take a screenshot of the video
  lecture instead (e.g. with Awesome Screenshot).

---

## 02. Why Use Docker?

### The installation-failure loop

A flow you've probably been through at least once:

1. Download an installer and run it.
2. Get an **error message** during installation.
3. Troubleshoot on Google, find a fix.
4. Rerun the installer — ta-da, **some other error** appears.
5. Go through the entire troubleshooting process again.

> This is, at its core, what Docker is trying to fix.

### The demo: installing Redis the hard way

**Redis** is an in-memory data store (used quite a bit throughout the course). Its official download
page proudly says "just run these four commands." Running the first one in the terminal immediately
fails — it complains about a program that simply isn't installed on the machine. You *could*
install that program and try again, but that's the whole point: you end up in an **endless cycle of
troubleshooting** while installing and running software.

### The demo: running Redis with Docker

One single command:

```sh
docker run -it redis
```

After a very brief pause — almost instantaneously — an instance of Redis is up and running.

> **Why use Docker?** Because it makes life really easy for installing and running software without
> having to go through a whole bunch of setup or installation of dependencies.

More reasons come later in the course; this is the quick first answer.

---

## 03. What Is Docker?

This question is a lot more challenging to answer. When someone says "I use Docker on my project,"
they're referring to an **entire ecosystem** of projects, tools, and pieces of software, such as:

- **Docker Client**
- **Docker Server**
- **Docker Hub**
- **Docker Compose**

Together they form a platform around **creating and running containers**.

### What happened behind `docker run redis`

When the command ran, the **Docker CLI** reached out to **Docker Hub** and downloaded a single file
called an **image**.

| Term | Definition |
| --- | --- |
| **Image** | A single file, stored on your hard drive, containing **all the dependencies and all the configuration** required to run a very specific program (e.g. Redis). You use it to create a container. |
| **Container** | An **instance of an image** — think of it as a running program. It's a program with its **own isolated set of hardware resources**: its own little space of memory, of networking, and of hard drive space. |

How containers actually work gets covered in great detail later. Images and containers are the
absolute backbone of everything done in the rest of the course.

---

## 04. Docker for Mac/Windows

To work directly with images and containers, install **Docker for Windows** or **Docker for Mac**
(Docker Desktop). It contains two very important tools:

| Tool | Also called | Role |
| --- | --- | --- |
| **Docker client** | **Docker CLI** | The program you interact with from the terminal. You issue commands to it; it figures out what to do with them. It **doesn't actually do anything with containers or images itself** — it's a portal to the server. |
| **Docker server** | **Docker daemon** | The actual software responsible for creating containers and images, maintaining containers, uploading images — just about everything in the world of Docker. |

You issue commands to the client; behind the scenes the client talks to the server. You never really
reach out to the Docker server directly — it just runs behind the scenes.

---

## 05. Installing Docker on macOS

A **Docker Hub account** is needed to pull images and push the ones you build.

1. Register (free) at <https://hub.docker.com/signup>.
2. Go to <https://www.docker.com/products/docker-desktop/> and pick your chip: **Mac with Apple
   Chip** (M1/M2) or **Mac with Intel Chip**.
3. Open `Docker.dmg`, drag the Docker icon into **Applications**, then launch it from there.
4. Confirm **Open**, **Accept** the Service Agreement, click **OK** on the privileged-access prompt,
   and enter your computer's username/password to install the helper.
5. Docker Desktop launches with a tutorial (safe to skip).
6. Verify and log in from the terminal:

```sh
docker          # should print helpful usage instructions
docker login    # Docker Hub username + password (or Personal Access Token)
```

Setup is complete once you see **Login Succeeded**.

---

## 06. Installing Docker with WSL on Windows 10/11

Windows 10 & 11 can install Docker Desktop if the machine supports the **Windows Subsystem for
Linux (WSL)**.

1. Register for Docker Hub at <https://hub.docker.com/signup>.
2. Install all pending Windows updates.
3. Open **PowerShell as Administrator** and run the WSL install script (skip to step 5 if WSL and a
   distro are already set up). It enables all required features and installs Ubuntu:

   ```powershell
   wsl --install
   ```

4. Reboot. Windows auto-launches Ubuntu and asks you to set a **username and password**. If it
   didn't prompt you (or you want another distro), install one manually:

   ```powershell
   wsl --install -d Ubuntu
   ```

5. Download **Docker Desktop for Windows** from
   <https://docs.docker.com/desktop/install/windows-install/>, run the installer ("Install anyway"
   if warned it isn't Microsoft-verified), add the desktop shortcut, close on success, launch it,
   and accept the Service Agreement.
6. In Docker Desktop: **Settings (gear) → Resources → WSL Integration** — make sure **Enable
   integration with my default WSL distro** is checked, and toggle on any additional distros.
7. Open your distro (Windows Search → "Ubuntu" → **Open**) and in its terminal run `docker`, then
   `docker login`. Done once you see **Login Succeeded**.

> **Important:** with WSL, create and run your project files from within the **Linux filesystem**,
> not the Windows filesystem. This matters a lot later when volumes are covered. Going forward, run
> all Docker commands **within WSL**.

---

## 07. Installing Docker on Linux

### Docker Desktop on native hardware

"Native hardware" means a physical laptop/desktop. On WSL, install Docker Desktop for **Windows**;
in a VM (VirtualBox, Parallels) or a cloud server (AWS), use the cloud/VM instructions below —
**Docker Desktop does not work with nested virtualization**. Docker Desktop currently supports only
**Ubuntu**, **Debian**, and **Fedora**.

1. Create a Docker Hub account.
2. Follow the generic Docker Desktop for Linux install steps for your distro.
3. Log in and test:

```sh
docker login              # Docker Hub username + password
docker run hello-world    # downloads and runs a test container that prints "hello world"
```

### Cloud servers or inside virtual machines

Steps are for Ubuntu Desktop LTS; official docs also exist for Ubuntu, CentOS, and Debian. (Students
have hit container-communication issues with CentOS/RHEL hosts — you may need to research
workarounds or search the Q&A.)

1. Create a Docker Hub account.
2. Install Docker Engine by **setting up the Docker repository** to install and update from
   (<https://docs.docker.com/engine/install/ubuntu/#install-using-the-repository>).
3. Log in, test the install, and test Compose:

```sh
docker login
sudo docker run hello-world
docker compose -v         # prints Docker Compose version and build numbers
```

> **Important:** the Docker Compose installed with Docker Engine has **no `docker-compose` (hyphen)
> symlink** — that only exists in Docker Desktop. Run all Compose commands **without a hyphen**
> (`docker compose`).

4. Follow the Linux post-install docs to **manage Docker as a non-root user** (run without `sudo`)
   and to **configure Docker to start on boot**. You may need to restart before starting the
   course material.

---

## 08. Using the Docker Client

*Transcript not available in this folder (the `.txt` file is empty).*

---

## 09. But Really... What's a Container?

*Transcript not available in this folder (the `.txt` file is empty).*

---

## 10. How's Docker Running on Your Computer?

*Transcript not available in this folder (the `.txt` file is empty).*

---

## 11. Quiz 1: Images and Containers

| # | Question | Correct answer |
| --- | --- | --- |
| 1 | What's the purpose of an image? | **Images are used to create containers** |
| 2 | What goes on inside of a container? | **Containers wrap up a program and limit what files that program can access** |
| 3 | What are the two primary parts of an image? | **(1) A primary command and (2) a set of files** |
