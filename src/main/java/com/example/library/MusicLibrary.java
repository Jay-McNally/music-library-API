package com.example.library;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.Map;

@Data
@Document(collection = "musicLibrary")
public class MusicLibrary {
    @Id
    private String id;

    @Field("artists")
    private Map<String, Artist> artists;
}
