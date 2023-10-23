FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-11-jdk -y

COPY ./gradle/wrapper/gradle-wrapper.jar /app/gradle/wrapper/
COPY  ./gradle/wrapper/gradle-wrapper.properties /app/gradle/wrapper/

RUN apt-get install gradle -y
WORKDIR /app
USER root
COPY --from=0 /app/Sea_Solutions_Challenge /app
RUN chown -R gradle /app
USER gradle
RUN ./gradlew build

FROM openjdk:11-jdk-slim

EXPOSE 8080

COPY --from=build /build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT-plain.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]