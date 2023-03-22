FROM openjdk:17-jdk-alpine
MAINTAINER clausaji
COPY target/netflix-database-api-0.0.1-SNAPSHOT.jar netflix-database-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/netflix-database-api-0.0.1-SNAPSHOT.jar"]