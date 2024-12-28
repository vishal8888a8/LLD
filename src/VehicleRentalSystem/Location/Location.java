package VehicleRentalSystem.Location;

public class Location {
    String address;
    String city;
    String state;
    Long pincode;
    
    public Location(String address, String city, String state, Long pincode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public Long getPincode() {
        return pincode;
    }
    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    
}
