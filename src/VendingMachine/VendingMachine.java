package VendingMachine;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.Coin.Coin;
import VendingMachine.Items.Inventory;
import VendingMachine.Items.Item;
import VendingMachine.State.IdleState;
import VendingMachine.State.State;

public class VendingMachine {

    State state;
    Inventory inventory;
    List<Coin> coins;
    Item choosenItem;

    public VendingMachine() {
        state = new IdleState();
        inventory = new Inventory();
        coins = new ArrayList<>();
        choosenItem = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }
     
    public void addCoind(Coin coin) {
        coins.add(coin);
    }

    public Item getChoosenItem() {
        return choosenItem;
    }

    public void setChoosenItem(Item choosenItem) {
        this.choosenItem = choosenItem;
    }
    
}
