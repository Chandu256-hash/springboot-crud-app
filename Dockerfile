# Stage 1: Build the app using Maven
FROM maven:3.9.3-eclipse-temurin-17 as builder

# Set working directory
WORKDIR /app

# Copy the entire repo into the container
COPY . .

# Build the app (you can skip tests if you want)
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Create a directory for H2 database persistence
VOLUME /data

# Expose ports
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
