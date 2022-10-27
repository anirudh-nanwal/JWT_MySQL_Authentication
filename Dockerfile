FROM openjdk:11-slim as build
COPY target/jwt-0.0.1-SNAPSHOT.jar jwt-0.0.1-SNAPSHOT
ENTRYPOINT ["java","-jar","/jwt-0.0.1-SNAPSHOT"]