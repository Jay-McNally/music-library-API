package com.example.library.repository;

import com.example.library.model.Artist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArtistRepository extends MongoRepository<Artist, String> {
    List<Artist> findByName(String name);
}