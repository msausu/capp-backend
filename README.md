# NTD Calculator Backend

## Users

[x] provide with at least two user/passwords

- `john@gmail.com` password `john0000`
- `mary@gmail.com` passord `mary0000`

## Tech Stack, choose from: Java, Clojure, MySQL, Node.js, Go, Python, Vue.js/React.js, AWS.

[x] AWS 
[x] Java (Spring Boot)
[x] React (Vite)
[x] MySQL

## Repos

[x] Frontend and Backend should be on separate stacks.
[x] Frontend and Backend should be on separate repos.

## Technical requirements

### Backend requirements

[x] all client-server interaction should be through RESTful API (versionated).
[x] collection endpoints should be able to provide filters and pagination.
[x] operations should be able to handle negative numbers. For example (-1) - (-5) = 4, YES but no parenthesis 
[x] use third-party operation for random string https://www.random.org/clients, YES 8 digits
[x] decide the cost of each operation, YES defined at startup
[x] users will have a starting credit/balance, YES defined at startup currently set to 100
[x] all the database operations should be transactional, to maintain integrity when multiple operations try to modify the balance at the same time.
[x] the system does not allow more operations if there is not enough balance. YES per USER (multiple logins are allowed), the balance is not shared
[x] each request will be deducted from the user’s balance. If the user’s balance isn’t enough to cover the request cost, the request shall be denied.
[x] records should be soft-deleted only (the arithmetic operations should be able to be deleted with a logic delete in the database)
[x] all the logic should be isolated in the service layer, never write logic in the controllers.
[x] include a log system.
[x] add automated tests such as Unit Tests back-end
[ ] the passwords should be encrypted. WILL DO

## Containers or Serverless

[x] may adopt a containerized approach, provided the back-end logic is properly separated into service layers
[x] include the Docker Compose files.

- the `database` directory contains the container build files for mysql
- the `backend` directory contains the container build files for the backend. There are 3 files depending on the desired build
    - Dockerfile for production
    - Dockerfile-dev for development
    - Dockerfile-local and Dockerfile-native for experimentation
- run `bash build.sh dev` for development and `bash build.sh` for production
- run `bash run.sh dev` for development and `bash run.sh` for production
- since the environment for the free tier is limited the containers and docker-compose files have been constrained accordingly

## Improvements (that would need more time)

[ ] change http to https
[ ] change basic authentication to token-based (this should be done properly using and SSO/IAM infrastructure, it should not be handled by the microservice)
[ ] setup users & operations via configuration, move hardcoded configuration to application.properties

