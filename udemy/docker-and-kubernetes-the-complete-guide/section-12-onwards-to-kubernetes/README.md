# Section 12 — Onwards to Kubernetes

Summary of lectures 173–191. Kubernetes runs containerized applications across a cluster and
lets each component scale independently. This section sets up a local cluster, runs the React
client in a Pod, exposes it with a Service, and introduces declarative configuration.

## Why Kubernetes and how to run it locally (173–180)

The earlier Elastic Beanstalk example scales the whole group of containers together. Kubernetes
can run different numbers of each component, so a busy worker can have more replicas without
requiring the same number of clients, servers, and proxies. A cluster has a control plane (called
the *master* in the lectures) and one or more nodes that run workloads. `kubectl` sends requests
to the cluster. For production, the lectures introduce managed clusters such as EKS and GKE.

The videos use Minikube for local development. The course's updated setup notes recommend
[Docker Desktop Kubernetes on macOS](./175-docker-desktops-kubernetes-setup-and-installation-macos.md)
and [Windows](./177-docker-desktops-kubernetes-setup-and-installation-windows.md); select the
`docker-desktop` context and check `kubectl version`. On those setups, visit a NodePort service
through `localhost:<nodePort>`, rather than the Minikube IP shown in the videos. The
[macOS](./176-minikube-info-macos.md) and [Windows](./178-minikube-info-windows.md) notes explain
how to access services if Minikube must be used. [Linux setup](./179-minikube-setup-on-linux.md)
uses Minikube and checks both `minikube status` and `kubectl version`.

Unlike Docker Compose, Kubernetes expects an image to be built and available to the cluster
before deployment. It creates objects from manifests instead of building images. The example
uses the published `stephengrider/multi-client` image; the
[lecture 181 correction](./181-quick-note-to-prevent-an-error.md) recommends it for this demo
because the earlier custom client image can produce a React error here.

## Define a Pod and expose it with a Service (182–188)

The demo uses two YAML manifests: `client-pod.yaml` runs the React client, and
`client-node-port.yaml` exposes it. `apiVersion` selects the Kubernetes API version, `kind`
selects the object type, `metadata` names and labels the object, and `spec` describes its desired
configuration. A Pod is the smallest deployable unit for containers; it can contain one or more
closely related containers. The client Pod runs one container listening on port `3000`.

The NodePort Service routes traffic to Pods whose labels match its selector. Its `port` is the
Service port inside the cluster, `targetPort` is the destination port on the Pod, and `nodePort`
is the externally accessible port on the node (the demo uses `31515`). Declaring
`containerPort` in a Pod does not by itself make the client reachable from a browser. Apply both
manifests with `kubectl apply -f <file>`, then inspect them with `kubectl get pods` and
`kubectl get services`. The client may show API errors because this demo has not deployed the
Express API yet.

## Reconcile desired state (189–191)

`kubectl` sends the manifests to the control plane, which schedules work on nodes and keeps
checking the running objects against the requested state. If a managed container stops, the
cluster works to restore it. This leads to the declarative workflow used throughout the course:
edit the desired configuration and apply it again, leaving Kubernetes to work out the changes.
An imperative workflow instead issues individual create, remove, and update commands.

Object names matter when applying changes: changing a Pod's `metadata.name` and applying the
manifest creates a new Pod rather than renaming or updating the old one, as
[Quiz 12](./191-quiz-12-kubernetes-config-files.md) illustrates.
