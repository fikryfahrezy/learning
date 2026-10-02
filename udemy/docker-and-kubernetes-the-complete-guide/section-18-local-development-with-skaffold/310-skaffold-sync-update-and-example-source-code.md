# Skaffold Sync Update and Example Source Code

In the next lecture, Stephen will be finishing up the config YAML as well as showing a demo of how Skaffold would work in local development.

It is highly likely that you have just finished up the HTTPS configuration for your project which now includes an updated Ingress, Issuer, and Certificate manifests.

To avoid conflicts with these production resources, you will need to restructure your project files.

1. Create two additional folders along side the existing k8s directory called **k8s-dev** and **k8s-prod**

2. Move the **certificate.yaml**, **ingress-service.yaml**, and **issuer.yaml** files into **k8s-prod**.

3. Create a development-only **ingress-service.yaml** by copy-pasting the below code and placing into the **k8s-dev** directory:

   ```yaml
   apiVersion: networking.k8s.io/v1
   # UPDATE API
   kind: Ingress
   metadata:
     name: ingress-service
     annotations:
       # REMOVE CLASSNAME ANNOTATION
       nginx.ingress.kubernetes.io/use-regex: "true"
       # ADD ANNOTATION
       nginx.ingress.kubernetes.io/rewrite-target: /$1
       # ADD ANNOTATION
   spec:
     ingressClassName: nginx
     # ADD INGRESSCLASSNAME FIELD
     rules:
       - http:
           paths:
             - path: /?(.*)
               # UPDATE PATH
               pathType: ImplementationSpecific
               # ADD PATHTYPE
               backend:
                 service:
                   # UPDATE SERVICE FIELDS
                   name: client-cluster-ip-service
                   port:
                     number: 3000
             - path: /api/?(.*)
               # UPDATE PATH
               pathType: ImplementationSpecific
               # ADD PATHTYPE
               backend:
                 service:
                   # UPDATE SERVICE FIELDS
                   name: server-cluster-ip-service
                   port:
                     number: 5000
   ```

4. Update your skaffold.yaml to track both **k8s-dev/\*** and **k8s/\*** directories:

   ```yaml
   deploy:
     kubectl:
       manifests:
         - ./k8s/*
         - ./k8s-dev/*
   ```

5. Update the apiVersion:

   ```yaml
   apiVersion: skaffold/v2beta12
   ```

6. Update the globbing pattern syntax used for both the Client, Server, and Worker images.

   Client image:

   ```yaml
         sync:
           manual:
             - src: "src/**/*.js"
               dest: .
             - src: "src/**/*.css"
               dest: .
             - src: "src/**/*.html"
               dest: .
   ```

   Server and Worker images:

   ```yaml
         sync:
           manual:
             - src: "*.js"
               dest: .
   ```

   The full updated skaffold.yaml can be found here (it's also included in the zip folder attached to this lecture):

   ```yaml
   apiVersion: skaffold/v2beta12
   kind: Config
   deploy:
     kubectl:
       manifests:
         - ./k8s/*
         - ./k8s-dev/*
   build:
     local:
       push: false
     artifacts:
       - image: rallycoding/client-skaffold
         context: client
         docker:
           dockerfile: Dockerfile.dev
         sync:
           manual:
             - src: "src/**/*.js"
               dest: .
             - src: "src/**/*.css"
               dest: .
             - src: "src/**/*.html"
               dest: .
       - image: rallycoding/worker-skaffold
         context: worker
         docker:
           dockerfile: Dockerfile.dev
         sync:
           manual:
             - src: "*.js"
               dest: .
       - image: rallycoding/server-skaffold
         context: server
         docker:
           dockerfile: Dockerfile.dev
         sync:
           manual:
             - src: "*.js"
               dest: .
   ```

7. Replace my DockerHub username and image names with yours making sure the images in the k8s **server**, **worker**, and **client** deployment yaml manifests match what is shown in the Skaffold yaml. Also, make sure that you are using new development images and not production images.

8. Update your **client/Dockerfile.dev** to add the **CI=true** and **WDS_SOCKET_PORT=0** variables:

   ```dockerfile
   FROM node:16-alpine
   ENV CI=true
   ENV WDS_SOCKET_PORT=0

   WORKDIR "/app"
   COPY ./package.json ./
   RUN npm install
   COPY . .
   CMD ["npm", "run", "start"]
   ```

Finally, run `skaffold dev` in your terminal (this may take several minutes to build initially since all four servers will be involved).

You should now be able to access the cluster at localhost if using Docker Desktop, or at your minikube IP.

The Skaffold syntax reference can be found here:

https://skaffold.dev/docs/references/yaml/

## Resources for this lecture

- [308-complex-skaffold.zip](./308-complex-skaffold.zip)