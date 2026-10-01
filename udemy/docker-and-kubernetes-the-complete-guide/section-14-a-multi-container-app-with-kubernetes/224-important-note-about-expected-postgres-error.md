# Important Note about Expected Postgres Error

updated 4-27-2020

In the upcoming lecture, we will be creating a Postgres deployment and then applying the changes. At about 5:21 In the video lecture, Stephen will show the Postgres pod in a running state. Due to a change in the Postgres base image that we are using, this is no longer true. **If your Postgres pod is showing an error, this is 100% expected and does not currently need to be resolved.** We will need to add environment variables to our pods starting with the "[Defining Environment Variables](./235-defining-environment-variables.txt)" lecture. The Postgres pod should be in a running state by the "[Environment Variables as Strings](./240-environment-variables-as-strings.txt)" lecture.

You will most certainly see an error like this:

```
client-deployment-56969998db-7cgcd 1/1 Running 0 21s
client-deployment-56969998db-qtjvs 1/1 Running 0 29s
client-deployment-56969998db-src86 1/1 Running 0 38s
postgres-deployment-6d786d877-hc2ht 0/1 CrashLoopBackOff 1  23s
redis-deployment-587949d9f6-ght9r 1/1 Running 0 17m
server-deployment-76955dc4c7-6qqgj 1/1 Running 0 26s
server-deployment-76955dc4c7-bfxkm 1/1 Running 0 37s
server-deployment-76955dc4c7-ktdjv 1/1 Running 0 21s
worker-deployment-79496f4856-z9qng 1/1 Running 0 37s
```

If we run `kubectl logs postgres-deployment-6d786d877-fqdtg` we will be able to see why:

```
Error: Database is uninitialized and superuser password is not specified.
You must specify POSTGRES_PASSWORD to a non-empty value for the
superuser. For example, "-e POSTGRES_PASSWORD=password" on "docker run".
You may also use "POSTGRES_HOST_AUTH_METHOD=trust" to allow all
connections without a password. This is *not* recommended.
See PostgreSQL documentation about "trust":
https://www.postgresql.org/docs/current/auth-trust.html
```

As mentioned, we will be setting these variables by the end of the current section.
