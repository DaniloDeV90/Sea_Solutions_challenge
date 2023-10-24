FROM ubuntu:latest AS build
FROM gradle:7.2-jdk11-alpinegr
RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . .

RUN apt-get install gradle -y


RUN ./gradlew build bootjar

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY --from=build build/libs/*.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]