# Updated Service Account steps for new GCP UI

_updated 3-11-2021_

Part of the Google Cloud interface has seen some changes in the past few weeks, so, here is an updated walkthrough with screenshots to generate a Service Account.

1. Click the Hamburger menu on the top left-hand side of the dashboard, find **IAM & Admin**, and select **Service Accounts**. Then click the **CREATE SERVICE ACCOUNT** button.

2. In the form that is displayed, set the **Service account name** to **travis-deployer** (step 1), then click the **CREATE** button (step 2).

3. Click in the **Select a role** filter and scroll down to select **Kubernetes Engine** and then **Kubernetes Engine Admin**.

4. Make sure the filter now shows **Kubernetes Engine Admin** and then click **CONTINUE**

5. The Grant users access form is optional and should be skipped. Click the **DONE** button.

6. You should now see a table listing all of the service accounts including the one that was just created. Click the **three dots** to the right of the service account you just created. Then select **Manage Keys** in the dropdown.

7. In the **Keys** dashboard, click **ADD KEY** and then select **Create new key**.

8. In the **Create private key** dialog box, make sure **Key type** is set to **JSON**, and then click the **CREATE** button.

9. The JSON key file should now download to your computer.
