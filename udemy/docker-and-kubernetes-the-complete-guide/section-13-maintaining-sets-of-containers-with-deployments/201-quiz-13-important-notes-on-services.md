# Quiz 13: Important Notes on Services

## Question 1

What is the goal of a service?

- [ ] It implements an API server backed by some kind of data store
- [x] It gives consistent access to a set of pods
- [ ] It runs code at scheduled intervals

## Question 2

You create a service using the following config file:

```yaml
apiVersion: v1
kind: Service
metadata:
  name: my-api
spec:
  type: ClusterIP
  selector:
    component: web
  ports:
    - port: 8080
```

What hostname and port would you use to make a request to this service and, thus, the pods it points at?

- [ ] `http://component-web:8080`
- [ ] `http://component-web:8080:8080`
- [x] `http://my-api:8080`

## Question 3

Can a Service of type 'ClusterIP' be used to access a pod from **outside the cluster**?

- [ ] Yes
- [x] No
