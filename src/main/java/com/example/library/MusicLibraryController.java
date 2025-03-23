package com.example.library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/music-libraries")
public class MusicLibraryController {

    @Autowired
    private MusicLibraryService musicLibraryService;

    // Retrieve all music libraries
    @GetMapping
    public ResponseEntity<List<MusicLibrary>> getAllMusicLibraries() {
        List<MusicLibrary> musicLibraries = musicLibraryService.getAllMusicLibraries();
        return new ResponseEntity<>(musicLibraries, HttpStatus.OK);
    }

    // Retrieve a music library by its ID
    @GetMapping("/{id}")
    public ResponseEntity<MusicLibrary> getMusicLibraryById(@PathVariable String id) {
        MusicLibrary musicLibrary = musicLibraryService.getMusicLibraryById(id);
        if (musicLibrary != null) {
            return new ResponseEntity<>(musicLibrary, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}