FROM openjdk:8-jdk-alpine
MAINTAINER leonardodavila
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} bfftipocambiomoneda-1.0.jar
ENTRYPOINT ["java","-jar","/bfftipocambiomoneda-1.0.jar"]