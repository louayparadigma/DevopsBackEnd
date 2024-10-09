
# Step 1: Use an official OpenJDK image as the base image for the final build
FROM openjdk:17-jdk-alpine

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the jar file from the build stage to the container
COPY --from=build /app/target/*.jar 4Arctic1g4.jar

# Step 4: Expose the port that the Spring Boot application runs on (default is 8080)
EXPOSE 8080

# Step 5: Define the command to run the app
ENTRYPOINT ["java", "-jar", "4Arctic1g4.jar"]
