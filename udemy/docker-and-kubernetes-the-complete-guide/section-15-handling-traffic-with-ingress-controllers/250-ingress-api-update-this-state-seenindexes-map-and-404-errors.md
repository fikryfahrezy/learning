# Ingress API Update + "this.state.seenIndexes.map..." + 404 errors

In the upcoming lecture, we will be creating our ingress-service.yaml configuration file. Since the recording of the lecture, there has been a major API update as well as a change in how we need to specify some of these rules.

The v1 Ingress API is now required as of Kubernetes v1.22 and the v1beta1 will no longer work.

Required changes (scroll to bottom for full code):

- Update apiVersion to v1
- Add use-regex annotation to address certain 404 errors on localhost and Google Cloud
- Update rewrite-target annotation
- Add PathType to each path
- Modify serviceName and servicePort fields to use the new syntax.
- Update "/" and "/api" paths to resolve _TypeError: this.state.seenIndexes.map is not a function_ error
- Remove the Ingress class Annotation
- Add ingressClassName field under "spec"

Documentation link for reference:

https://kubernetes.io/docs/concepts/services-networking/ingress/

```yaml
apiVersion: networking.k8s.io/v1
# UPDATE API
kind: Ingress
metadata:
  name: ingress-service
  annotations:
    # REMOVE CLASSNAME ANNOTATION
    nginx.ingress.kubernetes.io/use-regex: 'true'
    # ADD ANNOTATION
    nginx.ingress.kubernetes.io/rewrite-target: /$1
    # ADD ANNOTATION
spec:
  ingressClassName: nginx
  # ADD INGRESSCLASSNAME FIELD
  rules:
    - http:
        paths:
          - path: /?(.*)
            # UPDATE PATH
            pathType: ImplementationSpecific
            # ADD PATHTYPE
            backend:
              service:
                # UPDATE SERVICE FIELDS
                name: client-cluster-ip-service
                port:
                  number: 3000
          - path: /api/?(.*)
            # UPDATE PATH
            pathType: ImplementationSpecific
            # ADD PATHTYPE
            backend:
              service:
                # UPDATE SERVICE FIELDS
                name: server-cluster-ip-service
                port:
                  number: 5000
```

## Resources for this lecture

- [ingress-service.yaml.zip](./ingress-service.yaml.zip)
