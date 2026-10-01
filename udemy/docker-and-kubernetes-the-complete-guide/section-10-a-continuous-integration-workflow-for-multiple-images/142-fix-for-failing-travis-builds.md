# Fix for Failing Travis Builds

In the upcoming lecture, we will be adding a script to our .travis.yml file. Due to a change in how the Jest library works with Create React App, we need to make a small modification:

```
script:
  - docker run USERNAME/react-test npm test -- --coverage
```

instead should be:

```
script:
  - docker run -e CI=true USERNAME/react-test npm test
```

You can read up on the CI=true variable here:

https://facebook.github.io/create-react-app/docs/running-tests#linux-macos-bash

and environment variables in Docker here:

https://docs.docker.com/engine/reference/run/#env-environment-variables

Additionally, you may want to set the following property if your travis build fails with “rakefile not found” by adding to the top of your .travis.yml file:

```yaml
language: generic 
```
