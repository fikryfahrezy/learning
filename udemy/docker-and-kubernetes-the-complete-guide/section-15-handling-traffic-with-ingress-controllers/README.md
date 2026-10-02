# Section 15 — Handling Traffic with Ingress Controllers

Summary of lectures 241–252. A NodePort is only suitable for development, so this section
replaces it with an **Ingress** that routes outside traffic to both the React client and the
Express API. It explains how ingress controllers work, installs the **ingress-nginx** controller
locally, and writes the routing rules in `ingress-service.yaml`.

> **Use [lecture 250's Ingress API update](./250-ingress-api-update-this-state-seenindexes-map-and-404-errors.md)
> instead of the config typed in lecture 251.** Kubernetes v1.22 requires
> `apiVersion: networking.k8s.io/v1`; the video's `extensions/v1beta1` no longer works. Replace
> the `kubernetes.io/ingress.class` annotation with `spec.ingressClassName: nginx`, add the
> `use-regex` annotation, set `rewrite-target` to `/$1`, use the regex paths `/?(.*)` and
> `/api/?(.*)`, add `pathType: ImplementationSpecific`, and use the nested `service.name` /
> `service.port.number` backend syntax. The note says these changes fix 404 errors and the
> `this.state.seenIndexes.map is not a function` error. The finished file is
> [`ingress-service.yaml`](./ingress-service.yaml).

## LoadBalancer services and the two nginx projects (241–243)

Of the three Service types, ClusterIP gives Pods access to a set of Pods, NodePort is meant for
development, and LoadBalancer is described as the older way of getting traffic into a cluster. A
LoadBalancer Service exposes only one set of Pods, while this app needs to expose both the client
and the server. It also asks the cloud provider (for example AWS or Google Cloud) to create an
external load balancer that sends traffic into the Service. An Ingress is the newer approach.

The course uses **ingress-nginx**, a community project in the official Kubernetes organization.
A separate project from the company NGINX, *kubernetes-ingress*, does almost the same thing, and
both describe themselves as an "NGINX Ingress Controller". Check that documentation is for
ingress-nginx. Its setup also differs by environment; the course sets it up locally and later on
Google Cloud, which replaces AWS for the production Kubernetes deployment.

## How an ingress controller works (244–246)

A controller is any object that keeps working to make a desired state real, as a Deployment does
for Pods. The ingress config describes routing rules; the ingress controller reads those rules
and creates something that accepts incoming traffic and forwards it to the right Service. In
ingress-nginx, the controller and the nginx Pod that routes traffic run in the same Deployment.

On Google Cloud, creating the Ingress also creates a Google Cloud load balancer, which sends
traffic to a LoadBalancer Service attached to the controller's Deployment, and then to the nginx
Pod. A *default backend* Deployment handles health checks; ideally the Express API would replace
it. The course uses ingress-nginx rather than a hand-made nginx behind a LoadBalancer because it
is Kubernetes-aware. For example, it sends requests directly to Pods instead of through the
ClusterIP Service, which enables features such as sticky sessions. For more depth, see the
[optional ingress-nginx reading](./246-optional-reading-on-ingress-nginx.md).

## Install the controller locally (247–249)

On **Docker Desktop** Kubernetes, follow the
[Docker Desktop setup note](./248-setting-up-ingress-locally-with-docker-desktop.md): open the
ingress-nginx Quick Start docs, find "If you don't have Helm", and run its `kubectl apply`
command. The video uses Minikube and runs `minikube addons enable ingress`. The
[docker driver note](./247-docker-driver-and-ingress-important.md) warns that Minikube's docker
driver does not support ingress on macOS or Windows. On macOS, run `minikube delete` and restart
with `--driver=hyperkit` or `--driver=virtualbox`. Windows users should use Docker Desktop with
WSL2, while Linux users can keep the docker driver. The video also shows that the GCE manifest
creates a Service of type `LoadBalancer`.

## Write and test the routing rules (250–252)

The Ingress copies the routing from the Elastic Beanstalk nginx setup. Requests starting with
`/api` go to `server-cluster-ip-service` on port `5000`, and all other requests go to
`client-cluster-ip-service` on port `3000`. The rewrite annotation strips the `/api` prefix
before the request reaches the server. Backends are referred to by Service name rather than IP.
Apply everything with `kubectl apply -f k8s`.

The video opens the address from `minikube ip` without a port because the controller listens on
ports 80 and 443. Docker Desktop users would use `localhost`, as in Section 12's setup notes.
nginx redirects to HTTPS with a "Kubernetes Ingress Controller Fake Certificate", so the browser
shows a security warning; proceed past it once in development, since production fixes it later.
Submitting an index and refreshing should show the values, confirming that the development
cluster works.
