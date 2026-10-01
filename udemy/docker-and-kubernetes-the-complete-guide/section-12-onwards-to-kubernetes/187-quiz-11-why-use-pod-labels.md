# Quiz 11: Why Use Pod Labels?

## Question 1

You are working on a new project and find a config file like the following:

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: mongodb-pod
  labels:
    appname: socialnetwork
    component: database
```

Based on the `labels` section, which of the following is probably true?

- [ ] The pod that is created is tied to some kind of `mongodb` app and probably implements a `socialnetwork`.
- [x] The pod that is created is tied to some kind of `socialnetwork` app and probably contains a `database`.
