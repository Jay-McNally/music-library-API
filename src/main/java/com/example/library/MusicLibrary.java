package com.example.library;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "musicLibrary")
public class MusicLibrary {
    @Id
    private String id;

    @Field("artists")
    private List<Artist> artists;
}
