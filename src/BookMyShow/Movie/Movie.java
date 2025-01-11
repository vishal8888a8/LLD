package BookMyShow.Movie;

public class Movie {

    int id;
    String movieName;
    int durationInMinutes;
    
    public Movie(int id, String movieName, int durationInMinutes) {
        this.id = id;
        this.movieName = movieName;
        this.durationInMinutes = durationInMinutes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

}
