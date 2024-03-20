package service;

import model.Movie;

public interface MovieService {
    Movie[] searchMovieByName(String Name);
    void addMovie(Movie movie);
    void deleteMovie(String Name);
}
