# Getting started with UserCrud-Backend

## Instructions

- Clone [UserCrud-FE](https://github.com/robrow/user-crud-fe)
- First time run `npm i` in the frontend project
- Start this backend
- Run frontend via `npm start`

## Prerequisites

- Java 17

## Hints

### Database
The database is memory only. When the application is shut down all data will be gone. You can modify the liquibase [migration](./src/main/resources/db/changelog/db.changelog-master.xml) file to add custom data on startup. 

### REST Endpoints
Base path for user API is `http://localhost:8080/api/users`

Have a look at http request [documentation](./src/test/requests/user-requests.http).