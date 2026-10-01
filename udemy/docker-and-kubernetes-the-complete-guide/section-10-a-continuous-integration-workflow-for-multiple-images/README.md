# Section 10 — A Continuous Integration Workflow for Multiple Images

Summary of lectures 136–147. The local multi-service app gains **production Dockerfiles** and a
CI pipeline. On a GitHub push, Travis CI builds and tests the project, builds production images
for its services, and pushes those images to Docker Hub. Section 11 connects those images to AWS.

## Prepare production images (136–140)

The deployment will pull ready-made images from Docker Hub instead of building each project on
Elastic Beanstalk. The server and worker each receive a production Dockerfile. The React client
uses a multi-stage build: Node creates static assets and nginx serves them. A separate, front-facing
nginx image continues to route browser traffic to the client and API, so production has **two nginx
instances with different roles**.

Configure the client's nginx to listen on port `3000`, where the front-facing proxy expects it.
The [React Router correction](./139-nginx-fix-for-react-router.md) adds
`try_files $uri $uri/ /index.html;` so direct visits and refreshes on client-side routes work.
The proxy's own Dockerfile copies its route configuration into the nginx image.

## Test, build, and push in CI (141–146)

- The starter React test tries to contact an API that is absent while its isolated test image runs.
  Lecture 141 removes that request from the test. A fuller suite would mock the API instead.
- Travis builds a development client image and runs its tests before preparing deployment images.
  The [lecture 142 correction](./142-fix-for-failing-travis-builds.md) uses
  `docker run -e CI=true USERNAME/react-test npm test` for current Create React App behavior.
- Create a GitHub repository, connect it to Travis, and define image builds in `.travis.yml` for
  the client, server, worker, and nginx services.
- Sign in to Docker Hub from CI with credentials stored as CI variables, then push the four
  production images. Check the Travis log and Docker Hub repositories to confirm the build and
  upload succeeded.

The image names must agree between the CI build and push commands and the production deployment
configuration in Section 11. The videos use Travis CI; the course's later update also supplies
an example project using GitHub Actions.

## Updated application code (147)

[Lecture 147](./147-multi-container-update-for-redis-v5-react-hooks-react-router-v6.md) includes
an updated downloadable project for Redis v5+, React Hooks, React Router v6+, and GitHub Actions.
Use it when following the course with those newer dependencies, since the earlier video code uses
older APIs.
