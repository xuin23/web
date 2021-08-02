FROM openjdk:16-jdk-alpine
COPY target/*SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
