FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8888
ARG JAR_FILE=/target/main-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} main-service

CMD ["java","-jar","main-service"]