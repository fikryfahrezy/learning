# Quiz 4: On FROM

## Question 1

What does the `FROM` command do?

- [x] `FROM` copies the filesystem snapshot and default command from another image into the custom image we are building
- [ ] `FROM` copies only the filesystem snapshot from another image into the custom image we are building
- [ ] `FROM` sets up an OOP inheritance chain between image objects

## Question 2

**Note: This is a tricky question!**

The `hello-world` image has a filesystem snapshot has exactly *one file* inside of it, the `hello` file. This is a program that is executed when you first execute the `hello-world` image as a container. The `hello-world` image has *absolutely no other programs inside of it.*

With that in mind, what would happen if we tried to build an image with this Dockerfile:

```dockerfile
FROM hello-world
RUN apk add nodejs
CMD ["node", "-e", "console.log('hi there');"]
```

- [ ] We would get an error message because hello-world is not a valid base image
- [x] We would get an error message during the `RUN apk add nodejs` command. We would see this error message because our image doesn't have an `apk` program, since it didn't inherit `apk` from `hello-world`
- [ ] Everything would work as expected.
