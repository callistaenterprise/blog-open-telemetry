Notes:
* Add quarkus opentelemetry extension




--------


# kafka-serialization-blog

A Quarkus project to illustrate how JSON Schema, Avro and Protobuf can be used for serialization and deserialization of
messages with Kafka.

This project uses [Quarkus](https://quarkus.io/), the Supersonic Subatomic Java Framework.

The project will use a scheduler to publish message to a Kafka topic using three types of schema; JSON Schema, Avro and
Protobuf.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

Note: the application uses TestContainers to start dependent services:
* A Kafka broker
* An Apicurio schema registry

## Building the application for prod mode

The application will be started in prod mode using `docker compose`. For this to work an image
is required containing the `Quarkus` application. This can be built (from the project root directory) using:

```shell script
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/kafka-serialization-jvm . 
```

See the Dockerfile in the `src/main/docker` directory for more info.

## Running the application in prod mode

To run the application in prod mode (after build) use:

```shell script
docker compose up -d
```

Note: The Docker Compose file will start the dependent services:
* Confluent Kafka
* An Apicurio schema registry