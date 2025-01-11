package BookMyShow.Theatre;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    int id;
    List<Seat> allSeatsList;
    
    public Screen(int id) {
        this.id = id;
        allSeatsList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Seat> getAllSeatsList() {
        return allSeatsList;
    }

    public void setAllSeatsList(List<Seat> allSeatsList) {
        this.allSeatsList = allSeatsList;
    }
    
}
