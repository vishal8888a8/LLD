package VendingMachine.Coin;

public enum Coin {

    ONE_RUPEE(1),
    TWO_RUPEE(2),
    FIVE_RUPEE(5),
    TEN_RUPEE(10);

    public int val;

    Coin(int val) {
        this.val = val;
    }
}
