FROM maven:3.8-openjdk-8 AS build
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean package

FROM openjdk:8-jre
COPY --from=build /app/target/*.jar /app.jar
COPY src/main/resources /src/main/resources/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]