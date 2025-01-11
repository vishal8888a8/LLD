package BookMyShow.Theatre;

import java.util.ArrayList;
import java.util.List;

import BookMyShow.Enums.City;

public class Theatre {
    int id;
    List<Screen> screensList;
    List<Show> showsList;
    City city;
    
    public Theatre(int id, City city) {
        this.id = id;
        this.city = city;
        screensList = new ArrayList<>();
        showsList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Screen> getScreensList() {
        return screensList;
    }

    public void setScreensList(List<Screen> screensList) {
        this.screensList = screensList;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Show> showsList) {
        this.showsList = showsList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
}
