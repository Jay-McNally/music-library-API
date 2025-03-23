package com.example.library.repository;

import com.example.library.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlbumRepository extends MongoRepository<Album, String> {
    List<Album> findByArtist(String artist);
    List<Album> findByGenre(String genre);
}