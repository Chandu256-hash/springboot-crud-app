# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy JAR file
COPY target/my-app.jar app.jar

# Create a volume for persistent H2 storage
VOLUME /data

# Expose application and H2 console ports
EXPOSE 8080 9092

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
