# Sample Hibernate cache testing application

## Description

This application provides the ability to see how caching affects the performance with select and insert queries. In both cases elements are touched one-by-one in order.

## Launching

1. Clone repository to your machine
2. Open console in repository folder
3. Launch `mvn package`
4. launch `java -jar target/cache3-0.0.1-SNAPCHOT.jar`
5. Open [_localhost:8080_](localhost:8080) in your browser

## Configuration

You can change the port of the server by setting `server.port=<port>` in _src/main/resources/properties.json_
