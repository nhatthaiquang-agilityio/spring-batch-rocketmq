FROM java:8-jre

ADD ./target/rocketmq-console-ng-1.0.0.jar /app/

ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/rocketmq-console-ng-1.0.0.jar"]
EXPOSE 8080