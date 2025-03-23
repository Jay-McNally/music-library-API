package com.example.library;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testRetrieveAllMusicLibraries() throws Exception {
        mockMvc.perform(get("/api/music-library"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void testRetrieveMusicLibraryById() throws Exception {
        String id = "some-id"; // Replace with a valid ID
        mockMvc.perform(get("/api/music-library/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    void testSaveNewMusicLibrary() throws Exception {
        String newLibraryJson = "{\"name\":\"New Library\",\"artist\":\"New Artist\"}"; // Replace with valid JSON
        mockMvc.perform(post("/api/music-library")
                .contentType("application/json")
                .content(newLibraryJson))
                .andExpect(status().isCreated());
    }

    @Test
    void testDeleteMusicLibraryById() throws Exception {
        String id = "some-id"; // Replace with a valid ID
        mockMvc.perform(delete("/api/music-library/{id}", id))
                .andExpect(status().isNoContent());
    }
}
