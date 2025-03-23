package com.example.library;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "albums")
public class Album {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("artist")
    private String artist;

    @Field("genre")
    private String genre;

    @Field("tracks")
    private List<Track> tracks;
}