# Required Update for the HTTPS Ingress

In the upcoming lecture, we need to make one small change to one of the annotations:

```yaml
certmanager.k8s.io/cluster-issuer: "letsencrypt-prod"
```

change to:

```yaml
cert-manager.io/cluster-issuer: "letsencrypt-prod"
```
