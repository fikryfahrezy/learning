# Nginx connect() failed - Connection refused while connecting to upstream

A small number of students are hitting an edge case where the nginx upstream connection is failing after they run `docker-compose up --build`:

```sh
connect() failed (111: Connection refused) while connecting to upstream, client:[DOCKER INTERNAL IP], server:, request: "GET / HTTP/1.1", upstream: [NETWORK IP]
```

The solution they found was to add this to their nginx service in the docker-compose.yml file:

```yaml
  nginx:
    depends_on:
      - api
      - client
```

## Resources for this lecture

- [133-nginx.zip](./133-nginx.zip)
