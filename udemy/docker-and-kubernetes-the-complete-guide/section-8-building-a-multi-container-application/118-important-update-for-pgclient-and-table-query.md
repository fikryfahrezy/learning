# Important Update for pgClient and Table Query

In the upcoming lecture, we will be adding some code to our server's index.js to make a query and create a table. We'll need to modify this code to ensure that we delay the table query until after a connection is made.

In your **server/index.js** file:

Change these lines:

```sh
pgClient.on('error', () => console.log('Lost PG connection'));
 
pgClient
  .query('CREATE TABLE IF NOT EXISTS values (number INT)')
  .catch(err => console.log(err));
```

to this:

```sh
pgClient.on("connect", (client) => {
  client
    .query("CREATE TABLE IF NOT EXISTS values (number INT)")
    .catch((err) => console.error(err));
});
```

Also, to resolve an issue later on in the course for production, we will need to add the ssl property to our pool constructor:

```sh
const pgClient = new Pool({
  user: keys.pgUser,
  host: keys.pgHost,
  database: keys.pgDatabase,
  password: keys.pgPassword,
  port: keys.pgPort,
  ssl:
    process.env.NODE_ENV !== 'production'
      ? false
      : { rejectUnauthorized: false },
});
```

Then, update the **server/package.json** file to set these NODE_ENV variables when the server is started:

```json
  "scripts": {
    "dev": "NODE_ENV=development nodemon",
    "start": "NODE_ENV=production node index.js"
  }
```
