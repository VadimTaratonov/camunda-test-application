FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8092
ARG JAR_FILE=/target/issue-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} issue-service

CMD ["java","-jar","issue-service"]