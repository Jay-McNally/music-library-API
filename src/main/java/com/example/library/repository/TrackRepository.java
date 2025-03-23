package com.example.library.repository;

import com.example.library.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track, String> {
    List<Track> findByArtist(String artist);
    List<Track> findByAlbum(String album);
    List<Track> findByGenre(String genre);
}