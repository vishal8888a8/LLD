package BookMyShow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import BookMyShow.Booking.Booking;
import BookMyShow.Enums.City;
import BookMyShow.Enums.SeatType;
import BookMyShow.Movie.Movie;
import BookMyShow.Theatre.Screen;
import BookMyShow.Theatre.Seat;
import BookMyShow.Theatre.Show;
import BookMyShow.Theatre.Theatre;

public class BookMyShow {
    MovieHandler movieHandler;
    TheatreHandler theatreHandler;

    BookMyShow() {
        movieHandler = new MovieHandler(1);
        theatreHandler = new TheatreHandler(1);
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();

        //initializing the theatres and movies
        bookMyShow.initialize();

        //book ticket for this
        bookMyShow.bookTicketsFor("Venom", City.BANGALORE);

        //rebooking with same seat number, SHOULD NOT BE SUCCESS
        bookMyShow.bookTicketsFor("Venom", City.BANGALORE);
    }

    public void bookTicketsFor(String movieName, City city) {
        //Find all movies currently paying in my city
        List<Movie> moviesList = movieHandler.findMoviesByCity(city);

        //check if my movie is playing in this city
        Movie movie = null;
        for ( Movie movieitr: moviesList ) {
            if ( movieitr.getMovieName() == movieName ) {
                movie =  movieitr;
            }
        }

        if ( movie == null ) {
            System.out.print("Your movie is not playing this city");
            return;
        }

        //Find all Theatres playing the movie with shows
        Map<Theatre,List<Show>> theatreVsShows = theatreHandler.getShowsWithTheatresList(movie, city);

        //User has selected first theatres
        Map.Entry<Theatre,List<Show>> entry = theatreVsShows.entrySet().iterator().next();
        List<Show> showsList = entry.getValue();

        //User has selected first show
        Show selectedShow = showsList.get(0);

        //User want's too book seat iwith id 0
        int seatID = 0;
        List<Seat> bookedSeats = selectedShow.getBookedTickSeats();
        if ( isBooked(bookedSeats,seatID)) {
            System.out.println("this seat is booked");
            return;
        }
        else {
            Seat seat = null;
            List<Seat> seats = selectedShow.getScreen().getAllSeatsList();
            for ( Seat seatItr: seats ) {
                if ( seatItr.getId() == seatID)
                    seat = seatItr;
            }

            bookedSeats.add(seat);
            selectedShow.setBookedTickSeats(bookedSeats);

            Booking booking = new Booking(100);
            booking.setCity(City.BANGALORE);
            booking.setMovie(movie);
            booking.setScreen(selectedShow.getScreen());
            booking.setShow(selectedShow);
            booking.setTheatre(entry.getKey());
            booking.setSeat(seat);

            System.out.println("Booking successfull!");
            System.out.println(booking.toString());
        }

    }

    public boolean isBooked(List<Seat> bookedSeats, int seatId) {
        boolean isBooked = false;
        for ( Seat seat: bookedSeats ) {
            if ( seat.getId() == seatId )
                isBooked = true;
        }
        return isBooked;
    }

    public void initialize() {

        //initalizing movies
        movieHandler.addMovie(new Movie(0,"Morbius", 120), City.MUMBAI);
        movieHandler.addMovie(new Movie(1, "Kraven the Hunter", 189), City.MUMBAI);
        movieHandler.addMovie(new Movie(2, "Venom", 110), City.BANGALORE);
        movieHandler.addMovie(new Movie(3, "Madame web", 110), City.BANGALORE);


        // initializing theatres
        Theatre mumbaiTheatre = new Theatre(0, City.MUMBAI);
        mumbaiTheatre.setScreensList(createScreens());
        List<Show> showsList = new ArrayList<>();
        Show show1 = new Show(0, mumbaiTheatre.getScreensList().get(0), new ArrayList<>(), 12, movieHandler.findMoviesByName("Morbius"));
        Show show2 = new Show(1, mumbaiTheatre.getScreensList().get(0), new ArrayList<>(), 16, movieHandler.findMoviesByName("Kraven the Hunter"));
        showsList.add(show1);
        showsList.add(show2);
        mumbaiTheatre.setShowsList(showsList);
        theatreHandler.addTheatre(City.MUMBAI, mumbaiTheatre);

        Theatre bangaloreTheatre = new Theatre(1, City.BANGALORE);
        mumbaiTheatre.setScreensList(createScreens());
        showsList = new ArrayList<>();
        show1 = new Show(0, mumbaiTheatre.getScreensList().get(0), new ArrayList<>(), 12, movieHandler.findMoviesByName("Venom"));
        show2 = new Show(1, mumbaiTheatre.getScreensList().get(0), new ArrayList<>(), 16, movieHandler.findMoviesByName("Madame web"));
        showsList.add(show1);
        showsList.add(show2);
        bangaloreTheatre.setShowsList(showsList);
        theatreHandler.addTheatre(City.BANGALORE, bangaloreTheatre);

    }

    public List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen(0);
        Seat seat1 = new Seat(0, 100, 0, 0, SeatType.DIAMOND);
        Seat seat2 = new Seat(1, 100, 0, 1, SeatType.SILVER);
        Seat seat3 = new Seat(2, 100, 1, 0, SeatType.GOLD);
        screen1.setAllSeatsList(new ArrayList<>(Arrays.asList(seat1,seat2,seat3)));
        screens.add(screen1);
        return screens;
    }
}
