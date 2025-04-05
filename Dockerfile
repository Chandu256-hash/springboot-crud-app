# Stage 1: Build the app using Maven
FROM maven:3.9.3-eclipse-temurin-17 as builder

WORKDIR /app

# Copy everything to the container
COPY . .

# Build the JAR without running tests
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the generated JAR
COPY --from=builder /app/target/*.jar app.jar

# ❌ Removed this line because it's banned in Railway
# VOLUME /data

# Expose the port your app runs on
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
