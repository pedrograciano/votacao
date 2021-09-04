FROM openjdk:8
EXPOSE 9090
ADD target/votacao-app.jar votacao-app.jar
ENTRYPOINT ["java","-jar","/votacao-app.jar"]