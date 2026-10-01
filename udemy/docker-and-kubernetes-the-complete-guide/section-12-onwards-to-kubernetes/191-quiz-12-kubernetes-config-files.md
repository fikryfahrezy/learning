# Quiz 12: Kubernetes Config Files

## Question 2

You write out a config file like the following and apply it to your cluster:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: my-app-pod
spec:
  containers:
    - name: my-app
      image: my-image
```

You then update this config file with a new name and a labels section and apply it to the cluster:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: web-app
  labels:
    component: web
spec:
  containers:
    - name: my-app
      image: my-image
```

What happens when you apply this updated config file?

- [x] The config file has a different `name`, so kubectl will create a brand new pod with the given config.
- [ ] The config file has an updated label, so it will apply that label to the existing pod named `my-app-pod`.
