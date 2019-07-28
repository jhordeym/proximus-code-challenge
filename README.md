# Proximus code challange

## Introduction:

Design and implement a simple TV ordering application using Spring.  Basically, the customer should be able to view his active and available channels.

Rest Controller with the needed information. (Customer Info, Active channels, Available channels)
- Service to retrieve the customer information based on the customer id.
- Service to retrieve the active channels (channels already subscribed).
- Service to retrieve all the available channels (channels not yet subscribed).
- Junit Tests

## Architecture choice:

#### Front-end:
- Angular 7
- Angular material
- Reactive forms

#### Back-end:
- Java 8
- Spring Boot 2
- Spring Data MongoDB Reactive
- REST API with Reactive endpoints (Mono, Flux)
- Project Lombok
- Swagger UI

#### Database:
- Mongodb

#### Deployment:
- Docker
