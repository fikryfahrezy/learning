# Multi Container Update for Redis v5+, React Hooks, React Router v6+

Some students have requested updated code for the Multi Container application that supports Redis v5+, React Hooks, and React Router v6+, with GitHub Actions. The completed project code is attached as a downloadable zip file.

## Worker

index.js

```js
const keys = require("./keys");
const redis = require("redis");
 
const redisClient = redis.createClient({
  socket: {
    host: keys.redisHost,
    port: keys.redisPort,
    reconnectStrategy: () => 1000,
  },
});
 
const sub = redisClient.duplicate();
 
redisClient.connect();
sub.connect();
 
function fib(index) {
  if (index < 2) return 1;
  return fib(index - 1) + fib(index - 2);
}
 
sub.subscribe("insert", (message) => {
  redisClient.hSet("values", message, fib(parseInt(message)));
});
```

package.json

```json
{
  "dependencies": {
    "nodemon": "^3.1.4",
    "redis": "^5.8.3"
  },
  "scripts": {
    "start": "node index.js",
    "dev": "nodemon"
  }
}
```

## Server

index.js

```js
const keys = require("./keys");
 
// Express App Setup
const express = require("express");
const bodyParser = require("body-parser");
const cors = require("cors");
 
const app = express();
app.use(cors());
app.use(bodyParser.json());
 
// Postgres Client Setup
const { Pool } = require("pg");
const pgClient = new Pool({
  user: keys.pgUser,
  host: keys.pgHost,
  database: keys.pgDatabase,
  password: keys.pgPassword,
  port: keys.pgPort,
});
 
pgClient.on("connect", (client) => {
  client
    .query("CREATE TABLE IF NOT EXISTS values (number INT)")
    .catch((err) => console.error(err));
});
 
// Redis Client Setup
const redis = require("redis");
const redisClient = redis.createClient({
  url: `redis://${keys.redisHost}:${keys.redisPort}`,
  retry_strategy: () => 1000,
});
const redisPublisher = redisClient.duplicate();
 
(async () => {
  await redisClient.connect();
  await redisPublisher.connect();
})();
 
// Express route handlers
 
app.get("/", (req, res) => {
  res.send("Hi");
});
 
app.get("/values/all", async (req, res) => {
  const values = await pgClient.query("SELECT * from values");
 
  res.send(values.rows);
});
 
app.get("/values/current", async (req, res) => {
  const values = await redisClient.hGetAll("values");
  res.send(values);
});
 
app.post("/values", async (req, res) => {
  const index = req.body.index;
 
  if (parseInt(index) > 40) {
    return res.status(422).send("Index too high");
  }
 
  await redisClient.hSet("values", index, "Nothing yet!");
  await redisPublisher.publish("insert", index);
  pgClient.query("INSERT INTO values(number) VALUES($1)", [index]);
 
  res.send({ working: true });
});
 
app.listen(5000, (err) => {
  console.log("Listening");
});
```

package.json

```json
{
  "dependencies": {
    "body-parser": "^1.20.2",
    "cors": "^2.8.5",
    "express": "^4.19.2",
    "nodemon": "^3.1.4",
    "pg": "^8.12.0",
    "redis": "^4.7.0"
  },
  "scripts": {
    "dev": "nodemon",
    "start": "node index.js"
  }
}
```

## Client

index.js

```js
import React from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App";
 
const container = document.getElementById("root");
const root = createRoot(container);
 
root.render(<App />);
```

App.js

```js
import React from "react";
import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import OtherPage from "./OtherPage";
import Fib from "./Fib";
 
function App() {
  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <a
            className="App-link"
            href="https://reactjs.org"
            target="_blank"
            rel="noopener noreferrer"
          >
            Learn React
          </a>
          <Link to="/">Home</Link>
          <Link to="/otherpage">Other Page</Link>
        </header>
        <Routes>
          <Route path="/" element={<Fib />} />
          <Route path="/otherpage" element={<OtherPage />} />
        </Routes>
      </div>
    </Router>
  );
}
 
export default App;
```

Fib.js

```js
import React, { useState, useEffect } from "react";
import axios from "axios";
 
const Fib = () => {
  const [seenIndexes, setSeenIndexes] = useState([]);
  const [values, setValues] = useState({});
  const [index, setIndex] = useState("");
 
  useEffect(() => {
    fetchValues();
    fetchIndexes();
  }, []);
 
  const fetchValues = async () => {
    const values = await axios.get("/api/values/current");
    setValues(values.data);
  };
 
  const fetchIndexes = async () => {
    const seenIndexes = await axios.get("/api/values/all");
    setSeenIndexes(seenIndexes.data);
  };
 
  const handleSubmit = async (event) => {
    event.preventDefault();
 
    await axios.post("/api/values", {
      index: index,
    });
    setIndex("");
  };
 
  const renderSeenIndexes = () => {
    return seenIndexes.map(({ number }) => number).join(", ");
  };
 
  const renderValues = () => {
    const entries = [];
 
    for (let key in values) {
      entries.push(
        <div key={key}>
          For index {key} I calculated {values[key]}
        </div>
      );
    }
 
    return entries;
  };
 
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <label>Enter your index:</label>
        <input
          value={index}
          onChange={(event) => setIndex(event.target.value)}
        />
        <button>Submit</button>
      </form>
 
      <h3>Indexes I have seen:</h3>
      {renderSeenIndexes()}
 
      <h3>Calculated Values:</h3>
      {renderValues()}
    </div>
  );
};
 
export default Fib;
```

package.json

```json
{
  "name": "client",
  "version": "0.1.0",
  "private": true,
  "dependencies": {
    "@testing-library/jest-dom": "^5.16.5",
    "@testing-library/react": "^13.4.0",
    "@testing-library/user-event": "^13.5.0",
    "axios": "^1.7.3",
    "react": "^18.2.0",
    "react-dom": "^18.2.0",
    "react-router-dom": "^6.26.0",
    "react-scripts": "5.0.1",
    "web-vitals": "^2.1.4"
  },
  "scripts": {
    "start": "react-scripts start",
    "build": "react-scripts build",
    "test": "react-scripts test",
    "eject": "react-scripts eject"
  },
  "eslintConfig": {
    "extends": [
      "react-app",
      "react-app/jest"
    ]
  },
  "browserslist": {
    "production": [
      ">0.2%",
      "not dead",
      "not op_mini all"
    ],
    "development": [
      "last 1 chrome version",
      "last 1 firefox version",
      "last 1 safari version"
    ]
  }
}
```

## Resources for this lecture

- [complex-gh-upgrade.zip](./complex-gh-upgrade.zip)
