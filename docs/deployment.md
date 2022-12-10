## Hosting Service
Currently we use Azure App Service to host our backend. We are subscribed to a free tier offering:
- 60 CPU Minutes/day
- 1 GB RAM
- ~350 MB of out data/day

### Note
These limits will be enough for our development process, but we must consider upgrading to a higher tier when we publish the application publicly.

![image](https://user-images.githubusercontent.com/20494891/206860123-0fb004fe-ca3c-4234-a453-4d00e2411cea.png)

## Hosting Environment
There are currently two different environments that our backend can be deployed to; the test environment and the production environment. Both environments share the resources listed above. Both environments have three environment variables defined, namely `BrainFoodEndpoint`, `BrainFoodUsername`, `BrainFoodPassword`. These variable are responsible for Database connectivity and without them defined the server WILL CRASH.

![image](https://user-images.githubusercontent.com/20494891/206859827-9c2ff744-7a9f-43f4-8946-a19e5f9ad219.png)

## Deployment Process
The backend is automatically deployed to the test environment whose url is brainfood-test.azurewebsites.net whenever a commit is pushed to any branch in this repository. It is also automatically deployed to the production environment brainfood.azurewebsites.net when a PR is merged into `main`.

Note that you can also trigger a deployment manually by running the `deploy-test.yml` or `deploy-production.yml` workflows in Github Actions.