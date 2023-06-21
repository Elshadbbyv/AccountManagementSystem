## For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre AS build
#
##
#COPY build.gradle gradlew ./
#COPY .gradle .gradle
#RUN ./gradlew dependency:resolve
#
#COPY src src
#RUN ./gradlew package
#
##
#FROM openjdk:11
#
#WORKDIR /AccountManagementSystem
#
##
#COPY ${JAR_FILE} AccountManagementSystem.jar
#ENTRYPOINT["java", "-jar", "AccountManagementSystem.jar"]
#
##