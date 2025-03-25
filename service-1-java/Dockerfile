FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/service-1-java-1.0-SNAPSHOT.jar app.jar

RUN addgroup -S spring && adduser -S spring -G spring
USER spring

ENTRYPOINT ["java", "-jar", "app.jar"]