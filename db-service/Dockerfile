FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8093
ARG JAR_FILE=/target/db-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} db-service

CMD ["java","-jar","db-service"]