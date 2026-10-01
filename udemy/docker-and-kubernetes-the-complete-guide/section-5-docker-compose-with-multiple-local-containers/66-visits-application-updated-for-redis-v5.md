# Visits Application Updated for Redis v5+

Some students have requested updated code for the Visits application that supports more current versions of Redis. Here is the updated index.js file that will work with Redis v5+:

```js
const express = require("express");
const redis = require("redis");
const process = require("process");
 
const app = express();
const client = redis.createClient({
  socket: {
    host: "redis-server",
    port: 6379,
  },
});
 
client.connect();
client.set("visits", 0);
 
app.get("/", async (req, res) => {
  const visits = await client.get("visits");
  res.send("Number of visits " + visits);
  await client.set("visits", parseInt(visits) + 1);
});
 
app.listen(8081, () => {
  console.log("listening on port 8081");
});
```

## Resources for this lecture

- [visits-redis-v5.zip](./visits-redis-v5.zip)