package com.example.library.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "artists")
public class Artist {
    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("albums")
    private List<Album> albums;
}
