# Week 7 - Naming and Service Discovery Assignment

## Overview
This project demonstrates service discovery in a microservices architecture using Spring Boot and Netflix Eureka.

The system contains:
- Eureka Server as the service registry
- hello-service running as 2 instances
- client-service that discovers HELLO-SERVICE dynamically and calls a random instance

## Requirements Completed
- Ran 2 service instances
- Registered both instances with the Eureka registry
- Client discovered service instances dynamically
- Client called a random instance

## Project Structure
```text
week7-service-discovery/
├── eureka-server/
├── hello-service/
├── client-service/
└── README.md
````

## Technologies Used

* Java 21
* Spring Boot 3.5.11
* Spring Cloud Netflix Eureka
* Maven
* VS Code

## Architecture

* Eureka Server runs on port 8761
* hello-service instance 1 runs on port 8081
* hello-service instance 2 runs on port 8082
* client-service runs on port 8080

## Service Flow

1. hello-service instances register with Eureka
2. client-service queries Eureka for HELLO-SERVICE
3. client-service selects one instance randomly
4. client-service calls that instance’s `/hello` endpoint

## Endpoints

* Eureka Dashboard: `http://localhost:8761`
* Hello Service Instance 1: `http://localhost:8081/hello`
* Hello Service Instance 2: `http://localhost:8082/hello`
* Client Service Call: `http://localhost:8080/call`

## How to Run

### Start Eureka Server

```bash
cd eureka-server
./mvnw clean spring-boot:run
```

### Start Hello Service Instance 1

```bash
cd hello-service
./mvnw clean spring-boot:run -Dspring-boot.run.arguments=--server.port=8081
```

### Start Hello Service Instance 2

```bash
cd hello-service
./mvnw clean spring-boot:run -Dspring-boot.run.arguments=--server.port=8082
```

### Start Client Service

```bash
cd client-service
./mvnw clean spring-boot:run
```

## Expected Output

Visiting `http://localhost:8080/call` returns alternating responses such as:

```text
Client called -> Hello from instance running on port 8081
```

and

```text
Client called -> Hello from instance running on port 8082
```

## Proof of Service Registration

The Eureka dashboard shows:

* HELLO-SERVICE with 2 registered instances
* CLIENT-SERVICE with 1 registered instance

## Deliverables

* GitHub repository
* Architecture diagram
* Demo video

## Optional Extension

A future enhancement would be to integrate a service mesh such as Istio or Linkerd for:

* traffic routing
* observability
* security

