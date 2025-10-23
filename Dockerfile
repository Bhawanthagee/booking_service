# Step 1: Base image
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy JAR file into container
COPY target/booking_service-0.0.1-SNAPSHOT.jar booking_service.jar

# Step 4: Expose app port
EXPOSE 8082

# Step 5: Run the app
ENTRYPOINT ["java", "-jar", "booking_service.jar"]
