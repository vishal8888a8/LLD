package VehicleRentalSystem.Payment;

import VehicleRentalSystem.Reservation.Reservation;

public class Bill {
    Reservation reservation;
    double amDouble;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.isPaid = false;
        this.amDouble = calculateAmount();
    }

    private double calculateAmount() {
        //TODO:- bill calculation logic
        return 1000.0;
    }

    @Override
    public String toString() {
        return "Bill [reservation=" + reservation + ", amDouble=" + amDouble + ", isPaid=" + isPaid + "]";
    }

    
}
