# Reminder on Buildkit

[As mentioned earlier](https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/learn/lecture/22776989#overview), Buildkit will hide away much of its progress which is something the legacy builder did not do. In the upcoming lectures will be discussing some output that will be quickly hidden by default. To see this output, you will want to pass the progress flag to the build command:

```sh
docker build --progress=plain .
```

Additionally, you can pass the no-cache flag to disable any caching:

```sh
docker build --no-cache --progress=plain .
```

*Note - Do not try to use the no-cache flag with Lecture 47 Minimizing Cache Busting*

## Disabling Buildkit to match course output

To disable Buildkit, you can just pass the following variable to the build command:

```sh
DOCKER_BUILDKIT=0 docker build .
```