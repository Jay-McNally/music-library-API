# music-library-API

This project is a Music Library API built with Spring Boot. It provides RESTful endpoints to manage music libraries, including artists, albums, and tracks. The application uses MongoDB as the database to store the music library data.

## Features

- Retrieve all music libraries
- Retrieve a music library by its ID
- Retrieve all artists
- Retrieve artists by name
- Retrieve all albums
- Retrieve albums by artist or genre
- Retrieve all tracks
- Retrieve tracks by artist, album, or genre

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

### Music Libraries
- `GET /api/music-libraries` - Retrieve all music libraries
- `GET /api/music-libraries/{id}` - Retrieve a music library by its ID

### Artists
- `GET /api/artists` - Retrieve all artists
- `GET /api/artists?name={name}` - Retrieve artists by name

### Albums
- `GET /api/albums` - Retrieve all albums
- `GET /api/albums?artist={artist}` - Retrieve albums by artist
- `GET /api/albums?genre={genre}` - Retrieve albums by genre

### Tracks
- `GET /api/tracks` - Retrieve all tracks
- `GET /api/tracks?artist={artist}` - Retrieve tracks by artist
- `GET /api/tracks?album={album}` - Retrieve tracks by album
- `GET /api/tracks?genre={genre}` - Retrieve tracks by genre