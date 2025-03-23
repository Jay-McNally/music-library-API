package com.example.library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/music-library")
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
        Optional<MusicLibrary> musicLibrary = Optional.ofNullable(musicLibraryService.getMusicLibraryById(id));
        return musicLibrary.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Save a new or updated music library
    @PostMapping
    public ResponseEntity<MusicLibrary> saveMusicLibrary(@RequestBody MusicLibrary musicLibrary) {
        MusicLibrary savedMusicLibrary = musicLibraryService.saveMusicLibrary(musicLibrary);
        return new ResponseEntity<>(savedMusicLibrary, HttpStatus.CREATED);
    }

    // Delete a music library by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusicLibrary(@PathVariable String id) {
        musicLibraryService.deleteMusicLibrary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}