package VehicleRentalSystem;

import java.util.List;

import VehicleRentalSystem.Location.Location;
import VehicleRentalSystem.Store.Store;
import VehicleRentalSystem.User.User;

public class VehicleRentalSystem {
    List<Store> storesList;
    List<User> usersList;

    public VehicleRentalSystem(List<Store> stores, List<User> users) {
        storesList = stores;
        usersList = users;
    }

    public Store getStoreByLocation(Location location) {

        //algorithm for stores selection based on location
        return storesList.get(0);
    }

    public List<Store> getStoresList() {
        return storesList;
    }

    public void setStoresList(List<Store> storesList) {
        this.storesList = storesList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<User> usersList) {
        this.usersList = usersList;
    }

    
}
