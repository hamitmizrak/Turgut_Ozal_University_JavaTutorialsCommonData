#FROM adoptopenjdk/openjdk16
FROM openjdk:17-oracle
ARG JAR_FILE=JavaTutorialsCommonData-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} blog.jar
ENTRYPOINT ["java","-jar","/blog.jar"]