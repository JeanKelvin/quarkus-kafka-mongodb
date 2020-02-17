Quarkus Kafka Quickstart
========================

This project illustrates how you can interact with Apache Kafka using MicroProfile Reactive Messaging.

## Kafka cluster

First you need a Kafka cluster. You can follow the instructions from the [Apache Kafka web site](https://kafka.apache.org/quickstart) or run `docker-compose up` if you have docker installed on your machine.

## Start the application

The application can be started using: 

```bash
mvn quarkus:dev
```  

Then, open your browser to `http://localhost:8080`.

## Running in native

You can compile the application into a native binary using:

`mvn clean package -Pnative`

and run with:

`./target/kafka-quickstart-1.0-SNAPSHOT-runner` 
