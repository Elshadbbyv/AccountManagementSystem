FROM amazoncorretto:17 AS build
WORKDIR /AccountManagementSystem

ARG JAR_FILE=build/libs/AccountManagementSystem-0.0.1.jar

ADD $JAR_FILE AccountManagementSystem.jar

# Entry point for running the application
ENTRYPOINT ["java", "-jar", "AccountManagementSystem.jar"]
EXPOSE 8080




# Copy the Gradle files to the container




# Expose the port your application uses
