# Use a base image with Java 11 pre-installed
FROM openjdk:11-jdk-slim AS build

# Instale o Gradle
RUN apt-get update && apt-get install -y unzip
RUN wget https://services.gradle.org/distributions/gradle-7.2-bin.zip
RUN unzip -d /opt/ gradle-7.2-bin.zip
RUN rm gradle-7.2-bin.zip

# Defina as variáveis de ambiente do Gradle
ENV GRADLE_HOME /opt/gradle-7.2
ENV PATH $GRADLE_HOME/bin:$PATH

# Defina o diretório de trabalho
WORKDIR /Sea_Solutions_Challenge

# Copie os arquivos de configuração do Gradle (se necessário)
# COPY build.gradle .
# COPY settings.gradle .
# ...

# Copie o Gradle Wrapper (gradlew) e os arquivos de projeto
COPY gradlew .
COPY gradle gradle
# COPY src src
# ...

# Execute a construção com o Gradle Wrapper
RUN ./gradlew clean bootJar

# Crie uma imagem final com apenas a aplicação JRE
FROM openjdk:11-jre-slim

# Exponha a porta do aplicativo
EXPOSE 8080

# Copie o JAR construído do estágio de construção anterior para a imagem final
COPY --from=build /Sea_Solutions_Challenge/build/libs/Sea_Solutions_Challenge-0.0.1-SNAPSHOT.jar app.jar

# Execute a aplicação Spring Boot
CMD ["java", "-jar", "app.jar"]
