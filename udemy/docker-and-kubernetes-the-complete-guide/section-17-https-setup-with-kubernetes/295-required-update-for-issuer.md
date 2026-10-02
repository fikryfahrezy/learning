# Required Update for Issuer

In the upcoming lecture, the Issuer manifest will need a few small changes per these docs:

https://docs.cert-manager.io/en/latest/tasks/issuers/setup-acme/index.html#creating-a-basic-acme-issuer

1. Update **apiVersion**:

   ```yaml
   apiVersion: cert-manager.io/v1
   ```

2. Add a **solvers** property:

   ```yaml
       solvers:
         - http01:
             ingress:
               class: nginx
   ```

The full **issuer.yaml** manifest can be found below:

```yaml
apiVersion: cert-manager.io/v1
kind: ClusterIssuer
metadata:
  name: letsencrypt-prod
spec:
  acme:
    server: https://acme-v02.api.letsencrypt.org/directory
    email: "test@test.com"
    privateKeySecretRef:
      name: letsencrypt-prod
    solvers:
      - http01:
          ingress:
            class: nginx
```
