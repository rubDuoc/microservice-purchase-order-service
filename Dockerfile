FROM openjdk:21-ea-24-oracle

WORKDIR /app

COPY target/purchase-order-service-0.0.1-SNAPSHOT.jar app.jar

COPY Wallet_T9VR8XFM2N3T5A6X /app/oracle_wallet/

RUN printf 'javax.net.ssl.trustStore=/app/oracle_wallet/truststore.jks\njavax.net.ssl.trustStorePassword=Bullanguero05@\njavax.net.ssl.keyStore=/app/oracle_wallet/keystore.jks\njavax.net.ssl.keyStorePassword=Bullanguero05@\n' > /app/oracle_wallet/ojdbc.properties

EXPOSE 8082

CMD ["java", "-jar", "app.jar"]
