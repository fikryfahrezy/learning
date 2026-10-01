# Docker Driver and Ingress - IMPORTANT

We've noticed many macOS and Windows students attempting to take the course with the docker driver when using Minikube instead of Docker Desktop.

The docker driver **is not** supported for use in this course if you are on macOS or Windows. It currently does not work with any type of ingress:

https://minikube.sigs.k8s.io/docs/drivers/docker/#known-issues

If you have started the course with the docker driver, you will need to switch to a different driver in order to continue.

Delete your cluster:

```sh
minikube delete
```

Restart with a different driver:

**macOS:**

```sh
minikube start --driver=hyperkit
```

or

```sh
minikube start --driver=virtualbox
```

**Windows:**

Windows students should be using Docker Desktop with WSL2 and not Minikube. A VM driver will not work since it would require virtualization that is in conflict with WSL2. You should stop and head back to the [instructions to enable Docker Desktop's Kubernetes](../section-12-onwards-to-kubernetes/177-docker-desktops-kubernetes-setup-and-installation-windows.md) instead.

**Linux:**

If you are a Linux user, the ingress add-on should be supported when using the docker driver.
