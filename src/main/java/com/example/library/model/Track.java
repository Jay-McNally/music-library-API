package com.example.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "tracks")
public class Track {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("artist")
    private String artist;

    @Field("album")
    private String album;

    @Field("genre")
    private String genre;

    @Field("duration")
    private int duration;
}
