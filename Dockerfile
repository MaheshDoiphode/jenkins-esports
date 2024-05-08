FROM eclipse-temurin:17.0.10_7-jre-alpine
WORKDIR /app
COPY releases/latest.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]