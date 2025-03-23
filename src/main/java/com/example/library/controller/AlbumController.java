package com.example.library.controller;

import com.example.library.model.Album;
import com.example.library.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums(
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre) {

        List<Album> albums;

        if (artist != null) {
            albums = albumService.getAlbumsByArtist(artist);
        } else if (genre != null) {
            albums = albumService.getAlbumsByGenre(genre);
        } else {
            albums = albumService.getAllAlbums();
        }

        return new ResponseEntity<>(albums, HttpStatus.OK);
    }
}