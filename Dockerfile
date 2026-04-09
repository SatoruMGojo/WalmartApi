FROM ubuntu:latest
LABEL authors="lawma"

ENTRYPOINT ["top", "-b"]

FROM maven:3.9-eclipse-temurin-21-alpine

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package -DskipTests

ENTRYPOINT ["java","-jar","target/WalmartApi-0.0.1-SNAPSHOT.jar"]