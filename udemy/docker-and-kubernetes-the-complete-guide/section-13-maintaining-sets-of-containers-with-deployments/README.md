# Section 13 — Maintaining Sets of Containers with Deployments

Summary of lectures 192–210. This section applies the declarative workflow, hits the limits of
updating a Pod, and replaces it with a Deployment. It then covers scaling, rolling out new image
versions, and inspecting the Docker server inside a Minikube node.

## Update objects declaratively (192–194)

To update an object, edit the config file that created it and run `kubectl apply -f` again. The
control plane identifies an object by its `kind` and `metadata.name`. If both match an existing
object, it is updated; a new name creates a new object. Switching `client-pod.yaml` to the
`multi-worker` image reports the Pod as `configured`, and `kubectl describe pod client-pod` shows
the new image and the Pod's lifecycle events. Not every field can change, though. Editing
`containerPort` fails because a Pod only allows updates to fields such as `image`,
`activeDeadlineSeconds`, and `tolerations`.

## Run containers with a Deployment (195–201)

A Deployment maintains a set of identical Pods, keeping each one running its Pod template and
recreating any that crash. Any template field can be changed. The lectures limit bare Pods to
one-off development use and use Deployments in development and production. As the
[lecture 196 correction](./196-quick-note-to-prevent-an-error.md) advises, use the
`stephengrider/multi-client` image here.

`client-deployment.yaml` uses `apiVersion: apps/v1` and `kind: Deployment`. `replicas` sets the Pod
count, and `template` gives each Pod the `component: web` label and a `client` container on port
`3000`. The control plane creates the Pods, so the Deployment uses `selector.matchLabels` to find
them. Remove the old Pod with `kubectl delete -f client-pod.yaml`. This imperative step can take
about 10 seconds. Then apply the Deployment and check `kubectl get deployments`, which shows
desired, current, up-to-date, and available counts.

The NodePort Service still serves the app on port `31515`. Docker Desktop users should open
`localhost:31515` rather than the `minikube ip` address shown in the videos.
`kubectl get pods -o wide` shows that each Pod has its own internal IP, which can change when the
Pod is recreated. A Service selects Pods by label and gives consistent access to them.
[Quiz 13](./201-quiz-13-important-notes-on-services.md) adds that a `ClusterIP` Service is reached
by name and port (`http://my-api:8080`) and is not accessible from outside the cluster.

## Scale and update a Deployment (202–206)

Changing the template's port and reapplying works this time: the Deployment replaces the Pod.
`replicas: 5` creates five Pods, and after an image change `kubectl get deployments` shows old
Pods being replaced by up-to-date ones.

Rolling out a rebuilt image under the same tag is harder. After the client heading is changed to
"Fib Calculator version 2" and the image is pushed, reapplying the unchanged config is reported
as `unchanged`, so nothing happens. Kubernetes issue #33664 discusses three workarounds. Deleting
Pods manually is risky and causes downtime. Putting version tags in the config requires an edit
and commit for every build, and config files cannot read environment variables. The course uses
the third option: tag and push a versioned image, then run an imperative command:
`kubectl set image deployment/client-deployment client=<docker-id>/multi-client:v5`. If the
browser still shows the old page, refresh with the cache disabled or rerun the command. A later
CI script automates these steps.

## Docker inside the Minikube node (207–210)

Per the [lecture 207 reminder](./207-reminder-for-docker-desktops-kubernetes-users.md), these
lectures do not apply to Docker Desktop's Kubernetes, which has no separate Docker daemon in a VM.
Those users can skip to Section 14.

The Minikube VM runs its own Docker server. `eval $(minikube docker-env)` sets environment
variables such as `DOCKER_HOST` so the Docker CLI in the current terminal uses the node's Docker
server; `docker ps` then lists the Kubernetes containers. Running `minikube docker-env` alone
prints the command. This gives access to `docker logs`, `docker exec -it <id> sh`, and
`docker system prune -a` for clearing cached images. `kubectl logs` and `kubectl exec` provide
similar debugging. You can also delete containers to watch Kubernetes recreate them.
