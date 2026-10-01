# Quiz 10: Gotcha Around Images Used in Pods

## Question 1

You are working on a new project. You write a `Dockerfile` and then build an image out of it using `docker build . -t my-image`.

You then immediately write the following manifest file and apply it to your Kubernetes cluster:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-pod
spec:
  containers:
    - name: my-container
      image: my-image
```

Unfortunately, you get an error message saying that the image was not found! What could be the issue?

- [x] Kubernetes does not use images that we build and tag on our local machine. We need to first push the image to a registry accessible by our cluster (like Docker Hub).
- [ ] We likely made a typo when tagging the image during the build process.
- [ ] Kubernetes cannot use the image `my-image` because it does not include a Docker ID in the image name.
