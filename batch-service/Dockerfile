FROM java:8-jre

ADD ./target/batch-service-0.0.1.jar /app/

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/batch-service-0.0.1.jar"]
EXPOSE 9709