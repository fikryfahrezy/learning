# Section 7 — Continuous Integration and Deployment with AWS

Summary of lectures 91–111. The Docker side of the React **frontend** project from Section 6 is
done: `Dockerfile.dev` for development and tests, and a multi-step production `Dockerfile` that
serves the build with nginx. This section wires those images into a real pipeline. The code goes
into a **GitHub** repo, **Travis CI** (or **GitHub Actions** as the newer alternative) builds the dev
image and runs the tests on every push, and when code lands on the main branch the CI service
**deploys the app to AWS Elastic Beanstalk**. Along the way the section covers IAM users and access
keys, keeping those keys out of the public repo, the **`EXPOSE`** instruction that Elastic Beanstalk
needs, and the feature branch → pull request → merge → deploy workflow. Several lecture notes update
the videos for today's AWS console and Travis's pricing.

> **Test with `Dockerfile.dev`, deploy with `Dockerfile`.** CI builds the dev image, runs
> `npm run test` inside it and only cares about the **exit status code**. If the tests pass on the
> main branch, the repo is zipped, dropped into an **S3 bucket**, and Elastic Beanstalk redeploys
> from it. Docker isn't required for any of this, but it makes the pipeline reusable for almost
> any project.

---

## 91. Services Overview

The goal is the flow described earlier in the course: a **GitHub repo** with a **feature branch**
you develop on and a **master branch** you deploy from, with **Travis CI** and **AWS** hooked in.

| Service | Role | Cost / assumptions |
| --- | --- | --- |
| **GitHub** | Hosts the code | Free. The course assumes you know Git basics (commits, branches, pushing) and already have an account. |
| **Travis CI** | The **CI (continuous integration) provider**: runs the tests automatically and later deploys to AWS | Free at the time of recording. No prior Travis experience is assumed. (Now requires a credit card and credits; see lecture 93.) |
| **AWS** | Hosts the deployed app | Free to sign up, but a **credit card** is required. |

If you don't want an AWS account you can just watch; only a handful of videos are AWS-specific.

> Once your application is in a Docker container, deploying to AWS, Google Cloud or DigitalOcean is
> *"all pretty darn similar"*. AWS is used because it's one of the more popular providers.

---

## 92. GitHub Setup

### Create the remote

1. On GitHub, click **+** → **New repository**.
2. Name it **`docker-react`**. Another name works, but some later commands will change.
3. Make it **public**. *"A ton of stuff … is not going to work the way you expect"* if it's
   private. Private repos work too, but need extra credentials at key steps.
4. **Create repository** and copy the repo link.

### Create the local repo and push

From inside the `frontend` project directory:

```sh
git init
git add .
git commit -m "initial commit"
git remote add origin <github-repo-link>
git push origin master
```

Refresh the GitHub page and check that your files are there, **especially the Dockerfile**.

---

## 93. Important Info About Travis and Account Registration

A lecture note about how Travis has changed since recording:

- **travis-ci.org no longer works.** You're redirected to sign up at **https://www.travis-ci.com/**.
- Because of **crypto-mining abuse**, the free terms changed. After registering, pick **Monthly
  Plans → free Trial Plan**, which gives **10,000 free credits** to use **within 30 days**.
- **Travis now requires a credit card** during registration.
- From Travis's billing docs: trial credits **are not replenished** once they run out. After that
  you must subscribe to a higher plan or request an OSS credits allowance.

If you run out of credits, can't register, or don't want Travis, use **GitHub Actions** instead
(next lecture).

---

## 94. GitHub Actions Instead of Travis CI

**GitHub Actions** is a free CI/CD tool **built directly into GitHub repositories**, so no external
service is needed.

### How it works

- **Workflows** are defined in **YAML files**. A workflow runs one or more **jobs**.
- A **job** is a set of **steps** that run on the same **runner**, which is a virtual machine.
- A **step** can run a command, do a setup task, or run an **action**.
- Four main concepts:

| Concept | Meaning |
| --- | --- |
| **Triggers** | When to run |
| **Jobs** | What to do |
| **Steps** | How to do it |
| **Actions** | Reusable units of code |

### Folder structure

```
project-root/
├── .github/
│   └── workflows/
│       └── main.yml
└── (rest of your project files)
```

Workflow files go in **`.github/workflows`** at the repository root.

### Replacement code

For every lecture that writes Travis config there is a matching zip with **`gh-actions`** in its
name. In this folder that's [`103-finished-gh-actions.zip`](./103-finished-gh-actions.zip), whose
workflow is walked through in [lecture 104](#github-actions-version-of-the-deploy). (The note's
example, *"Lecture 88 … `88-touch-more-gh-actions.zip`"*, uses older lecture numbering; that zip
isn't in this folder.)

### Travis CI vs GitHub Actions

Based on the two finished zips:

| | Travis CI | GitHub Actions |
| --- | --- | --- |
| **Config file** | `.travis.yml` in the repo root | `.github/workflows/deploy.yaml` |
| **Where it runs** | External service watching the repo | Built into GitHub |
| **Cost** | Trial credits, credit card required | Free |
| **Docker available via** | `services: - docker` | The `ubuntu-latest` runner |
| **Build step** | `before_install:` | A `run:` step |
| **Test step** | `script:` | A `run:` step |
| **Deploy** | Built-in `provider: elasticbeanstalk` | The `einaregilsson/beanstalk-deploy` action |
| **Zipping the repo** | Done by Travis automatically | An explicit `zip -r deploy.zip . -x '*.git*'` step |
| **Only deploy from main** | `on: branch: main` in `deploy:` | The whole workflow triggers `on: push: branches: [main]` |
| **Secrets** | Travis repo **Environment Variables** → `$AWS_ACCESS_KEY` | GitHub **secrets** → `${{ secrets.AWS_ACCESS_KEY }}` |

---

## 95. Travis CI Setup

### What Travis does

Whenever you push code to GitHub, GitHub *"taps Travis on the shoulder"*. Travis **pulls down all
the code** in the repo and then lets you do some work with it. *"The sky is the limit"* (you could
even delete the repo from Travis), but traditionally Travis is used for **testing** and
**deployment**. This course does both: **test first, and once the tests come up green, deploy to
AWS**.

### Linking the repo

1. Go to Travis and **sign in with GitHub**. GitHub's **OAuth** page asks you to authorize Travis
   CI, which grants it access to your GitHub repositories.
2. You land on the Travis dashboard. The UI was being redesigned, so yours may look different.
3. Open your **profile** (top right). If there's a green box about enabling Travis CI as a
   **GitHub App**, click it.
4. Filter the repository list for **`docker-react`** and flip its **switch**. That tells Travis to
   pull and work on the code whenever you push.
5. Back on the dashboard the repo shows *"No builds for this repository"*.

---

## 96. Travis YML File Configuration

Travis won't *"magically figure out"* what to do. You spell it out in a **`.travis.yml`** file in
the **root project directory**.

### The plan

1. Tell Travis we need a **copy of Docker running**.
2. **Build the image using `Dockerfile.dev`**.
3. Tell Travis **how to run the test suite**.
4. (Later) tell Travis how to **deploy to AWS**.

**Why `Dockerfile.dev`?** The production `Dockerfile` creates an image meant for a server serving
users. It **has no dependencies or code for running the test suite**. To run tests you need the
dev image.

### Writing the first part

> Make sure you get that **leading dot**: the file is **`.travis.yml`**.

```yaml
sudo: required
services:
  - docker

before_install:
  - docker build -t <docker-username>/docker-react -f Dockerfile.dev .
```

- **`sudo: required`**: using Docker needs **superuser permissions**.
- **`services: - docker`**: Travis installs a **copy of Docker** into the build environment.
- **`before_install:`**: commands that run **before the tests** (or deployment), i.e. setup.
- **`docker build -f Dockerfile.dev .`**: force the dev Dockerfile and use the current directory as
  the build context.
- **`-t <docker-username>/docker-react`**: in an automated pipeline you can't copy-paste image IDs
  between commands, so the image is **tagged** and later referred to by name.

The tag is only used inside the Travis process, so any name would work (`my-image`, `test-me`). The
convention is still **`<docker-username>/<repo-name>`**.

---

## 97. A Touch More Travis Setup

### The `script` section

**`script:`** holds the commands that **actually run the test suite**. Travis watches the output of
each command. **If any command returns a status code other than 0, Travis assumes the build failed**
and that the code is broken.

### The "hangs forever" gotcha

Travis expects the test suite to run and **exit on its own**. By default `npm run test` runs once and
then shows an interactive menu and waits for input, **it never exits**. Travis would be waiting
*"like 30 days"*.

The fix in the lecture is to add **`-- --coverage`** (two sets of dashes with a space between). The
test suite then runs once, prints a **coverage report** (how much code the tests executed) and exits.
The coverage output doesn't matter; **Travis only cares about the status code**.

```sh
docker run <docker-username>/docker-react npm run test -- --coverage
```

So the lecture's `.travis.yml` becomes:

```yaml
sudo: required
services:
  - docker

before_install:
  - docker build -t <docker-username>/docker-react -f Dockerfile.dev .

script:
  - docker run <docker-username>/docker-react npm run test -- --coverage
```

Now every push makes Travis clone the code, build the image, run the tests and report whether they
succeeded.

> **Note:** the finished zip (see [lecture 104](#the-finished-travisyml)) uses
> `docker run -e CI=true … npm run test` instead of `-- --coverage`. Setting the **`CI`**
> environment variable is another way to make the test runner run once and exit.

---

## 98. Automatic Build Creation

Commit and push, and Travis takes it from there:

```sh
git add .
git commit -m "added travis file"
git push origin master
```

Open the repo on the Travis dashboard (refresh if the build doesn't show up yet). In the **job log**
you'll see:

- **`sudo service docker start`**: Travis adding Docker to the build.
- The **`docker build`**, including the long **`npm install`**. The npm warnings are fine to ignore.
- The **`COPY`**, then the test run: one test passes and the coverage report prints.
- **"The command exited with 0"**. Status code 0 means success, so Travis marks the **build green**.

The pipeline now watches GitHub, pulls the code, runs the tests and reports back.

---

## 99. AWS Elastic Beanstalk

With tests passing on Travis, the app is ready to deploy to an outside host (AWS, Azure,
DigitalOcean, …). Sign in to the **AWS Management Console** and search for **Elastic Beanstalk**.

> Elastic Beanstalk is *"by far the easiest way to get started with production Docker instances"*.
> It's most appropriate when you're running **exactly one container** at a time. It can run multiple
> copies of the same container, but it's easiest for one single container.

The video's walkthrough of creating the application is replaced by the lecture note that follows.

---

## 100. Elastic Beanstalk Setup and Configuration

Because the AWS UI changes often, this is a text lecture with **four sections, none to be skipped**.

### 1. Create the EC2 IAM Instance Profile

AWS used to generate this automatically. Now you create it yourself:

1. AWS Management Console → search **IAM** → **Roles** (under **Access Management**) → **Create
   role**.
2. **Trusted entity type:** **AWS Service**. **Common use cases:** **EC2**. Click **Next**.
3. Search **AWSElasticBeanstalk** and select these policies, then **Next**:
   - **AWSElasticBeanstalkWebTier**
   - **AWSElasticBeanstalkWorkerTier**
   - **AWSElasticBeanstalkMulticontainerDocker**
4. Name the role **`aws-elasticbeanstalk-ec2-role`** and click **Create role**.

### Create the Elastic Beanstalk Service Role

1. IAM → **Roles** → **Create role** → **AWS Service**.
2. Under common use cases, type and select **Elastic Beanstalk**, then tick **Elastic Beanstalk -
   Environment**. Two permissions are set automatically. Click **Next**.
3. Name it **`aws-elasticbeanstalk-service-role`** and click **Create Role**.

### 2. Create the Elastic Beanstalk environment

1. Console → search **Elastic Beanstalk**.
2. First time: click **Create Application** on the splash page. Otherwise: **Create environment**
   on the dashboard.
3. Enter an **Application name**. It auto-fills the **Environment name**.
4. **Platform:** **Docker**. Change the **Platform branch** to **Docker running on 64bit Amazon
   Linux 2**. The newer **2023** branch *"currently has issues with single-container deployments"*.
5. **Presets:** make sure **free tier eligible** is selected. Click **Next**.
6. On **Service Access**, **Service Role** and **EC2 Instance Profile** should already be set to the
   two roles created above.
7. Click **Skip to Review**, then **Submit**, and wait for the application and environment to
   launch.

### 3. S3 bucket configuration

1. Console → **S3** → click the **`elasticbeanstalk-…`** bucket created along with the environment
   (its region will likely differ from the note's).
2. **Permissions** tab → **Object Ownership** → **Edit**.
3. Change **ACLs disabled** → **ACLs enabled**, and **Bucket owner preferred** → **Object Writer**.
   Tick the box acknowledging the warning.
4. **Save changes**.

### 4. Required update for Docker Compose

The newer Amazon Linux platforms **look for a `docker-compose.yml` file to build from by default**
instead of a `Dockerfile`. That conflicts with this project, whose `docker-compose.yml` is the
**development** setup. So rename it to **`docker-compose-dev.yml`**, and from now on pass **`-f`**
to say which compose file to use:

```sh
docker-compose -f docker-compose-dev.yml up
docker-compose -f docker-compose-dev.yml up --build
docker-compose -f docker-compose-dev.yml down
```

The renamed file from [`103-finished-travis.zip`](./103-finished-travis.zip):

```yaml
version: "3"
services:
  web:
    build:
      context: .
      dockerfile: Dockerfile.dev
    ports:
      - "3000:3000"
    volumes:
      - /app/node_modules
      - .:/app
  tests:
    build:
      context: .
      dockerfile: Dockerfile.dev
    volumes:
      - /app/node_modules
      - .:/app
    command: ["npm", "run", "test"]
```

The GitHub Actions zip's copy is the same except the `tests` service also has
**`stdin_open: true`**.

A full cheat sheet with every updated step is in [lecture 110](#110-aws-configuration-cheat-sheet).

---

## 101. More on Elastic Beanstalk

### How a request flows

1. A user (you, while testing) opens the app's URL.
2. The request hits a **load balancer** that Elastic Beanstalk **already created** as part of the
   application.
3. The load balancer routes it to a **virtual machine running Docker**, where **our container** runs
   the app.
4. The app responds and the user gets the file they asked for.

### Why Elastic Beanstalk

> The benefit is that it's going to **automatically scale everything up** for us.

It monitors traffic to the VM. When traffic passes a threshold, it **automatically adds more VMs**,
and the load balancer sends each request to the one with **the least traffic**.

### The default app

The Elastic Beanstalk dashboard shows the app's **URL** on the top line. Opening it shows a
**default welcome page**, which is launched whenever you make a new Docker Elastic Beanstalk
instance. It'll be replaced with our app.

---

## 102. Travis Config for Deployment

A new **`deploy:`** section at the bottom of `.travis.yml` tells Travis how to ship the app to AWS.
The instructor warns that it's laborious, so follow closely.

| Key | What goes in it | How to find it |
| --- | --- | --- |
| **`provider`** | `elasticbeanstalk` (one word) | Travis comes **preconfigured** for many hosting providers; this picks the Elastic Beanstalk instructions |
| **`region`** | e.g. `"us-west-2"` (the instructor's) or `"us-east-1"` | The part of the app URL just **before `elasticbeanstalk.com`**; wherever you created the instance |
| **`app`** | e.g. `"docker"` | The **application name**, letter for letter, shown after *All Applications* on the dashboard |
| **`env`** | e.g. `"docker-env"` | The **environment name**. The application is a common set of config; the thing actually running is called an **environment** |
| **`bucket_name`** | `elasticbeanstalk-<region>-<account-id>` | **S3** → the bucket named `elasticbeanstalk-<region>`, created automatically with the EB instance |
| **`bucket_path`** | Same as `app`, e.g. `"docker"` | The folder in that bucket. It's only created on the **first deploy**, so by default it equals the app name |
| **`on: branch:`** | `master` (in the video; `main` in the zip) | Only deploy when **that branch** gets new code |

### Why a bucket?

On deploy Travis **zips up all the files** in the repo, **copies the zip to an S3 bucket** (*"a hard
drive running on AWS"*), then pokes Elastic Beanstalk: *"I just uploaded this new zip file, use it
to redeploy"*. The same bucket is **reused for all your Elastic Beanstalk environments**, which is
why each one gets its own folder (`bucket_path`).

### Why `on: branch`

Pushing to a **feature branch** is active development and may hold unfinished features, so it
shouldn't deploy. **Merging into master** means it's time to deploy.

Two more pieces, the AWS API keys, come next.

---

## 103. Required Update for IAM User and Keys

The upcoming video creates an IAM user and gets a key pair during user creation. That flow changed:
**create the user first, then create an access key for it**. AWS also renamed **Programmatic
Access** to **Command Line Interface (CLI)**.

1. Search for and select **IAM** → **Access Management** → **Users** → **Create User**.
2. Enter any **User Name** → **Next**.
3. **Attach Policies Directly**, search for and tick **`AdministratorAccess-AWSElasticBeanstalk`**
   → **Next** → **Create user**.
4. Select the new user → **Security Credentials** → scroll to **Access Keys** → **Create access
   key**.
5. Select **Command Line Interface (CLI)**, tick the *"I understand…"* box → **Next**.
6. Copy and/or download the **Access Key ID** and **Secret Access Key** for deployment.

---

## 104. Automated Deployments

### Generating keys (as shown in the video)

**IAM** is the AWS service for managing API keys used by outside services. In the video:

- **Users** → **Add user**, named something descriptive like `docker-react-travis-ci`.
- **Programmatic access only**: Travis only uses the keys over network requests, never the
  Management Console. (Now **CLI**; see lecture 103.)
- **Attach existing policies directly**. **Policies are permissions**, listing what the user may do.
  Search **beanstalk** and pick the one that **provides full access**. (Now
  **`AdministratorAccess-AWSElasticBeanstalk`**.)

> The **secret access key is shown exactly one time**. Write it down. If you lose it you have to
> regenerate the key entirely.

### Never put keys in the repo

The GitHub repo is **public**. If the keys go into `.travis.yml`, *"everyone in the world is gonna
have access to our AWS account"*. Instead use Travis's **environment variables**, which are
**encrypted and stored by Travis**:

1. Travis → your repo → **More Options** → **Settings** → **Environment Variables**.
2. Add **`AWS_ACCESS_KEY`** with the access key ID. Leave **"Display value in build log"
   unchecked**.
3. Add **`AWS_SECRET_KEY`** with the secret access key (copy the whole thing).

Then reference them in the deploy section:

```yaml
  access_key_id: $AWS_ACCESS_KEY
  secret_access_key: "$AWS_SECRET_KEY"
```

The instructor found they had to wrap the secret in **double quotes**, although the documentation
suggests it isn't needed. (The finished zip leaves both unquoted.)

### Push to deploy

For now, push straight to master to check that it works (the feature-branch flow comes later):

```sh
git status
git add .
git commit -m "added travis deploy config"
git push origin master
```

A new build appears on the Travis dashboard (refresh if needed).

### The finished `.travis.yml`

From [`103-finished-travis.zip`](./103-finished-travis.zip) (`frontend-travis/.travis.yml`). The
Docker username and the AWS account ID in the bucket name are replaced with placeholders:

```yaml
dist: focal
sudo: required
language: generic

services:
  - docker

before_install:
  - docker build -t <docker-username>/docker-react -f Dockerfile.dev .

script:
  - docker run -e CI=true <docker-username>/docker-react npm run test

deploy:
  provider: elasticbeanstalk
  region: "us-east-1"
  app: "docker"
  env: "docker-env"
  bucket_name: "elasticbeanstalk-us-east-1-<aws-account-id>"
  bucket_path: "docker"
  on:
    branch: main
  access_key_id: $AWS_ACCESS_KEY
  secret_access_key: $AWS_SECRET_KEY
```

Differences from what the videos type:

- **`dist: focal`** and **`language: generic`** are present. The lectures don't discuss them.
- **`-e CI=true … npm run test`** instead of **`npm run test -- --coverage`**.
- Region **`us-east-1`** rather than the instructor's `us-west-2`.
- Deploys on branch **`main`**, not `master`.

Remember to fill in **your own** container name and AWS info (lecture 111).

### GitHub Actions version of the deploy

From [`103-finished-gh-actions.zip`](./103-finished-gh-actions.zip)
(`frontend-gh-actions/.github/workflows/deploy.yaml`), with the image name and account ID replaced
with placeholders:

```yaml
name: Deploy Frontend
on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - run: docker login -u ${{ secrets.DOCKER_USERNAME }} -p ${{ secrets.DOCKER_PASSWORD }}
      - run: docker build -t <docker-username>/react-test -f Dockerfile.dev .
      - run: docker run -e CI=true <docker-username>/react-test npm test

      - name: Generate deployment package
        run: zip -r deploy.zip . -x '*.git*'

      - name: Deploy to EB
        uses: einaregilsson/beanstalk-deploy@v18
        with:
          aws_access_key: ${{ secrets.AWS_ACCESS_KEY }}
          aws_secret_key: ${{ secrets.AWS_SECRET_KEY }}
          application_name: docker-gh
          environment_name: Dockergh-env
          existing_bucket_name: elasticbeanstalk-us-east-1-<aws-account-id>
          region: us-east-1
          version_label: ${{ github.sha }}
          deployment_package: deploy.zip
```

How it maps onto the Travis config:

- **Trigger:** `on: push: branches: [main]`. The workflow only runs for pushes to `main`, which
  covers Travis's `on: branch: main`.
- **`runs-on: ubuntu-latest`**: the runner VM the job runs on.
- **`actions/checkout@v3`**: an action that checks out the repo code onto the runner (the part
  Travis does automatically).
- **`docker login`** with **`DOCKER_USERNAME`** / **`DOCKER_PASSWORD`** secrets. The Travis config
  has no equivalent step.
- **Build and test**: the same `docker build -f Dockerfile.dev` and `docker run -e CI=true … npm
  test` as `before_install` / `script`.
- **Generate deployment package**: zips the project, excluding Git files, into `deploy.zip`. Travis
  does this zipping for you.
- **Deploy to EB**: the **`einaregilsson/beanstalk-deploy@v18`** action uploads the package to the
  existing bucket and deploys it to the named application/environment. **`version_label`** is the
  commit SHA, so each deploy gets a unique version.
- **Secrets** are read with **`${{ secrets.NAME }}`**. They need to exist as secrets on the GitHub
  repo; the course materials here don't include steps for adding them.

---

## 105. Exposing Ports Through the Dockerfile

### The problem

The build passes, tests run, and the log shows *"preparing deploy"*, *"deploying application"*,
*"done"*. Refresh the Elastic Beanstalk dashboard and you'll see it deploying, but when it finishes
**the page won't load** and health shows **Degraded**.

Locally we always ran web servers with **`docker run -p …`**, because **by default no port inside
a container is exposed**. Nothing in the Elastic Beanstalk setup did any port mapping, and the
Elastic Beanstalk Docker docs *"are not gonna quite throw this little tip out there at you"*.

### The fix: `EXPOSE`

In the **production `Dockerfile`**, right after `FROM nginx`, add **`EXPOSE 80`**.

| Where | What `EXPOSE` does |
| --- | --- |
| **Your laptop** (and most environments) | **Nothing automatically.** It's documentation for developers: *"this container probably needs a port mapped to port 80"*. |
| **Elastic Beanstalk** | It **reads the `EXPOSE` instruction** and **maps that port automatically** for incoming traffic. |

The production `Dockerfile` from both finished zips:

```dockerfile
FROM node:lts-alpine as builder
WORKDIR '/app'
COPY package.json .
RUN npm install
COPY . .
RUN npm run build

FROM nginx
EXPOSE 80
COPY --from=builder /app/build /usr/share/nginx/html
```

- **Build phase (`builder`)**: install dependencies and run `npm run build` to produce static files
  in `/app/build`.
- **Run phase**: nginx, with **port 80 exposed**, serving the build output copied from the builder
  stage.

For comparison, `Dockerfile.dev` (also in both zips), which CI uses for tests:

```dockerfile
FROM node:lts-alpine

WORKDIR '/app'

COPY package.json .
RUN npm install

COPY . .

CMD ["npm", "run", "start"]
```

Both zips also have a `.dockerignore` of `package-lock.json`, `node_modules` and `yarn.lock`.

Redeploy:

```sh
git add .
git commit -m "added EXPOSE 80"
git push origin master
```

---

## 106. Workflow With Github

After the redeploy, health is **OK** and the app's URL shows the React app. *"That is our deployed
application using Docker."*

### The team flow

1. Push changes to a **feature branch** (any branch other than master).
2. Open a **pull request** to merge it into master.
3. **Merge** the pull request, which deploys to AWS.

### Walking through it

```sh
git checkout -b feature        # -b creates the new branch
```

Change the paragraph text in **`src/App.js`** to something like *"I was changed on the feature
branch"*, then:

```sh
git add .
git commit -m "changed app text"
git push origin feature        # creates the feature branch on GitHub
```

On the `docker-react` GitHub repo, refresh and click **Compare & pull request** on the
notification. The PR merges **feature → master**. Describe the change, mention other engineers for
review, and click **Create pull request**.

The PR shows **pending checks**: that's Travis pulling down the changes, running the tests, and
reporting back on the PR.

---

## 107. Redeploy on Pull Request Merge

Travis ran **two sets of checks** on the PR:

- One for the **pushed branch** on its own.
- One that **fakes merging the code into master** and runs the tests on the result.

So both *"the code that was pushed by itself is valid"* and *"the code that was merged to master is
valid"*.

With both checks green (and perhaps a reviewer saying *"your code looks good"*), **merge the pull
request** and confirm. Travis kicks in a **third time**. Because this change is on **master**, after
the tests pass it **deploys to Elastic Beanstalk again**. A new build appears on the Travis
dashboard after a moment (refresh to see it sooner).

---

## 108. Deployment Wrapup

Refresh the app URL and it shows *"I was changed on the feature branch"*. Merging the PR triggered
Travis, which redeployed, which updated Elastic Beanstalk. It's a *"rock solid development
workflow"* for a team, or for yourself if you want a personal review process.

### Docker wasn't required, but it helped

None of this strictly needed Docker. Travis, tests and Elastic Beanstalk could all be done with
shell scripts and so on.

> Docker **significantly made setting up all this stuff a lot easier**.

Once the Dockerfile existed, the only real complexity was `.travis.yml`, and most of that was just
*build the image, then run this command to test*. The same infrastructure could be reused with
almost any valid Docker container. Swap in a **Rails** app and probably only the test command would
change.

> You set up this pipeline **one time** and make small changes over time, but you probably don't
> have to **re-architect your entire deployment pipeline** if you change your project's
> composition.

---

## 109. Environment Cleanup

**Delete the resources you created, or you might end up paying real money for them.** To delete the
Elastic Beanstalk instance:

1. Go to the **Elastic Beanstalk dashboard**.
2. Left sidebar → **Applications**.
3. Click the application to delete.
4. **Actions** → **Delete Application**.
5. Type the application's name to confirm.

It may take a few minutes for the dashboard to show that the app is being deleted. Be patient.

---

## 110. AWS Configuration Cheat Sheet

Not a replacement for the videos: a quick run-through of every step with the current AWS UI, to
check nothing was missed. Steps that repeat lectures 100 and 103 are condensed here.

| Step | What to do |
| --- | --- |
| **Docker Compose update** | Rename the dev `docker-compose.yml` to **`docker-compose-dev.yml`**. |
| **EC2 IAM instance profile** | IAM → Roles → Create role → AWS Service + **EC2** → policies **AWSElasticBeanstalkWebTier**, **AWSElasticBeanstalkWorkerTier**, **AWSElasticBeanstalkMulticontainerDocker** → name **`aws-elasticbeanstalk-ec2-role`**. |
| **Elastic Beanstalk environment** | Create Application / Create environment (a **6-step** flow) → name → Platform **Docker**, branch **Docker running on 64bit Amazon Linux 2** → **free tier eligible** → Next. |
| **Service access (step 2)** | **Create and use new service role** named **`aws-elasticbeanstalk-service-role`**. Set the EC2 instance profile to **`aws-elasticbeanstalk-ec2-role`** (likely auto-filled). |
| **Finish** | **Skip to Review** (steps 3–6 don't apply) → **Submit**. Click the link under **Domain** to see a *Congratulations* page. |
| **S3 object ownership** | S3 → `elasticbeanstalk-…` bucket → Permissions → Object Ownership → Edit → **ACLs enabled**, **Object Writer**, acknowledge → Save. |
| **IAM user** | IAM → Users → create user (e.g. `docker-react-travis-ci`) → Attach Policies Directly → **`AdministratorAccess-AWSElasticBeanstalk`** → Create → Security Credentials → Create access key → **CLI** → copy/download both keys. |
| **Travis variables** | Repo → More Options → Settings → add **`AWS_ACCESS_KEY`** and **`AWS_SECRET_KEY`**. |

Note the service-role difference: lecture 100 creates `aws-elasticbeanstalk-service-role` in IAM
beforehand, while the cheat sheet creates it from the Service Access form. Either way it ends up with
the same name.

### `.travis.yml` deploy values

| Key | Value | Where it comes from |
| --- | --- | --- |
| **`region`** | e.g. `'us-east-1'` | Click the region in the toolbar next to your username |
| **`app`** | e.g. `'docker'` | The Application Name |
| **`env`** | e.g. `'docker-env'` | The Beanstalk Environment name, **in lower case** |
| **`bucket_name`** | e.g. `'elasticbeanstalk-us-east-1-<aws-account-id>'` | S3 → the elasticbeanstalk bucket matching your region code |
| **`bucket_path`** | `'docker'` | |
| **`access_key_id`** | `$AWS_ACCESS_KEY` | Travis environment variable |
| **`secret_access_key`** | `$AWS_SECRET_KEY` | Travis environment variable |

### Deploying the app

1. Make a small change to the greeting text in **`src/App.js`**.
2. From the project root:

   ```sh
   git add .
   git commit -m "testing deployment"
   git push origin main
   ```

3. On the Travis dashboard the build should end with a green checkmark and **"build passing"**.
4. Elastic Beanstalk should say *"Elastic Beanstalk is updating your environment"*, and then show a
   green checkmark under **Health**. The app is at the external URL under the environment name.

---

## 111. Finished Project Code with Updates Applied

The completed React frontend for this section comes in two versions:

- [`103-finished-travis.zip`](./103-finished-travis.zip): `frontend-travis/`, with `.travis.yml`.
- [`103-finished-gh-actions.zip`](./103-finished-gh-actions.zip): `frontend-gh-actions/`, with
  `.github/workflows/deploy.yaml`.

Both contain the same `Dockerfile`, `Dockerfile.dev`, `docker-compose-dev.yml` (the GitHub Actions
copy adds `stdin_open: true` to `tests`), `.dockerignore`, and a Create React App project using
`react-scripts` 5.0.1 and React 18. **Update the CI config with your own container name and AWS
info** before using it.
