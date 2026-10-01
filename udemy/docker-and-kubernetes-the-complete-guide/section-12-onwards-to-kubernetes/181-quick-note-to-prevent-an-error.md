# Quick Note to Prevent an Error

updated 4-16-2020

In the upcoming lecture, Stephen will be creating the `client-pod.yaml` configuration file. You may get a blank page with an error in your console when you attempt to run the pod or deployment in a future lecture:

```text
react-dom.production.min.js:209 TypeError:
this.state.seenIndexes.map is not a function
```

This is because we added the following line to our `client/nginx/default.conf` file in the earlier Docker lectures:

```nginx
try_files $uri $uri/ /index.html;
```

This line was added to resolve some React Router issues our client app was having. However, it will break this demo because we have no Nginx container or Ingress service in place.

The best way to resolve this is to use Stephen's Client image in the pod and deployment for these demos, instead of your own:

```yaml
image: stephengrider/multi-client
```

To be clear, this issue will not affect the multi-container Kubernetes project we will be building in Section 14. This is just a quick demo and we will not be reusing these files.
