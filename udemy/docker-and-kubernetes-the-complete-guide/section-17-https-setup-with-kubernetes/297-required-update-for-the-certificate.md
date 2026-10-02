# Required Update for the Certificate

In the upcoming lecture, a few minor changes are required per the official docs:

1. Update the API version used:

   ```yaml
   apiVersion: cert-manager.io/v1
   ```

2. Remove the acme challenge from the certificate spec.

The full updated Certificate manifest can be found below:

```yaml
apiVersion: cert-manager.io/v1

kind: Certificate
metadata:
  name: yourdomain-com-tls
spec:
  secretName: yourdomain-com
  issuerRef:
    name: letsencrypt-prod
    kind: ClusterIssuer
  commonName: yourdomain.com
  dnsNames:
    - yourdomain.com
    - www.yourdomain.com
```

QA thread for reference with some troubleshooting steps (see Joseph's post near the bottom)

https://www.udemy.com/course/docker-and-kubernetes-the-complete-guide/learn/lecture/11628364#questions/8558842/
