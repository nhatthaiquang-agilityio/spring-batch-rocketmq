FROM java:8-jre

ADD ./target/pub-service-0.0.1.jar /app/

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/pub-service-0.0.1.jar"]
EXPOSE 9909