package com.example.library;
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

    @Field("albums")
    private Map<String, List<Track>> albums;
}
