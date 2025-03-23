package com.example.library.controller;

import com.example.library.model.Artist;
import com.example.library.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(@RequestParam(required = false) String name) {
        List<Artist> artists;

        if (name != null) {
            artists = artistService.getArtistsByName(name);
        } else {
            artists = artistService.getAllArtists();
        }

        return new ResponseEntity<>(artists, HttpStatus.OK);
    }
}