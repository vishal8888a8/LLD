package BookMyShow.Booking;

import BookMyShow.Enums.City;
import BookMyShow.Movie.Movie;
import BookMyShow.Theatre.Screen;
import BookMyShow.Theatre.Seat;
import BookMyShow.Theatre.Show;
import BookMyShow.Theatre.Theatre;

public class Booking {
    int id;
    Movie movie;
    Theatre theatre;
    City city;
    Show show;
    Screen screen;
    Seat seat;
    
    public Booking(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking [id=" + id + ", movie=" + movie.getMovieName() + ", theatre=" + theatre + ", city=" + city + ", show=" + show.toString()
                + ", screen=" + screen + ", seat=" + seat + "]";
    }
    
}
