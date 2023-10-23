FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y

COPY ./gradle/wrapper/gradle-wrapper.jar /app/gradle/wrapper/
COPY  ./gradle/wrapper/gradle-wrapper.properties /app/gradle/wrapper/
FROM gradle:7.2.1-jdk11 AS build

WORKDIR /Sea_Solutions_Challenge
CMD ["./gradlew", "clean", "bootJar"]
RUN  gradle clean build

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]