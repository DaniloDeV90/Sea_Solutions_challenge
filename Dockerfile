FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y


RUN apt-get install gradle -y

RUN ./gradlew build

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]