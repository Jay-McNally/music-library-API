package com.example.library.controller;

import com.example.library.model.Track;
import com.example.library.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracks")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks(
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String album,
            @RequestParam(required = false) String genre) {

        List<Track> tracks;

        if (artist != null) {
            tracks = trackService.getTracksByArtist(artist);
        } else if (album != null) {
            tracks = trackService.getTracksByAlbum(album);
        } else if (genre != null) {
            tracks = trackService.getTracksByGenre(genre);
        } else {
            tracks = trackService.getAllTracks();
        }

        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }
}