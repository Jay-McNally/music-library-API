package com.example.library.service;

import com.example.library.model.Album;
import com.example.library.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public List<Album> getAlbumsByArtist(String artist) {
        return albumRepository.findByArtist(artist);
    }

    public List<Album> getAlbumsByGenre(String genre) {
        return albumRepository.findByGenre(genre);
    }
}