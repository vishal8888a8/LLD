package VehicleRentalSystem.Reservation;

import java.sql.Date;

import VehicleRentalSystem.Location.Location;
import VehicleRentalSystem.User.User;
import VehicleRentalSystem.Vehicle.Vehicle;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Location pickup;
    Location dropoff;
    ReservationStatus reservationStatus;

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    ReservationType reservationType;
    Date bookedFrom;
    Date bookedTill;
    Date bookingDate;
    Long startTime;
    Long endTime;

    public Reservation() {
    }

    public int createReservations(User user, Vehicle vehicle) {
        reservationId = 1001;
        this.user = user;
        this.vehicle = vehicle;
        this.reservationStatus = ReservationStatus.SCHEDULED;
        this.reservationType = ReservationType.HOURLY;
        return reservationId;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", user=" + user + ", vehicle=" + vehicle + ", pickup="
                + pickup + ", dropoff=" + dropoff + ", reservationStatus=" + reservationStatus + ", reservationType="
                + reservationType + ", bookedFrom=" + bookedFrom + ", bookedTill=" + bookedTill + ", bookingDate="
                + bookingDate + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    //TODO:- CRUD

    
}
