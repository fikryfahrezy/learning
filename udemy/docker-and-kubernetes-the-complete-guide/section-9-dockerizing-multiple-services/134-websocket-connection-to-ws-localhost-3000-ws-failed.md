# WebSocket connection to 'ws://localhost:3000/ws' failed

In the next lecture, we will be adding some code to our Nginx service to support WebSockets. Create React App v5 currently contains many breaking changes and some bugs. There is currently an open issue regarding WebSockets:

https://github.com/facebook/create-react-app/issues/11779

This will cause an error to be seen in the browser console:

***WebSocket connection to 'ws://localhost:3000/ws' failed***:

The solution is to set an environment variable on the client service in the **docker-compose.yml**:

```yaml
  client:
    environment:
      - WDS_SOCKET_PORT=0
```

Then, in the **nginx/default.conf** change this line:

```sh
  location /sockjs-node {
```

to this:

```sh
  location /ws {
```

Here is the full block of code for context:

```sh
  location /ws {
      proxy_pass http://client;
      proxy_http_version 1.1;
      proxy_set_header Upgrade $http_upgrade;
      proxy_set_header Connection "Upgrade";
  }
```
