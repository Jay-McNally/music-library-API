package com.example.library;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private String createdLibraryId;

    @BeforeEach
    void setUp() throws Exception {
        createdLibraryId = createNewMusicLibrary();
    }

    private String createNewMusicLibrary() throws Exception {
        String newLibraryJson = """
        {
            "Nirvana": {
                "BBC Sessions Nirvana - 1989-1990": [
                    {
                        "title": "(New Wave) Polly",
                        "artist": "Nirvana",
                        "album": "BBC Sessions Nirvana - 1989-1990",
                        "genre": "Other",
                        "duration": 108
                    },
                    {
                        "title": "About A Girl",
                        "artist": "Nirvana",
                        "album": "BBC Sessions Nirvana - 1989-1990",
                        "genre": "Other",
                        "duration": 163
                    }
                ]
            }
        }
        """;

        // Save the new music library
        MvcResult result = mockMvc.perform(post("/api/music-library")
                .contentType("application/json")
                .content(newLibraryJson))
                .andExpect(status().isCreated())
                .andReturn();

        // Extract the ID of the newly created music library from the response
        String location = result.getResponse().getHeader("Location");
        assertNotNull(location);
        return location.substring(location.lastIndexOf("/") + 1);
    }

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
        mockMvc.perform(get("/api/music-library/{id}", createdLibraryId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.Nirvana['BBC Sessions Nirvana - 1989-1990'][0].title").value("(New Wave) Polly"))
                .andExpect(jsonPath("$.Nirvana['BBC Sessions Nirvana - 1989-1990'][1].title").value("About A Girl"));
    }

    @Test
    void testSaveNewMusicLibrary() throws Exception {
        String newLibraryId = createNewMusicLibrary();
        assertNotNull(newLibraryId);
    }

    @Test
    void testDeleteMusicLibraryById() throws Exception {
        String newLibraryId = createNewMusicLibrary();

        // Delete the newly created music library
        mockMvc.perform(delete("/api/music-library/{id}", newLibraryId))
                .andExpect(status().isNoContent());
    }
}
