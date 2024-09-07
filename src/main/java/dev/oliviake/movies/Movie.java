package dev.oliviake.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private List<String>  backdrops;
    @DocumentReference
    private List<Review> reviewIds; // List of Reviews related to a Movie document, manage relationships between documents inside different collections
    //One-to-One: A document in one collection relates to  a single document in another collection.
    //One-to-Many: A document in one collection points to multiple documents in another collection.



}
