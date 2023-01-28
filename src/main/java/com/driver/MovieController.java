package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("new Director added successfully",HttpStatus.CREATED);
    }
    @PostMapping("/add_movie_director_pair")
    public ResponseEntity<String>addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director)
    {
        movieService.createMovieDirectorPair(movie,director);
        return new ResponseEntity<>("new movie-director pair added sucessfully",HttpStatus.CREATED);

    }
    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie>getMovieByName(@PathVariable String name)
    {
        Movie movie=movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director>getDirectorByName(@PathVariable String name)
    {
        Director director=movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.CREATED);
    }



    @GetMapping("/get_all_movies")
            public  ResponseEntity<List<String>>findAllMovies()
    {
       List<String>movies=movieService.findAllMovies();
       return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }
    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String>deleteDirectorByName(@RequestParam String director)
    {
        movieService.deleteDirectorByName(director);
        return new ResponseEntity<>(director+"removed successfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_all_directors")
    public ResponseEntity<String>deleteAllDirectors()
    {
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors removed successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get_movies_by_director_name/{director}")
   public ResponseEntity<List<String>>getMovieByDirectorName(@PathVariable String director)
    {
        List<String>movies=movieService.findMoviesFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }



}
