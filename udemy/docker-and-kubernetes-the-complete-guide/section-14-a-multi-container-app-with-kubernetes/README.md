# Section 14 — A Multi-Container App with Kubernetes

Summary of lectures 211–240. Move the Fibonacci app from Docker Compose and Elastic Beanstalk
onto a local Kubernetes cluster. The section writes a Deployment and ClusterIP Service for each
component, gives Postgres persistent storage through a PersistentVolumeClaim, and wires up
environment variables and a Secret for the database password.

> **Follow the [lecture 238 fix](./238-postgres-environment-variable-fix.md) when wiring the
> password.** In `postgres-deployment.yaml`, name the variable `POSTGRES_PASSWORD` rather than
> `PGPASSWORD` as the video does. Leave the server deployment's `PGPASSWORD` unchanged.

## The target architecture and a checkpoint (211–214)

The client, server, worker, Redis, and Postgres each run in Pods managed by a Deployment. Redis
and Postgres now run inside the cluster instead of as managed AWS services. An Ingress Service
replaces the NodePort and nginx routing. ClusterIP Services sit in front of every Deployment
except the worker's, and Postgres gets a PVC.

First confirm that the existing project still works. The
[checkpoint files](./212-checkpoint-files.md) provide `208-checkpoint.zip` (extracted here as
`complex-gh/`). Test it with `docker-compose -f docker-compose-dev.yml up --build` rather than the
video's plain `docker-compose up --build`. If you keep your own copy, remove the `ssl` option from
the `Pool` constructor in `server/index.js` and rebuild the server image. Lecture 214 deletes
`.travis.yml`, the Compose and `Dockerrun.aws.json` files, and the `nginx` folder, then creates a
`k8s/` directory and `client-deployment.yaml`. That Deployment runs three `multi-client` replicas
labelled `component: web` on container port `3000`.

## ClusterIP services and applying a directory (215–220)

A ClusterIP Service exposes Pods to other objects in the cluster but not to the outside world, so
users will reach the client and server through the Ingress. It has a `port` (used by other
objects) and a `targetPort` (the Pod's port), but no `nodePort`. `client-cluster-ip-service.yaml`
selects `component: web` and maps `3000` to `3000`.

After you delete the old Deployment and NodePort Service, `kubectl apply -f k8s` applies every
file in the directory. The lecture also fixes a `label` key that should be `labels`.
`server-deployment.yaml` runs three `multi-server` replicas labelled `component: server` on
`5000`, and `server-cluster-ip-service.yaml` forwards `5000` to `5000`. Objects can share a file
when separated by `---`. The course keeps one object per file so each file name shows where an
object is configured.

## Worker, Redis, and Postgres objects (221–225)

`worker-deployment.yaml` runs one `multi-worker` replica with no ports and no Service, because no
other object connects to the worker. Reapplying the directory leaves unchanged objects alone,
because Kubernetes matches objects by name and kind. `redis-deployment.yaml` runs one public
`redis` replica on `6379` behind `redis-cluster-ip-service.yaml`. The Postgres Deployment and
ClusterIP Service do the same for `postgres` on `5432`. As the
[expected Postgres error note](./224-important-note-about-expected-postgres-error.md) explains, the
Postgres Pod now enters `CrashLoopBackOff` because the image requires a password. The video does
not show this error; it is expected until lecture 240.

## Volumes and persistent volumes (226–229)

Data written to a container's file system is lost when the Pod is replaced, so a database needs
storage outside it. Don't simply increase Postgres `replicas` so several Pods share one volume.
A Kubernetes *Volume* belongs to its Pod: it survives container restarts but is deleted with the
Pod. A *PersistentVolume* exists outside the Pod until an administrator deletes it. A
*PersistentVolumeClaim* is like a billboard advertising storage options. When a Pod requests one,
Kubernetes provides a statically provisioned volume or provisions one dynamically.

## Writing and attaching the PVC (230–234)

`database-persistent-volume-claim.yaml` requests `ReadWriteOnce` access and `2Gi` of storage.
`ReadWriteOnce` allows read/write access from one node, `ReadOnlyMany` allows reads from many,
and `ReadWriteMany` allows reads and writes from many. Without `storageClassName`, the claim uses
the default class. `kubectl get storageclass` shows that this is Minikube's `hostPath`, which
uses part of your hard drive. Cloud providers default to storage such as Google Cloud Persistent
Disk or AWS Block Store.

The Postgres Pod template's `volumes` entry, `postgres-storage`, references the claim through
`persistentVolumeClaim.claimName`. The container's `volumeMounts` entry uses the same name, mounts
it at `/var/lib/postgresql/data`, and sets `subPath: postgres` for Postgres. After applying,
`kubectl get pv` shows a bound volume and `kubectl get pvc` lists the claim.

## Environment variables and secrets (235–240)

The worker needs `REDIS_HOST` and `REDIS_PORT`. The server needs those plus `PGUSER`, `PGHOST`,
`PGPORT`, `PGDATABASE`, and `PGPASSWORD`. Each host is the target ClusterIP Service name, such as
`redis-cluster-ip-service`. These go in each container's `env` as `name`/`value` entries.

The password is stored in a Secret, which is created imperatively so the value stays out of the
config files. Run the command in every environment:
`kubectl create secret generic pgpassword --from-literal PGPASSWORD=12345asdf`. The server reads
the password with `valueFrom.secretKeyRef` using `name: pgpassword` and `key: PGPASSWORD`. Postgres
uses the same reference for `POSTGRES_PASSWORD`. The first apply fails with "cannot convert int64
to string" because `env` values must be strings. Quote `"6379"` and `"5432"` to fix it.
