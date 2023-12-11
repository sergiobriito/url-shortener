FROM openjdk:17
WORKDIR /app
COPY target/url-shortener-0.0.1-SNAPSHOT.jar /app/url-shortener-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "url-shortener-0.0.1-SNAPSHOT.jar"]