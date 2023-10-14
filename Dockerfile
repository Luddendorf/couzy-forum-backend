FROM maven:3.8.1-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ src/
RUN mvn package

# Second stage: copy the built app from the first stage
FROM openjdk:11-slim
WORKDIR /app
ENV JAVA_OPTIONS="-Xmx1024m -Xms512m" SPRING_PROFILES_ACTIVE="dev"

COPY --from=build /app/target/Maven-0.0.1-SNAPSHOT.jar .
# Copy the SSL certificate files into the image
COPY /path/to/certificate.crt /etc/nginx/certs/certificate.crt
COPY /path/to/certificate.key /etc/nginx/certs/certificate.key
# USER root
COPY ldap.cer $JAVA_HOME/jre/lib/security
RUN \
    cd $JAVA_HOME/jre/lib/security \
    && keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias ldapcert -file ldap.cer
EXPOSE 80
ENTRYPOINT []
CMD ["java", "-jar", "Maven-0.0.1-SNAPSHOT.jar"]