# Setting the version of java !
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copying the jar file and renaming it to app.jar and placing it into the app dir
COPY target/trainer-application-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8081

# Run the application with the following commands to start the application
ENTRYPOINT ["java", "-jar", "app.jar","--spring.profiles.active=docker"]