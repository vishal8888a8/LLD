package BookMyShow.Theatre;

import java.util.List;

import BookMyShow.Movie.Movie;

public class Show {
    int id;
    Screen screen;
    List<Seat> bookedTickSeats;
    int startTime;
    Movie movie;

    public Show(int id, Screen screen, List<Seat> bookedTickSeats, int startTime, Movie movie) {
        this.id = id;
        this.screen = screen;
        this.bookedTickSeats = bookedTickSeats;
        this.startTime = startTime;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public List<Seat> getBookedTickSeats() {
        return bookedTickSeats;
    }

    public void setBookedTickSeats(List<Seat> bookedTickSeats) {
        this.bookedTickSeats = bookedTickSeats;
    }

    @Override
    public String toString() {
        return "Show [screen=" + screen + ", bookedTickSeats=" + bookedTickSeats + ", startTime=" + startTime
                + ", movie=" + movie + "]";
    }
    
}
