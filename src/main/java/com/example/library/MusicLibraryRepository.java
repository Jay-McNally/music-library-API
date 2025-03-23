package com.example.library;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicLibraryRepository extends MongoRepository<MusicLibrary, String> {

}
