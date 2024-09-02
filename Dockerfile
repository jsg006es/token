FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/token-0.0.2.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]