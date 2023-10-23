FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y

FROM gradle:7.2-jdk11
RUN apt-get install gradle -y

CMD ["./gradlew", "clean", "bootJar"]
RUN ./gradlew build bootjar

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY --from=build build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-jar", "app.jar"]