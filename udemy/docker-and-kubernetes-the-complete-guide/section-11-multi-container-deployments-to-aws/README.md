# Section 11 — Multi-Container Deployments to AWS

Summary of lectures 148–172. Deploy the images from Section 10 to **AWS Elastic Beanstalk**,
connect them to managed **RDS PostgreSQL** and **ElastiCache Redis**, then let CI deploy later
changes. The lectures show a legacy `Dockerrun.aws.json` workflow, but the required course update
uses a **production `docker-compose.yml`** on the current Elastic Beanstalk Docker platform.

> **Follow [lecture 150's required update](./150-required-update-docker-compose-instead-of-dockerrun-aws-json.md)
> for deployment.** Rename the local file to `docker-compose-dev.yml` and use `-f` when starting
> it. Create a separate production `docker-compose.yml` with the Docker Hub images, memory limits,
> hostnames, nginx's `80:80` port mapping, and the server/worker environment variables. Remove
> `Dockerrun.aws.json` from the project directory; the note says its presence causes deployment
> failure on the newer platform. Compose networking replaces the legacy container links.

## Describe the containers and create the environment (148–155)

Lectures 148–153 explain how the older Elastic Beanstalk multi-container platform identified
images, ports, memory, and links in `Dockerrun.aws.json`. Those concepts still explain the
deployment, but the file format is superseded by lecture 150's production Compose file. Give
Elastic Beanstalk an environment on the Docker platform, and use the course's AWS configuration
cheat sheet for the newer console screens. Keep the Compose service and image names aligned with
the images pushed by CI.

## Connect managed data services (156–162)

Production PostgreSQL and Redis are separate managed services rather than containers inside the
Elastic Beanstalk app. Create an RDS PostgreSQL database and an ElastiCache Redis instance in the
intended region and VPC. A shared security group permits communication among the Elastic
Beanstalk instances, RDS, and ElastiCache; create its rule and apply the group to all three.

Set Elastic Beanstalk environment properties for the PostgreSQL connection (`PGUSER`, `PGHOST`,
`PGDATABASE`, `PGPASSWORD`, `PGPORT`) and Redis connection (`REDIS_HOST`, `REDIS_PORT`). Use the
managed service endpoints for the host values. The production Compose file explicitly passes
the relevant variables into the server and worker containers, as lecture 150 requires. Keep
database credentials and deployment keys out of the repository.

## Deploy and verify (163–169)

Create an IAM user for deployment, store its AWS access key and secret as protected Travis
variables, and configure Travis's Elastic Beanstalk deploy step. The
[lecture 164 correction](./164-travis-keys-update.md) uses `access_key_id: $AWS_ACCESS_KEY` and
`secret_access_key: $AWS_SECRET_KEY`. CI tests, builds, and pushes the Docker images; deployment
then prompts Elastic Beanstalk to pull them and start the Compose services.

Set container memory limits in the production configuration, inspect Elastic Beanstalk health and
logs, and test a Fibonacci submission through the public URL. The lectures then change the React
heading, push another commit, and verify that the new image appears after redeployment. The
feature branch and pull request workflow from Section 7 also applies to these updates.

## Cleanup and references (170–172)

When finished, delete the Elastic Beanstalk environment, RDS database, and ElastiCache instance
to stop their running costs. The section also removes its security group and deployment IAM user.
The [AWS configuration cheat sheet](./171-aws-configuration-cheat-sheet.md) lists console steps,
and [lecture 172](./172-finished-project-code-with-updates-applied.md) links the finished project
with course updates applied.
