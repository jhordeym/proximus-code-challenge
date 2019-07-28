#!/bin/bash
### Build and package the Spring Boot Application
mvn clean package -Pdocker -U -Dmaven.test.skip=true
### Creates Docker image for Spring Boot App
docker build -t myapp/proximus-backend-app .
### Setup and run the containers in background task
docker-compose up -d --remove-orphans