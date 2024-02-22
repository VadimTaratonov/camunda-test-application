FROM openjdk:19
LABEL authors="Vadim Taratonov"
EXPOSE 8095
ARG JAR_FILE=/target/operate-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} operate-service

CMD ["java","-jar","operate-service"]