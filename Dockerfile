FROM maven:3.8.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM maven:3.8.4-openjdk-17-slim
COPY --from=build /target/schoolManagement-0.0.1-SNAPSHOT.jar schoolManagement.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "schoolManagement.jar"]