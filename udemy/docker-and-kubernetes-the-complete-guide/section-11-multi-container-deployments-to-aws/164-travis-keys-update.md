# Travis Keys Update

In the upcoming lecture, we will be adding our AWS variables to the deploy script of the .travis.yml file. There is a slight change that will be required, otherwise, you will get an error when Travis attempts to run your code.

The code will now look like this:

```
access_key_id: $AWS_ACCESS_KEY
secret_access_key: $AWS_SECRET_KEY
```

The full deploy section will look like this:

```yaml
deploy:
  provider: elasticbeanstalk
  region: 'us-east-1'
  app: 'multi-docker'
  env: 'MultiDocker-env'
  bucket_name: 'elasticbeanstalk-us-east-1-923445559289'
  bucket_path: 'docker-multi'
  on:
    branch: master
  access_key_id: $AWS_ACCESS_KEY
  secret_access_key: $AWS_SECRET_KEY
```
