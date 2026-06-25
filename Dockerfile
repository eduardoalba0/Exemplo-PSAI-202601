FROM maven:3.9-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy
COPY --from=build /target/*.war app.war
EXPOSE 8080
ENTRYPOINT ["java", "-war", "app.war"]
