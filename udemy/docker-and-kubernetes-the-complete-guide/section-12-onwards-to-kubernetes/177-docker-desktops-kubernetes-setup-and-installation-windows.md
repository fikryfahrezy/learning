# Docker Desktop's Kubernetes Setup and Installation - Windows

These instructions are for using Docker Desktop's built-in Kubernetes instead of Minikube on Windows. This is currently the best-supported and most recommended solution for running Kubernetes on Windows.

*Note - It is assumed that Docker Desktop has already been installed and is in a working state.*

1. Click the upward-facing arrow on the right side of the Windows System Tray, then click the Docker icon.
2. Click the Gear icon in the top menu bar of the Docker Desktop application.
3. In the General settings section, make sure that the Use WSL 2 based engine box is checked. This assumes that WSL2 is supported by your OS and has already been installed and enabled. If not, please see the WSL2 setup instructions here.
4. Click Kubernetes in the left side menu.
5. Check the Enable Kubernetes box and then click the Apply & Restart button.
6. Click Install to allow the cluster installation.
7. After the installation dialog disappears, look at the bottom left side of the General Settings page and make sure there is a green Kubernetes icon. If you click it, it should display a RUNNING tooltip.
8. Finally, open up your terminal of choice and make sure that you can run `kubectl version`.

*Note - the client and server can be off by one minor version without error or issue.*

## Usage

Going forward, any minikube commands run in the lecture videos can be ignored. Also, you will be using localhost to access the services running in your cluster instead of the minikube IP address.

For example, in the first project where we deploy our simple React app, using minikube we would visit:

`192.168.99.101:31515`

Instead, when using Docker Desktop's Kubernetes, we would visit:

`localhost:31515`
