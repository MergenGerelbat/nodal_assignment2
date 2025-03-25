FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/service-2-kotlin-1.0-SNAPSHOT.jar app.jar

RUN groupadd -r spring && useradd -r -g spring spring
USER spring

ENTRYPOINT ["java", "-jar", "app.jar"]