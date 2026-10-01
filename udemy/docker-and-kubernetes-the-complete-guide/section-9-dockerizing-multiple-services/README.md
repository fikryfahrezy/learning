# Section 9 — Dockerizing Multiple Services

Summary of lectures 117–135. The Fibonacci app from Section 8 becomes a local development stack:
**client**, **server**, **worker**, **PostgreSQL**, **Redis**, and an **nginx reverse proxy**.
Dockerfiles package the Node projects; Docker Compose builds and connects all six services.

## Get the project ready (117–122)

If you skipped the JavaScript implementation, use the checkpoint files from lecture 117 to create
a `complex` project with `client`, `server`, and `worker` directories. Lecture 118 reconciles this
checkpoint with the code written in Section 8.

Add a `Dockerfile.dev` to each Node project. The React client starts its development server; the
Express server and worker start their Node processes. Build and run each image once to catch setup
errors before composing the full stack. Newer Create React App versions can print different normal
startup output than the video shows; lecture 119 calls this out.

**PostgreSQL correction (122):** The Compose `postgres` service needs a `POSTGRES_PASSWORD` value.
The [lecture note](./122-postgres-database-required-fixes-and-updates.md) uses
`POSTGRES_PASSWORD=postgres_password` and recommends recreating the stack with
`docker-compose down && docker-compose up --build`.

## Compose the services (123–127)

The Compose file first adds PostgreSQL and Redis from their images, then builds the server,
worker, and client from their development Dockerfiles. Bind mounts bring local source changes into
the Node containers, while separate `/app/node_modules` volumes keep container dependencies intact.
Compose service names such as `postgres` and `redis` serve as hostnames on the shared network.

Pass the server its PostgreSQL and Redis host, port, database, user, and password settings. The
worker also needs `REDIS_HOST=redis` and `REDIS_PORT=6379`; the
[lecture 126 update](./126-required-worker-environment-variables.md) supplies these values to
avoid a result that stays at “Calculated Nothing Yet.”

## Route traffic through nginx (128–130)

The browser reaches **one published nginx port**. nginx sends `/api/...` requests to Express and
other page requests to the React development server. Its configuration defines the upstreams and
routes; a small Dockerfile copies that configuration into a custom nginx image. Compose then adds
the nginx service and publishes its container port 80 to a host port (3050 in the lecture).

This keeps the internal service ports off the host and gives the browser a single origin for the
client and API. nginx removes the `/api` prefix before passing API requests to Express, whose
routes are defined without that prefix.

## Start and troubleshoot (131–135)

Run `docker-compose up --build` from the project root and test the calculator in the browser.
On a failed first start, inspect the service logs and retry after fixing errors. Lecture 132
documents an nginx `connect() failed (111: Connection refused)` case. Lecture 133 works through
startup problems and checks that submitting an index eventually shows its Fibonacci result.

The React development server also uses a WebSocket for live updates. nginx must forward the
WebSocket upgrade headers to the client service. For Create React App v5, the
[lecture 134 correction](./134-websocket-connection-to-ws-localhost-3000-ws-failed.md) changes
the nginx route from `/sockjs-node` to `/ws`. Lecture 135 verifies live updates and that refreshing
a client-side route still opens the app.
