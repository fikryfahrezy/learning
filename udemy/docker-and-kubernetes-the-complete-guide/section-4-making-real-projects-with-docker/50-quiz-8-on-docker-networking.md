# Quiz 8: Quiz on Docker Networking

## Question 1

Your team's microservice listens on port 3000 inside the container. To access it on port 9000 on your host machine, which command is correct?

- [ ] `docker run -p 3000:9000 myapp`
- [x] `docker run -p 9000:3000 myapp`
- [ ] `docker build -p 9000:3000 myapp`
- [ ] `docker run --port 9000-3000 myapp`

## Question 2

If you have multiple containers that all need to expose port 80, which approach would work?

- [ ] Run them all with `-p 80:80`
- [ ] Change the internal ports to different numbers
- [x] Map them to different host ports (8080:80, 8081:80, etc.)
- [ ] Use docker compose to manage conflicts

## Question 3

You have three microservices: frontend (port 3000), backend (port 5000), and database (port 5432). If all are running as separate containers on the same host, which statement is correct?

- [ ] They automatically share the same network and can communicate using localhost
- [ ] Only the frontend can access the backend
- [ ] Port conflicts will prevent them from running simultaneously
- [x] Each container has its own isolated network namespace
