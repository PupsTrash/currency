FROM openjdk:11-jre
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} currency.jar

EXPOSE 8081
ENTRYPOINT exec java ${JAVA_OPTS} -jar /currency.jar