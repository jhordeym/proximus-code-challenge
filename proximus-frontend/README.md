# Proximus Challenge - Frontend

Front-end application developed with Angular 7

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 7.3.8.

## Dependencies

- node
- npm
- angular CLI
- docker (optional)
- docker-compose (optional)

## Development server

Run `npm install` to install project dependencies.

#### - Back-end running locally
Run `npm start` or `ng serve` to run the Angular app. 

#### - Back-end running in a Docker container
Run `npm run docker` to run the Angular app with Docker profile.

##### For both cases:
Navigate to `http://localhost:4200/`. 
The app will automatically reload if you change any of the source files.


## Complete Docker integration

Run `docker-compose -f "docker-compose.yml" up -d --build` to build and create a docker container.

Navigate to `http://localhost:4201`.
