# JWT + MySQL Authentication

```
A simple project to implement JWT + MySQL authentication and role based authorization using non depreciated methods.
```

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