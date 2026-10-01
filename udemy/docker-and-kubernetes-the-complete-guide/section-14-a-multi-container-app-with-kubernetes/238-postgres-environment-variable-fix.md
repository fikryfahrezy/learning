# Postgres Environment Variable Fix

_updated 10-12-2020_

Due to a recent change in the official Postgres image hosted on the DockerHub we need to make a change to our environment variables.

When adding the name variable to the **postgres-deployment.yaml** file, instead of using the following:

```yaml
env:
  - name: PGPASSWORD
```

Change to:

```yaml
env:
  - name: POSTGRES_PASSWORD
```

**DO NOT** update the server deployment's environment variables. This update **only** applies to the **postgres-deployment.yaml**
