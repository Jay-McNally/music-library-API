package com.example.library;
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

    public MusicLibrary saveMusicLibrary(MusicLibrary musicLibrary) {
        return musicLibraryRepository.save(musicLibrary);
    }

    public void deleteMusicLibrary(String id) {
        musicLibraryRepository.deleteById(id);
    }
}