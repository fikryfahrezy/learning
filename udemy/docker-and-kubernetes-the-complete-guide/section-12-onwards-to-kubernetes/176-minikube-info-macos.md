# Minikube Info - macOS

macOS students should be using Docker Desktop and not Minikube. The default Minikube Docker driver will require additional configuration for basic things to function, such as accessing Node Ports and an Ingress. You should stop and head back to the [instructions to enable Docker Desktop's Kubernetes](175-docker-desktops-kubernetes-setup-and-installation-macos.md) instead.

If, for some reason, you must use Minikube and not Docker Desktop, you can find the installation instructions here:

https://minikube.sigs.k8s.io/docs/start/

## Accessing Node Port Services (Sections 12 & 13)

In order to access NodePort services in sections 12 and 13, you will need to create a tunnel each time.

First, you will need to get the name of the running Node Port Service:

`kubectl get svc`

Then, you will create a tunnel:

`minikube service client-node-port --url`

This will display a URL for you to access in your browser, like this (your port number will be different):

*http://127.0.0.1:60835*

You must leave this tunnel running in your terminal in order to access the service in your browser.

## Accessing Ingress (Section 15)

Similarly, in order to access the Ingress used in section 15, you will need to create a tunnel.

After running your cluster with the following command:

`kubectl apply -f k8s/`

Use this command to create the tunnel:

`minikube tunnel`

Then, you will be able to access the Ingress in your browser at 127.0.0.1. You must leave this tunnel running in your terminal in order to access the service in your browser.

All of the above instructions, explanations, and limitations of the Minikube Docker Driver on macOS and Windows can be found here:

https://minikube.sigs.k8s.io/docs/handbook/accessing/
