# JWT + MySQL Authentication

A simple project to implement JWT + MySQL authentication and role based authorization using supported methods.

## Project Structure

```
    |-- /src/main/java
        `-- com.user.auth.jwt
            |   `-- JwtApplication.java
            |
            |-- configuration
            |   |-- CorsConfiguration.java
            |   |-- JwtAuthenticationEntryPoint.java
            |   |-- JwtRequestFilter.java
            |   `-- WebSecurityConfigurer.java
            |
            |-- controller
            |   |-- JwtController.java
            |   |-- RoleController.java
            |   `-- UserController.java
            |
            |-- dao
            |   |-- RoleDao.java
            |   `-- UserDao.java
            |
            |-- entity
            |   |-- JwtRequest.java
            |   |-- JwtResponse.java
            |   |-- Role.java
            |   `-- User.java
            |
            |-- service
            |   |-- JwtService.java
            |   |-- RoleService.java
            |   `-- UserService.java
            |
            `-- util
                `-- JwtService.java

    |-- /src/main/resouces    
        |-- static
        |   |-- JWT Auth.postman_collection
        |   `-- jwtdb.sql
        |-- templates
        |-- application.properties

```

## Dependencies

```
- spring-boot-starter-web
- spring-boot-starter-data-jpa
- spring-boot-starter-security
- mysql-connector-j
- jjwt
```

## API

- The postman collection and the sql for the application can be found in the src/main/resources folder.
- ``` /jwt/authenticate ``` api will authenticate the user against the username and password. Currently, only 1 user and 1 admin exists and the ability to add more users has been left out as a test activity for the developers. The existing admin credentials are ``` {"username": "nano", "password": "asdf"} ``` and user credentials are ``` {"username": "nano1", "password": "asdf1"} ```.
- ``` /jwt/addRole ``` api will add a new role in the role table. The JSON object for this is:
``` 

{
    "roleName": "user",
    "roleDescription": "Default role for new user"
} 

```
- ``` /jwt/addUser ``` api will add a new user in the user table. The JSON object for this is:
```

{
    "userName": "nanoas",
    "userFirstName": "Anirudh",
    "userLastName": "Nanwalad",
    "userPassword": "Nano123ads",
    "roles": 
        {
            "roleName": "User",
            "roleDescription": "Default role for newly created User"
        }
}

```
- ``` /jwt/forAdmin ``` api will return the response ``` Getmapping for admin ``` only when we sent the JWT token generated for the Admin only.
- ``` /jwt/forUser ``` api will return the response ``` Getmapping for user ``` only when we sent the JWT token generated for the user only.
- The postman collection is well documented but if something still does not work out, then try to fix it first as it may have been left out by me as an activity. But if you still don't find any solution to that issue, only then contact me.
- Also, as we all know that extending the WebConfigurerAdapter has been deprecated in the Spring security framework, I have implemented it without extending the class, just the way it was supposed to be done.


## Docker Container

Follow the below steps in order to create spring boot and mysql instance in the docker, assuming docker is installed in your system:

- Inside pom.xml, we have a plugin tag. Now, inside this tag, add the below configuration tag right after the aftifactId tag:
```

...
<artifactId>spring-boot-maven-plugin</artifactId>
<configuration>
    <image>
        <name><!-- Your docker repo name -->/${project.artifactId}:${project.version}</name>
    </image>
	<pullPolicy>IF_NOT_PRESENT</pullPolicy>
</configuration>
...

```
- In the application.properties, we will have to change the datasource URL to `jdbc:mysql://mysql-db/jwt_auth` before we create the target folder.
- Next, create a Maven install goals as ``` spring-boot:build-image -DskipTests ```, or do a Maven clean install in order to create the target folder.
- Next, create the Dockerfile having the below content:
```

FROM openjdk:11-slim as build
COPY target/jwt-0.0.1-SNAPSHOT.jar jwt-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/jwt-0.0.1-SNAPSHOT"]

```
- Open terminal, and create the application's docker image using the command ``` docker image build . -t <Your docker repo name>/jwt ```.
- Next, we will have to download the MySQL image using the command ``` docker pull mysql  ```.
- Next, we will create a network inside which, MySQL instance and jwt application instance will reside. For this use the command ```  docker network create jwt-network ```.
- Next, start the MySQL instance using the command ```  docker container run --name mysql-db --network jwt-network -e MYSQL_USER=<user name> -e MYSQL_PASSWORD=<password> -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=jwt_auth -d mysql:latest ```.
- Once this container has started, we will start the jwt application container using the command ``` docker container run --network jwt-network --name jwt-app -p 9090:9090 -d anirudhnanwal/jwt ```. Since our application.properties has specified the server port to be 9090, we will have to expose that port of the docker only.
- After this container starts, you will see many errors being thrown by the spring but do not worry about those as those are SQL errors for table creation logic that I have implemented in the UserController.java whenever the server starts.
- In the postman, you can test out the application by using the original URLs.