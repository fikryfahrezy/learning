# Section 8 — Building a Multi-Container Application

Summary of lectures 112–125. This section builds the source code for a deliberately elaborate
Fibonacci calculator so the next sections have several services to containerize. A **React client**
sends requests to an **Express API**; **PostgreSQL** remembers submitted indexes, while **Redis**
holds calculated values and carries work to a separate **worker**. Docker setup starts in Section 9.
If you only want the Docker material, lecture 114 points to the completed checkpoint code there.

## Why multiple services? (112–115)

The earlier single-container React deployment had no API or data store. It cannot demonstrate how
containers communicate or how a deployment handles several processes. The calculator is intentionally
more complex than its task requires: enter a Fibonacci index, then see both the submitted indexes
and the results as they arrive.

| Component | Responsibility |
| --- | --- |
| React client | Collects an index and displays previous indexes and calculated values. |
| Express API | Receives browser requests, writes submitted indexes, and returns saved data. |
| PostgreSQL | Persists the history of submitted indexes. |
| Redis | Holds current results and publishes indexes for calculation. |
| Worker | Subscribes to new indexes, calculates Fibonacci values, and writes results to Redis. |

The two stores have different jobs: PostgreSQL preserves submission history; Redis carries pending
work and computed results. The worker can process a submission separately from the web request.

## Build the worker and API (116–120)

- The `worker` Node project connects to Redis, subscribes to new indexes, runs the recursive
  Fibonacci calculation, and saves each result in Redis.
- The `server` Express project reads PostgreSQL and Redis connection settings from environment
  variables. Its PostgreSQL pool creates a `values` table if needed. The API exposes the list of
  submitted indexes, the current results, and an endpoint for submitting an index.
- A new index is written to PostgreSQL, given a pending value in Redis, and published for the
  worker. The browser can later fetch the completed value from Redis.

**Lecture 118 correction:** Run the `CREATE TABLE IF NOT EXISTS values (number INT)` query from
the PostgreSQL pool's `connect` handler, after a connection is available. The note also adds an
`ssl` setting for production and sets `NODE_ENV` in the server's `dev` and `start` scripts.
Follow [the source note](./118-important-update-for-pgclient-and-table-query.md) when writing
`server/index.js`.

## Build the React client (121–125)

The supplied `client` boilerplate is a generated React project. Its `Fib` component requests
`/api/values/all` and `/api/values/current`, displays the saved indexes and values, and posts a
new index to `/api/values`. The form clears its input after submission. Export `Fib` from its
module, as lecture 124 corrects. The app also adds a second page and React Router navigation.

The API path starts with `/api` from the browser's point of view; Section 9 configures nginx to
send those requests to Express. At the end of this section, the pieces of the application exist,
but they have not yet been brought up together with Docker Compose.
