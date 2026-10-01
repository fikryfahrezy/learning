# Installing Docker on macOS

This note will provide detailed steps and instructions to install Docker and signup for a DockerHub account on macOS. We will need a DockerHub account so that we can pull images and push the images we will build.

1. Register for a DockerHub account

Visit the link below to register for a DockerHub account (this is free)

https://hub.docker.com/signup

2. Navigate to the Docker Desktop installation page

https://www.docker.com/products/docker-desktop/

3. Select your Chip

Click the button that corresponds with the chip of your computer. If you have an M1 or M2 machine, you will need to click the Mac with Apple Chip button. Everyone else will need to click the Mac with Intel Chip button.

4. Double-click the Docker.dmg file in your Downloads

5. Drag and drop the Docker icon to the Applications folder

6, Go to Applications and double-click click the Docker icon:

7. Select "Open" in the "Are you Sure you want to open it" prompt

8. Click "Accept" to the Service Agreement

9. Click "OK" to "Docker Desktop needs privileged access" prompt

10. Enter your computer's username and password to install the helper

11. Docker Desktop will launch for the first time

If the installation was successful, Docker Desktop will launch and present you with a tutorial. You are free to skip this.

12. Check that Docker is working

Open your Terminal application and run the `docker` command. If all is well you should see some helpful instructions in the output similar to below. 

13. Log in to Docker

Using your Terminal Application run the `docker login` command. You will be prompted to enter the Username and password (or your Personal Access Token) you created in step #1 when registering for a DockerHub account.

Once you see **Login Succeeded**, the setup is complete and you are free to continue to the next lecture.

## Resources for this lecture

- [DockerHub Registration](https://hub.docker.com/signup)
- [Docker Desktop Install Link](https://www.docker.com/products/docker-desktop/)
