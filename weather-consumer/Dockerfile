FROM eclipse-temurin:21-jre

ENV LANGUAGE='en_US:en'

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=185 weather-consumer/build/quarkus-app/lib/ /deployments/lib/
COPY --chown=185 weather-consumer/build/quarkus-app/*.jar /deployments/
COPY --chown=185 weather-consumer/build/quarkus-app/app/ /deployments/app/
COPY --chown=185 weather-consumer/build/quarkus-app/quarkus/ /deployments/quarkus/

EXPOSE 8080
USER 185
ENV JAVA_OPTS_APPEND="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

ENTRYPOINT ["java","-jar","/deployments/quarkus-run.jar"]