This is the Backend for Movie-api Project

Use Spring Boot to build Backend
1. use Spring Initalizr to create Spring Boot project

2 parts:
Movie and Review

Movie:
  1. Movie.class
  2. MovieController
  3. MovieService
  4. MovieRepository

Review:
  1. Review.class
  2. ReviewController
  3. ReviewService
  4. ReviewRepository

run the project:
1. get all movies: localhost:8080/api/v1/movies
2. get single movie: localhost:8080/api/v1/movies/${imdbId}
3. post review: localhost:8080/api/v1/reviews
