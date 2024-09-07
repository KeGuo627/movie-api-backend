package dev.oliviake.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MoviesRepository moviesRepository;
    //here autowired is to let framework instantiated moviesRepository for us

    public List<Movie> allMovies(){
        return moviesRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return moviesRepository.findMovieByImdbId(imdbId);
    }
}
