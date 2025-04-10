FROM openjdk:17-jdk-slim

WORKDIR /app

RUN apt-get update && apt-get install -y curl

COPY mvnw* .
COPY .mvn .mvn
RUN chmod +x mvnw

COPY ./pom.xml ./
COPY ./src ./src

RUN ./mvnw dependency:go-offline
RUN ./mvnw package -DskipTests

COPY target/producers-data-1.0.0.jar producers-data-1.0.0.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "producers-data-1.0.0.jar"]