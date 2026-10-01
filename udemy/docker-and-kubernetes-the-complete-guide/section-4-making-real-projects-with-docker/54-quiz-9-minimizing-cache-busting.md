# Quiz 9: Minimizing Cache Busting

## Question 1

You are working on a Python project. The project directory has two files: `requirements.txt` and `main.py`.

Your Dockerfile to build the project looks like this:

```dockerfile
FROM python
WORKDIR /app
ADD ./ ./
RUN pip install -r requirements.txt
CMD ["python", "main.py"]
```

The `requirements.txt` lists dependencies for the project. It does not change very often. It is used by a tool called `pip` to install dependencies into the project. This takes several minutes.

Your `main.py` file changes very often. Every time you change it, rebuilding your image takes several minutes!

How can you change the Dockerfile to speed up the build process?

- [ ] Change the Dockerfile to:

  ```dockerfile
  FROM python
  WORKDIR /app
  ADD ./main.py ./
  RUN pip install -r requirements.txt
  ADD ./requirements.txt ./
  CMD ["python", "main.py"]
  ```

- [ ] Change the Dockerfile to:

  ```dockerfile
  FROM python
  WORKDIR /app
  COPY ./* ./
  RUN pip install -r requirements.txt
  CMD ["python", "main.py"]
  ```

- [x] Change the Dockerfile to:

  ```dockerfile
  FROM python
  WORKDIR /app
  ADD ./requirements.txt ./
  RUN pip install -r requirements.txt
  ADD ./main.py ./
  CMD ["python", "main.py"]
  ```
