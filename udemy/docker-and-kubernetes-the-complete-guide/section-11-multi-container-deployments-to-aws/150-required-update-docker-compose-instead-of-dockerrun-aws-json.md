# Required Update: Docker Compose instead of Dockerrun.aws.json

The latest Amazon Linux Platform no longer supports a Dockerrun.aws.json file, so, instead we will need to configure separate development and production docker-compose files. This note will go over the production docker-compose.yml and the lectures affected. No lectures should be skipped as the knowledge is directly transferable, it just requires a different format.

## Required Updates for Docker Compose

1. Rename the current docker-compose file

Rename the **docker-compose.yml** file to **docker-compose-dev.yml**. Going forward you will need to pass a flag to specify which compose file you want to build and run from:

```sh
docker-compose -f docker-compose-dev.yml up
docker-compose -f docker-compose-dev.yml up --build
docker-compose -f docker-compose-dev.yml down
```

2. Create a production-only docker-compose.yml file

The production compose file will follow closely what was written in the Dockerrun.aws.json. There are two major differences:

**No Container Links**: In the ["Forming Container Links"](https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/learn/lecture/11437364#questions) lecture we add the client and server services to the links array of the nginx service. Docker Compose will handle this container communication automatically for us.

**Environment Variables**: When using a compose file we will need to explicitly specify the environment variables each service will need access to. The value for each variable must match the corresponding variable names you have specified in the Elastic Beanstalk environment. The AWS variables are created in the ["Setting Environment Variables"](https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/learn/lecture/11437388#questions) lecture.

**Note - You must NOT have a Dockerrun.aws.json file in your project directory**. If AWS EBS sees this file the deployment will fail. If you have previously followed this course and deployed to the old Multi-container platform **you will need to delete this file before using the new Amazon Linux 2023 platform!!!**

## Completed docker-compose.yml file:

```yaml
version: "3"
services:
  client:
    image: "rallycoding/multi-client"
    mem_limit: 128m
    hostname: client
  server:
    image: "rallycoding/multi-server"
    mem_limit: 128m
    hostname: api
    environment:
      - REDIS_HOST=$REDIS_HOST
      - REDIS_PORT=$REDIS_PORT
      - PGUSER=$PGUSER
      - PGHOST=$PGHOST
      - PGDATABASE=$PGDATABASE
      - PGPASSWORD=$PGPASSWORD
      - PGPORT=$PGPORT
  worker:
    image: "rallycoding/multi-worker"
    mem_limit: 128m
    hostname: worker
    environment:
      - REDIS_HOST=$REDIS_HOST
      - REDIS_PORT=$REDIS_PORT
  nginx:
    image: "rallycoding/multi-nginx"
    mem_limit: 128m
    hostname: nginx
    ports:
      - "80:80"
```
