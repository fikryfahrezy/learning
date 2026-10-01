# Quiz 2: Quiz on Container Management

## Question 1

You need to debug a container that ran yesterday and exited. Which command would help you see what happened without restarting it?

- [ ] `docker start -a CONTAINER_ID`
- [x] `docker logs CONTAINER_ID`
- [ ] `docker run CONTAINER_ID`
- [ ] `docker ps CONTAINER_ID`

## Question 2

A container with status "Exited (0)" in `docker ps -a` indicates what?

- [ ] The container crashed unexpectedly
- [x] The container's main process completed successfully
- [ ] The container is paused
- [ ] The container is corrupted

## Question 3

Your team member created a container that processes data files. The container ID is abc123. How would you run the same processing job again?

- [ ] `docker run abc123`
- [ ] `docker restart abc123`
- [x] `docker start abc123`
- [ ] `docker exec abc123`

## Question 4

A container was created with `docker create ubuntu echo "test"`. After starting it once, can you change it to run `echo "production"` instead?

- [ ] Yes, by using `docker start CONTAINER_ID echo "production"`
- [ ] Yes, by using `docker update CONTAINER_ID --command "echo production"`
- [x] No, you must create a new container with the new command
  - The command (`echo "test"`) becomes part of the container's immutable configuration
- [ ] Yes, by editing the container's configuration file
