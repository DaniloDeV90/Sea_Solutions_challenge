FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y
COPY . .
FROM gradle:7.2-jdk11-alpine
RUN apt-get install gradle -y

CMD ["./gradlew", "clean", "bootJar"]
RUN ./gradlew build bootjar

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY build/libs/*.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]