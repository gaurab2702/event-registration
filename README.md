## This assignment is over https://github.com/boris-ns/spring-security-boilerplate

# event-registration

SpringBoot application code with Spring Security implementation and JWT authentication and authorization.  
Postgresql is used as a database.

# How to use

First, you need to clone this repository

```git clone git@github.com:gaurab2702/event-registration.git```

Create Database with query ``` create database event_registration; ```

After that, you can run the service

```
cd event-registration
mvn spring-boot:run
```

## Sample Curl with Authorization

```
curl --location 'http://localhost:8080/event-registration/event/' \
--header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJhcHAubmFtZSIsInN1YiI6ImFkbWluIiwiYXVkIjoid2ViIiwiaWF0IjoxNzU2NDA3MzI2LCJleHAiOjE3OTI0MDczMjZ9.eVV8etuSykbxHBZeQWOOGyi6lAAOvn0VwG5gyE96iW5aHkB0TKuPLU0MYHwUU7sekEX2Z4gxjPcSUG3pO4TaZg' \
--header 'Content-Type: application/json' \
--data '{
  "name": "Tech Conference",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}'
```

# Endpoints

every URL endpoint with ```/public/``` in it won't be checked by JWT filter and Spring Security, so that means everyone
can use it.
Also, this applies to ```/auth/login```

# API documentation

## Login

```POST http://localhost:8080/event-registration/auth/login```  
Request:

```json
{
  "username": "gaurab",
  "password": "123"
}
```

Response:

```json
{
  "id": 1,
  "username": "gaurab",
  "firstName": "Gaurab",
  "lastName": "Kumar",
  "email": "gaurab@example.com",
  "enabled": true,
  "authorities": [
    "ROLE_USER"
  ],
  "token": {
    "accessToken": "JWT_TOKEN_VALUE",
    "expiresIn": 3600000
  }
}
```

## Refresh token

```POST http://localhost:8080/event-registration/auth/refresh```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint  
Response:

```json
{
  "accessToken": "JWT_TOKEN_VALUE",
  "expiresIn": 3600000
}
```

## Change password

```POST http://localhost:8080/event-registration/auth/change-password```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint  
Request:

```json
{
  "oldPassword": "12345",
  "newPassword": "asdfg"
}
```

Response: 200 OK or exception

## Public Hello World

```GET http://localhost:8080/api/public/hello-world```  
Everyone is authorized to use this endpoint  
Response: ```Hello World from PUBLIC controller!```

## Private Hello World for registered users

```GET http://localhost:8080/api/hello-world/registered-user```  
Only registered users can use this endpoint  
Response: ```Hello ANY REGISTERED USER from PRIVATE controller!```

## Private Hello World for regular users

```GET http://localhost:8080/api/hello-world/user```  
Only users with role ```ROLE_USER``` can use this endpoint  
Response: ```Hello USER from PRIVATE controller!```

## Private Hello World for admins

```GET http://localhost:8080/api/hello-world/admin```  
Only users with role ```ROLE_ADMIN``` can use this endpoint  
Response: ```Hello ADMIN from PRIVATE controller!```

# Predefined data in the database

In the database, there are two types of users: ```ROLE_ADMIN``` and ```ROLE_USER```.

Regular user is ```gaurab```.  
Admin is ```admin```.  
All passwords are ``123``.

## Create Event

```POST http://localhost:8080/event-registration/event/```  
Authentication: you must send JWT with request  
Only Admin User is authorized to use this endpoint
Request:

```json
{
  "name": "Tech Conference",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}
```

Response:

```json
{
  "id": 1,
  "name": "Tech Conference",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}
```

## Get Event

```GET http://localhost:8080/event-registration/event/1```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint

Response:

```json
{
  "id": 1,
  "name": "Tech Conference",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}
```

## Update Event

```PUT http://localhost:8080/event-registration/event/```  
Authentication: you must send JWT with request  
Only Admin User is authorized to use this endpoint
Request:

```json
{
  "id": 1,
  "name": "Tech Conference updated",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}
```

Response:

```json
{
  "id": 1,
  "name": "Tech Conference updated",
  "location": "New York City",
  "date": "2025-09-15T10:30:00"
}
```

## Delete Event

```DELETE http://localhost:8080/event-registration/event/1```  
Authentication: you must send JWT with request  
Only Admin User is authorized to use this endpoint
Response: Success

## Register User for Specific Event

```POST http://localhost:8080/event-registration/registration/```  
Authentication: you must send JWT with request  
Only Admin User is authorized to use this endpoint
Request:

```json
{
  "userId": 2,
  "eventId": 2
}
```

Response:

```json
{
  "id": 3,
  "userId": 2,
  "eventId": 2
}
```

## Get Registration

```GET http://localhost:8080/event-registration/registration/3```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint

Response:

```json
{
  "id": 3,
  "userId": 2,
  "eventId": 2
}
```

## Get Registration By User Id

```GET http://localhost:8080/event-registration/registration/user/1```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint

Response:

```json
[
  {
    "id": 2,
    "userId": 1,
    "eventId": 2
  },
  {
    "id": 3,
    "userId": 1,
    "eventId": 3
  }
]
```

## Get Registration Details By Event Id

```GET http://localhost:8080/event-registration/registration/event/1```  
Authentication: you must send JWT with request  
All users are authorized to use this endpoint

Response:

```json
[
  {
    "id": 2,
    "userId": 1,
    "eventId": 2
  },
  {
    "id": 3,
    "userId": 2,
    "eventId": 2
  }
]
```

## Delete Event

```DELETE http://localhost:8080/event-registration/registration/1```  
Authentication: you must send JWT with request  
Only Admin User is authorized to use this endpoint
Response: Success

