package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

import VehicleRentalSystem.Location.Location;
import VehicleRentalSystem.Payment.Bill;
import VehicleRentalSystem.Payment.Payment;
import VehicleRentalSystem.Reservation.Reservation;
import VehicleRentalSystem.Store.Store;
import VehicleRentalSystem.User.User;
import VehicleRentalSystem.Vehicle.Vehicle;
import VehicleRentalSystem.Vehicle.VehicleStatus;
import VehicleRentalSystem.Vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {

        //dummy data
        List<User> usersList = getUsers();
        List<Vehicle> vehiclesList = getVehicle();
        List<Store> storesList = getStores(vehiclesList);

        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem(storesList,usersList);

        //0. user comes
        User user = usersList.get(0);

        //1. search the stores based on location
        Location location = new Location("address", "city", "state", 10000L);
        Store store = vehicleRentalSystem.getStoreByLocation(location);

        //2. get all vehicles
        List<Vehicle> vehicles = store.getVehicles(VehicleType.CAR);
        Vehicle selectedVehicle = vehicles.get(0);

        //3. do reservation
        Reservation reservation = store.createReservations(user,selectedVehicle);

        //4. generate bill
        Bill bill = new Bill(reservation);

        //5. do payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. complete the booking
        store.completeReservations(reservation);


        // PRINT AND CHECK ALL VALUES
        System.out.println(user.toString()+"\n\n");
        System.out.println(store.toString()+"\n\n");
        System.out.println(selectedVehicle.toString()+"\n\n");
        System.out.println(reservation.toString()+"\n\n");
        System.out.println(bill.toString()+"\n\n");
        }
        
    public static List<User> getUsers() {
        List<User> usersList = new ArrayList<>();

        User user1 = new User(10, "user 1");
        User user2 = new User(10, "user 2");

        usersList.add(user1);
        usersList.add(user2);
        
        return usersList;
    }

    public static List<Vehicle> getVehicle() {
        List<Vehicle> vehiclesList = new ArrayList<>();

        Vehicle vehicle1 = Vehicle.Builder()
                                .setVehicleId(101)
                                .setVehicleName("Maruti")
                                .setVehicleNumber("KA101A34")
                                .setVehicleStatus(VehicleStatus.ACTIVE)
                                .setVehicleType(VehicleType.CAR)
                                .build();
        
        Vehicle vehicle2 = Vehicle.Builder()
                                .setVehicleId(102)
                                .setVehicleName("Hero honda")
                                .setVehicleNumber("KA101B34")
                                .setVehicleStatus(VehicleStatus.INACTIVE)
                                .setVehicleType(VehicleType.BIKE)
                                .build();
        
        vehiclesList.add(vehicle1);
        vehiclesList.add(vehicle2);

        return vehiclesList;
    }

    public static List<Store> getStores(List<Vehicle> vehicles) {
        List<Store> storesList = new ArrayList<>();

        Store store = new Store(vehicles);
        storesList.add(store);

        return storesList;
    }
}
