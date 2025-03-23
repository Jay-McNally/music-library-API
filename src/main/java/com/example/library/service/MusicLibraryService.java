package com.example.library.service;

import com.example.library.model.MusicLibrary;
import com.example.library.repository.MusicLibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicLibraryService {

    @Autowired
    private MusicLibraryRepository musicLibraryRepository;

    public List<MusicLibrary> getAllMusicLibraries() {
        return musicLibraryRepository.findAll();
    }

    public MusicLibrary getMusicLibraryById(String id) {
        return musicLibraryRepository.findById(id).orElse(null);
    }
}