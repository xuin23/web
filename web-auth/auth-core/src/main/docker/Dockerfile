FROM openjdk:16-jdk
COPY target/*SNAPSHOT.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
