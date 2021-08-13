FROM adoptopenjdk/openjdk11:ubi
RUN mkdir /opt/app
COPY target/acceptance-0.0.2.jar /opt/app
COPY src/main/resources/application.properties /opt/app
CMD ["java", "-jar", "/opt/app/acceptance-0.0.2.jar"]