# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jdk

WORKDIR /app

# Copy war file
COPY product-service-0.0.1-SNAPSHOT.jar /product-service.war

# run the app
CMD ["java", "-jar", "/product-service.war"]