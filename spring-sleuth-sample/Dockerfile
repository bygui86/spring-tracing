FROM openjdk:8-jre-alpine
ADD target/ /opt/
WORKDIR /opt
EXPOSE 10003
ENTRYPOINT exec java $JAVA_OPTS -jar spring-sleuth-sample.jar
