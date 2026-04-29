FROM eclipse-temurin:21-jdk

COPY backend/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
