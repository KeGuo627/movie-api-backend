package dev.oliviake.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                //initiates an update operation on the Movie collection, targets collection associated with Movie class
                .matching(Criteria.where("imdbId").is(imdbId))
                //specifies the query criteria to find document to be updated, where the field imdbId value match the provided imdbId value
                .apply(new Update().push("reviewIds").value(review))
                //create an update operation that pushes(adds) a value to an array field
                //adding a new value to the reviewIds array field
                .first(); //ensures that only the first matching document found is updated. If want to update multiple documents, should use .all() instead

        //perform custom queries and updates on MongoDB documents
        return review;

    }
}
