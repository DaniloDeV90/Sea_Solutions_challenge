# Etapa 1: Build da aplicação
FROM gradle:7.2-jdk11-alpine AS build
WORKDIR /app
COPY build.gradle settings.gradle /app/
COPY src /app/src/
RUN gradle clean bootJar


FROM openjdk:11-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build /app/build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
