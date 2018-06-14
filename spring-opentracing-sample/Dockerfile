FROM openjdk:8-jre-alpine
ADD target/ /opt/
WORKDIR /opt
EXPOSE 10002
ENTRYPOINT exec java $JAVA_OPTS -jar spring-opentracing-sample.jar
