# Challenge API

This API fetch posts about Java from HackNews, persists its on a Postgres database and exposes endpoints for retrieving the data, filtered by different fields.

## Dummy users
In order to use the API, the app generates some dummy users on startup.

For using the endpoints correctly, the GET operations are available for the ROLE_ADMIN and ROLE_JOURNALIST roles, but for security concerns the DELETE operation is only granted to the ROLE_ADMIN.

| User      | Password | Role |
|-----------|----------|----------|
| ckent     | superman | ROLE_JOURNALIST    |
| bwayne | batman   | ROLE_ADMIN    |

### Login
The API is secured using JWT library. In order to be authenticated and be able to get the data from the endpoints, is necessary first to use the **login** endpoint, with the given credentials, and retrieve the access-token that must be used in the **Authorization** header as **Bearer** token.

## Run the api
On the root of the project, run the following commands:
`

$ ./mvnw clean package -DskipTests

$ cp target/challenge-0.0.8.jar src/main/docker

$ cd src/main/docker

$ docker-compose up

`


## Use the api
To use and fetch the data from the API, please refer to the Postman Collection (challenge.postman_collection.json) within the project. 