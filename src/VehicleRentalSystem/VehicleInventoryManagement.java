package VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

import VehicleRentalSystem.Vehicle.Vehicle;
import VehicleRentalSystem.Vehicle.VehicleStatus;
import VehicleRentalSystem.Vehicle.VehicleType;

public class VehicleInventoryManagement {
    List<Vehicle> vehiclesList;

    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        vehiclesList = vehicles;
    }

    public List<Vehicle> getVehiclesList(VehicleType vehicleType) {
        List<Vehicle> activevehicleList = new ArrayList<>();

        for ( Vehicle vehicle: vehiclesList ) {
            if ( vehicle.getVehicleStatus() == VehicleStatus.ACTIVE 
                    && vehicle.getVehicleType() == vehicleType )
                activevehicleList.add(vehicle);
        }

        return activevehicleList;
    }

    public void setVehiclesList(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
    }

    public void addVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
    }

    public void deleteVehicle(Vehicle vehicle) {
        vehiclesList.removeIf( itr-> itr == vehicle);
    }
}
