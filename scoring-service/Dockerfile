FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8091
ARG JAR_FILE=/target/scoring-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} scoring-service

CMD ["java","-jar","scoring-service"]