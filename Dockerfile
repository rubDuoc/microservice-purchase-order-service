FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:21-ea-24-oracle
WORKDIR /app
COPY --from=build /app/target/purchase-order-service-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_T9VR8XFM2N3T5A6X /app/oracle_wallet/
ARG WALLET_PASSWORD
RUN printf 'javax.net.ssl.trustStore=/app/oracle_wallet/truststore.jks\njavax.net.ssl.trustStorePassword=%s\njavax.net.ssl.keyStore=/app/oracle_wallet/keystore.jks\njavax.net.ssl.keyStorePassword=%s\n' "${WALLET_PASSWORD}" "${WALLET_PASSWORD}" > /app/oracle_wallet/ojdbc.properties
EXPOSE 8082
CMD ["java", "-jar", "app.jar"]
