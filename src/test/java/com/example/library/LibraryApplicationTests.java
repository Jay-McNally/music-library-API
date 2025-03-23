package com.example.library;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() throws Exception {
        createNewMusicLibrary();
    }

    private void createNewMusicLibrary() throws Exception {
        String newLibraryJson = new String(Files.readAllBytes(Paths.get("src/main/resources/static/music_library.json")));

        // Save the new music library
        mockMvc.perform(post("/api/music-libraries")
                .contentType("application/json")
                .content(newLibraryJson))
                .andExpect(status().isCreated());
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testRetrieveAllMusicLibraries() throws Exception {
        mockMvc.perform(get("/api/music-libraries"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void testRetrieveMusicLibraryById() throws Exception {
        // Assuming the ID of the created library is "1"
        mockMvc.perform(get("/api/music-libraries/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.artists[0].name").value("Nirvana"))
                .andExpect(jsonPath("$.artists[0].albums[0].name").value("BBC Sessions Nirvana - 1989-1990"))
                .andExpect(jsonPath("$.artists[0].albums[0].tracks[0].title").value("(New Wave) Polly"))
                .andExpect(jsonPath("$.artists[0].albums[0].tracks[1].title").value("About A Girl"));
    }

    @Test
    void testRetrieveAllArtists() throws Exception {
        mockMvc.perform(get("/api/artists"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Nirvana"));
    }

    @Test
    void testRetrieveArtistByName() throws Exception {
        mockMvc.perform(get("/api/artists").param("name", "Nirvana"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("Nirvana"));
    }

    @Test
    void testRetrieveAllAlbums() throws Exception {
        mockMvc.perform(get("/api/albums"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").value("BBC Sessions Nirvana - 1989-1990"));
    }

    @Test
    void testRetrieveAlbumsByArtist() throws Exception {
        mockMvc.perform(get("/api/albums").param("artist", "Nirvana"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].artist").value("Nirvana"));
    }

    @Test
    void testRetrieveAlbumsByGenre() throws Exception {
        mockMvc.perform(get("/api/albums").param("genre", "Other"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].genre").value("Other"));
    }

    @Test
    void testRetrieveAllTracks() throws Exception {
        mockMvc.perform(get("/api/tracks"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].title").value("(New Wave) Polly"));
    }

    @Test
    void testRetrieveTracksByArtist() throws Exception {
        mockMvc.perform(get("/api/tracks").param("artist", "Nirvana"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].artist").value("Nirvana"));
    }

    @Test
    void testRetrieveTracksByAlbum() throws Exception {
        mockMvc.perform(get("/api/tracks").param("album", "BBC Sessions Nirvana - 1989-1990"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].album").value("BBC Sessions Nirvana - 1989-1990"));
    }

    @Test
    void testRetrieveTracksByGenre() throws Exception {
        mockMvc.perform(get("/api/tracks").param("genre", "Other"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].genre").value("Other"));
    }
}
