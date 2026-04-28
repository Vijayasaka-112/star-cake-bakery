FROM openjdk:21
COPY backend/target/bakery-1.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
