FROM eclipse-temurin:21-jre

ENV LANGUAGE='en_US:en'

# Copy application files into distinct layers for better caching
COPY --chown=185 weather-producer/build/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 weather-producer/build/quarkus-app/*.jar /deployments/
COPY --chown=185 weather-producer/build/quarkus-app/app/ /deployments/app/
COPY --chown=185 weather-producer/build/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080

# Set user and environment variables for running the application
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT ["java","-jar","/deployments/quarkus-run.jar"]