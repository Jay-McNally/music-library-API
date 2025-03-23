# music-library-API

This project is a Music Library API built with Spring Boot. It provides RESTful endpoints to manage music libraries, including artists, albums, and tracks. The application uses MongoDB as the database to store the music library data.

## Features

- Retrieve all music libraries
- Retrieve a music library by its ID
- Save a new or updated music library
- Delete a music library by its ID

## Technologies Used

- Spring Boot
- Spring Data MongoDB
- MongoDB
- Lombok

## Getting Started

To run the application, use the following command:

```sh
mvn spring-boot:run
```

You can also use Docker Compose to start the MongoDB and Mongo Express services:

```sh
docker-compose up
```

## Endpoints

- `GET /api/music-library` - Retrieve all music libraries
- `GET /api/music-library/{id}` - Retrieve a music library by its ID
- `POST /api/music-library` - Save a new or updated music library
- `DELETE /api/music-library/{id}` - Delete a music library by its ID