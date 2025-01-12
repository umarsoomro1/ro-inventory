# Stage 1: Build the application using Gradle
FROM gradle:7.5.1-jdk17 AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

COPY . .

RUN ./gradlew bootJar --no-daemon

# Verify JAR file location (for debugging purposes)
RUN ls -alh /build/libs

# Stage 2: Run the application using OpenJDK
FROM openjdk:17-jdk-slim
EXPOSE 8080

# Adjust this path if needed, depending on where the JAR file is located
COPY --from=build /build/libs/roinventory-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
