FROM openjdk:14-jdk-alpine
MAINTAINER Dmitry Herrasimovich
COPY target/pasteBox-1.0-SNAPSHOT.jar pasteboxDocker.jar
ENTRYPOINT ["java","-jar","pasteboxDocker.jar"]