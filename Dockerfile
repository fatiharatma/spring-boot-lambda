FROM openjdk:8-jdk-alpine

ADD target/spring-boot*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar" ]
