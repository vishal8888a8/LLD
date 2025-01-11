package BookMyShow.Payment;

public class Payment {
    int id;
    String bill;

    public Payment(int id, String bill) {
        this.id = id;
        this.bill = bill;
    }
    
    public int getId() {
        return id;
    }
    public String getBill() {
        return bill;
    }
    
}
