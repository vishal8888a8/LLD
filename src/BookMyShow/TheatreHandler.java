package BookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BookMyShow.Enums.City;
import BookMyShow.Movie.Movie;
import BookMyShow.Theatre.Show;
import BookMyShow.Theatre.Theatre;

public class TheatreHandler {
    int id;
    Map<City,List<Theatre>> theatresList;
    List<Theatre> allTheatresList;
    
    public TheatreHandler(int id) {
        this.id = id;
        allTheatresList = new ArrayList<>();
        theatresList = new HashMap<>();
    }

    public void addTheatre(City city, Theatre theatre) {
        allTheatresList.add(theatre);

        List<Theatre> temp = theatresList.getOrDefault(city,new ArrayList<>());
        temp.add(theatre);
        theatresList.put(city, temp);
    }

    public Map<Theatre,List<Show>> getShowsWithTheatresList(Movie movie, City city) {
        Map<Theatre,List<Show>> showsWithTheatres = new HashMap<>();

        List<Theatre> theatres = theatresList.get(city);
        for ( Theatre theatre : theatres ) {
            List<Show> showsList = theatre.getShowsList();
            List<Show> shows = new ArrayList<>();
            for ( Show show: showsList ) {
                if ( show.getMovie().getMovieName() == movie.getMovieName() )
                    shows.add(show);
            }
            if ( shows.size() != 0 )
                showsWithTheatres.put(theatre, shows);
        }

        return showsWithTheatres;
    }
}
