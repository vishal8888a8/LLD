package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.Enums.City;
import BookMyShow.Movie.Movie;

public class MovieHandler {
    int id;
    List<Movie> allMoviesList;
    Map<City,List<Movie>> cityMoviesList;

    public MovieHandler(int id) {
        this.id = id;
        allMoviesList = new ArrayList<>();
        cityMoviesList = new HashMap<>();
    }

    public void addMovie(Movie movie, City city) {
        allMoviesList.add(movie);
        
        List<Movie> movies = cityMoviesList.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityMoviesList.put(city, movies);
    }

    public List<Movie> findMoviesByCity(City city) {
        return cityMoviesList.get(city);
    }

    public Movie findMoviesByName(String name) {
        Movie movie = null;
        for ( Movie movie2: allMoviesList ) {
            if (movie2.getMovieName() == name) {
                movie = movie2;
            }
        }
        return movie;
    }
}
