package VehicleRentalSystem.Vehicle;

//It uses Builder design patter to generate vehicle along with immutability

public class Vehicle {
    int vehicleId;
    String vehicleName;
    String vehicleNumber;
    VehicleStatus vehicleStatus;
    VehicleType vehicleType;

    public Vehicle(VehicleBuilder vehicleBuilder) {
        this.vehicleId = vehicleBuilder.vehicleId;
        this.vehicleName = vehicleBuilder.vehicleName;
        this.vehicleNumber = vehicleBuilder.vehicleNumber;
        this.vehicleStatus = vehicleBuilder.vehicleStatus;
        this.vehicleType = vehicleBuilder.vehicleType;
    }

    public static VehicleBuilder Builder(){
        return new VehicleBuilder();
    }

    public static class VehicleBuilder{
        int vehicleId;
        String vehicleName;
        String vehicleNumber;
        VehicleStatus vehicleStatus;
        VehicleType vehicleType;

        public VehicleBuilder() {
        }

        public VehicleBuilder setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }

        public VehicleBuilder setVehicleName(String vehicleName) {
            this.vehicleName = vehicleName;
            return this;
        }

        public VehicleBuilder setVehicleNumber(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            return this;
        }

        public VehicleBuilder setVehicleStatus(VehicleStatus vehicleStatus) {
            this.vehicleStatus = vehicleStatus;
            return this;
        }

        public VehicleBuilder setVehicleType(VehicleType vehicleType) {
            this.vehicleType = vehicleType;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle [vehicleId=" + vehicleId + ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber
                + ", vehicleStatus=" + vehicleStatus + ", vehicleType=" + vehicleType + "]";
    }

    
}
