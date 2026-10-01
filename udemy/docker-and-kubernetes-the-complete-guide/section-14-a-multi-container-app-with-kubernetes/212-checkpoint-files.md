# Checkpoint Files

Attached to this section is a zip file with the current state of my 'complex' multi-container project. If you made any changes to your copy of the multi-container project, or if you didn't get it working, then download this zip file and use my copy.

Remember to use the updated command to run the development compose file when testing:

```sh
docker-compose -f docker-compose-dev.yml up
docker-compose -f docker-compose-dev.yml up --build
docker-compose -f docker-compose-dev.yml down
```

**Note** - If you are not using the checkpoint files you will need to remove the **ssl** property from the pool constructor, which was added in a previous section to address an issue with AWS' hosted Postgres. This will cause a conflict when using locally with Kubernetes and in production with Google Cloud.

After this change make sure to rebuild and redeploy your server image.

Find your **server/index.js** and make sure it looks like this:

```js
...

const pgClient = new Pool({
  user: keys.pgUser,
  host: keys.pgHost,
  database: keys.pgDatabase,
  password: keys.pgPassword,
  port: keys.pgPort,
});

...
```

## Resources for this lecture

- [208-checkpoint.zip](./208-checkpoint.zip)
