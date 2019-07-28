# Proximus Challenge - Backend

Back-end application developed with Angular 7

## Dependencies

- java 8
- maven
- mongodb (required if local, optional if with docker)
- docker (optional)
- docker-compose (optional)

## Profiles

- dev -> default
- docker -> use -Pdocker

## Back-end local

Attention: You must have mongodb installed and running in your machine at port

Run `mvn clean install` or `maven clean package` (might also want to add `-U` to update snapshots)

Either run the app manually or using an IDE.

Manually:
`java -jar target/proximus-backend-0.0.1-SNAPSHOT.jar`

The server should be available at `http://localhost:8090/`

## Complete Docker integration

Either run the script `build4docker.sh` or the following commands:

- Build and package the Spring Boot Application

    `mvn clean package -Pdocker -U -Dmaven.test.skip=true`

- Creates Docker image for Spring Boot App

    `docker build -t myapp/proximus-backend-app .`

- Setup and run the containers in background task

    `docker-compose up -d --remove-orphans`
    
The server should be available at `http://localhost:8091/`

    
## API Information

In order to see the list of available endpoints with Swagger UI integration go to:

Run the app either:

- Local:
`http://localhost:8090/swagger-ui.html`

- Docker:
`http://localhost:8091/swagger-ui.html`

