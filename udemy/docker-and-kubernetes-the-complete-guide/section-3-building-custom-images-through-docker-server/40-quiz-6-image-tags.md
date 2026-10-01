# Quiz 6: Image Tags

## Question 1

You are working on a Python project, writing code to work with *only Python v3.8*. You write a Dockerfile like the following to run your code:

```dockerfile
FROM python
RUN ["python", "main.py"]
```

You build your image, create a container from it, and everything works!

Then, *three years in the future*, you make a change to this project and rebuild the image. When you try to create a container, you get an error message!

What is one possible reason to explain the error message you see?

- [x] We didn't specify a version of the `python` image to use, so Docker automatically used the `latest` tag. That means we might have got Python v3.8 during the initial build, but maybe Python v4.5 (or some future version) when we rebuilt the image three years later.
- [ ] We didn't build the image with an argument to specify the version of Python we needed.
- [ ] The Python image we used probably didn't contain the Python executable
