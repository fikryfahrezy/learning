# Required Updates for Cert Manager Install

In the upcoming lecture, we will be installing the Cert Manager using Helm on Google Cloud. There have been some breaking changes introduced with the latest versions of Cert Manager, so we will need to do a few things differently.

Instead of the installation instructions given at around 1:20 in the video, we will complete these steps in the GCP Cloud Shell:

1. Add the Jetstack Helm repository

   ```sh
   helm repo add jetstack https://charts.jetstack.io
   ```

2. Update your local Helm chart repository cache:

   ```sh
   helm repo update
   ```

3. Install the cert-manager Helm chart:

   ```sh
   helm install \
     cert-manager jetstack/cert-manager \
     --namespace cert-manager \
     --create-namespace \
     --version v1.8.0 \
     --set installCRDs=true
   ```

Official docs for reference:

https://cert-manager.io/docs/installation/helm/#steps
