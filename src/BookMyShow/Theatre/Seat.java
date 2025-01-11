package BookMyShow.Theatre;

import BookMyShow.Enums.SeatType;

public class Seat {
    int id;
    int price;
    int row;
    int col;
    SeatType seatType;

    public Seat(int id, int price, int row, int col, SeatType seatType) {
        this.id = id;
        this.price = price;
        this.row = row;
        this.col = col;
        this.seatType = seatType;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public SeatType getSeatType() {
        return seatType;
    }
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    
}
