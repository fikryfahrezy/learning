# Quiz 3: Quiz on Docker Command Execution

## Question 1

A container is running a Node.js application. You need to check which npm packages are installed. Which command would accomplish this?

- [ ] `docker inspect CONTAINER_ID`
- [x] `docker exec CONTAINER_ID npm list`
- [ ] `docker logs CONTAINER_ID | grep npm`
- [ ] `docker run IMAGE npm list`

## Question 2

What is the relationship between stdin, stdout, and the `-it` flags?

- [ ] `-i` connects to stdout, `-t` connects to stdin
- [x] `-i` connects to stdin, `-t` formats the terminal output
- [ ] Both flags only affect stdout
- [ ] The flags are unrelated to these channels

## Question 3

A container process writes error messages. If you run the container without specifying any attach flags (such as `-a stderr`), where will the stderr output typically go?

- [x] Without proper flags, stderr output would be lost
- [ ] They would be saved to a log file automatically
- [ ] They would appear in the Docker daemon logs only
- [ ] They would be captured but not displayed to the terminal

## Question 4

You need to debug a web application running in a container. Which approach would give you the most flexibility for troubleshooting?

- [ ] Running `docker logs` to view output
- [x] Using `docker exec -it CONTAINER_ID sh` to get shell access
  - You can inspect logs, config files, environment variables, network settings, and running services **from inside** the environment.
- [ ] Restarting the container with verbose logging
- [ ] Using `docker inspect` to view configuration
