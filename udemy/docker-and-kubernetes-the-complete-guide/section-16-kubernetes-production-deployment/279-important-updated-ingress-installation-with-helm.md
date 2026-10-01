# Important - Updated Ingress Installation with Helm

In the next lecture, we will be installing Ingress Nginx using Helm. You will need to run an updated command instead of what is shown in the video.

In your Google Cloud Console run the following:

```sh
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace
```

Check that your Ingress Controller was deployed:

```sh
kubectl get service ingress-nginx-controller --namespace=ingress-nginx
```

Link to the docs:

https://kubernetes.github.io/ingress-nginx/deploy/#using-helm

## Resources for this lecture

- [Ingress Nginx w/ Helm Docs](https://kubernetes.github.io/ingress-nginx/deploy/#using-helm)
