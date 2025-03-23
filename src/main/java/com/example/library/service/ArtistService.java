package com.example.library.service;

import com.example.library.model.Artist;
import com.example.library.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public List<Artist> getArtistsByName(String name) {
        return artistRepository.findByName(name);
    }
}