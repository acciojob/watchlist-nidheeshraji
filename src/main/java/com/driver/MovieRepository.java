package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository

public class MovieRepository {
    private HashMap<String,Movie>moviemap;
    private HashMap<String,Director>directormap;
    private HashMap<String,List<String>>directormoviemap;

    public MovieRepository() {
        this.moviemap=new HashMap<String,Movie>();
        this.directormap=new HashMap<String,Director>();
        this.directormoviemap=new  HashMap<String,List<String>>();
    }

    public Movie findMovie(String name) {
        return moviemap.get(name);
    }
    public Director findDirector(String name) {
        return directormap.get(name);
    }
    public void saveMovie(Movie movie) {
       this.moviemap.put(movie.getName(),movie);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if(moviemap.containsKey(movie) && directormap.containsKey(director))
        {
            moviemap.put(movie,moviemap.get(movie));
            directormap.put(director,directormap.get(director));
            List<String>currentMovies=new ArrayList<>();
            if(directormoviemap.containsKey(director))
                currentMovies=directormoviemap.get(director);
            currentMovies.add(movie);
            directormoviemap.put(director,currentMovies);

        }

    }

    public List<String> findAllMovies() {
        return new ArrayList<>(moviemap.keySet());

    }



    public void saveDirector(Director director) {
        this.directormap.put(director.getName(),director);
    }

    public void deleteDirectorByName(String director) {
        List<String>movies=new ArrayList<>();
        if(directormoviemap.containsKey(director))
        {
            movies=directormoviemap.get(director);
            for(String movie:movies)
            {
                if(moviemap.containsKey(movie))
                    moviemap.remove(movie);
            }
            directormoviemap.remove(director);
        }
    }

    public void deleteAllDirectors() {
        HashSet<String>movieSet=new HashSet<>();
        for(String director:directormoviemap.keySet())
        {
            for(String movie:directormoviemap.get(director))
            {
                movieSet.add(movie);
            }
        }
        for(String movie:movieSet)
        {
            if(moviemap.containsKey(movie))
            {
                moviemap.remove(movie);
            }
        }

    }

    public String getDirectorName(String movie) {
        HashSet<String>movieset=new HashSet<>();
        for(String director:directormoviemap.keySet())
        {
            if(directormoviemap.get(director).contains(movie))
                return director;
        }
        return "No movie found ";

    }


    public List<String> findMoviesFromDirector(String director) {
        List<String> moviesList=new ArrayList<>();
        if(directormoviemap.containsKey(director))
            moviesList=directormoviemap.get(director);
           return moviesList;
        }


}
