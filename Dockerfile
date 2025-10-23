# Step 1: Use official JDK image
FROM openjdk:17-jdk-slim

# Step 2: Add app jar
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Step 3: Expose service port
EXPOSE 8082

# Step 4: Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
