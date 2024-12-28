package VehicleRentalSystem.Store;

import java.util.ArrayList;
import java.util.List;

import VehicleRentalSystem.VehicleInventoryManagement;
import VehicleRentalSystem.Location.Location;
import VehicleRentalSystem.Reservation.Reservation;
import VehicleRentalSystem.Reservation.ReservationStatus;
import VehicleRentalSystem.User.User;
import VehicleRentalSystem.Vehicle.Vehicle;
import VehicleRentalSystem.Vehicle.VehicleType;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservationsList;

    public Store(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
        reservationsList = new ArrayList<>();
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehiclesList(vehicleType);
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement.setVehiclesList(vehicles);
    }

    public Reservation createReservations(User user, Vehicle vehicle) {
        Reservation reservation = new Reservation();
        reservation.createReservations(user, vehicle);
        reservationsList.add(reservation);
        return reservation;
    }

    public void completeReservations(Reservation reservation) {
        reservation.setReservationStatus(ReservationStatus.COMPLETED);
    }

    @Override
    public String toString() {
        return "Store [storeId=" + storeId + ", vehicleInventoryManagement=" + vehicleInventoryManagement
                + ", location=" + location + ", reservationsList=" + reservationsList + "]";
    }

}
