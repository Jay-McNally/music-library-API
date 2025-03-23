package com.example.library.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.library.model.MusicLibrary;

public interface MusicLibraryRepository extends MongoRepository<MusicLibrary, String> {
}
