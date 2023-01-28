package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.saveMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.saveDirector(director);
    }

    public Movie findMovie(String movie) {
       return movieRepository.findMovie(movie);
    }

    public List<String> findAllMovies() {
       return movieRepository.findAllMovies();
    }

    public Director findDirector(String name) {
       return movieRepository.findDirector(name);
    }

    public void createMovieDirectorPair(String movie, String director) {
        movieRepository.saveMovieDirectorPair(movie,director);
    }

    public void deleteDirectorByName(String director) {
        movieRepository.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectors();
    }

    public String getDirectorName(String movie) {
       return movieRepository.getDirectorName(movie);
    }

    public List<String> findMoviesFromDirector(String director) {
        return movieRepository.findMoviesFromDirector(director);
    }
}
