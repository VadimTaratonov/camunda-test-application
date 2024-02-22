FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8090
ARG JAR_FILE=/target/camunda-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} camunda-service

CMD ["java","-jar","camunda-service"]