# Stage 1: Build the application using Gradle
FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

# Build the application
RUN ./gradlew bootJar --no-daemon

# Stage 2: Run the application using OpenJDK
FROM openjdk:17-jdk-slim
EXPOSE 8080

# Adjust this path if needed, depending on where the JAR file is located
COPY --from=build /app/build/libs/roinventory-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
