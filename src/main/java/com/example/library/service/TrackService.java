package com.example.library.service;

import com.example.library.model.Track;
import com.example.library.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService {

    @Autowired
    private TrackRepository trackRepository;

    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    public List<Track> getTracksByArtist(String artist) {
        return trackRepository.findByArtist(artist);
    }

    public List<Track> getTracksByAlbum(String album) {
        return trackRepository.findByAlbum(album);
    }

    public List<Track> getTracksByGenre(String genre) {
        return trackRepository.findByGenre(genre);
    }
}