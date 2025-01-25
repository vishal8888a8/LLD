package VendingMachine.State;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.Coin.Coin;
import VendingMachine.Items.Item;

public class DispenseState implements State {

    public DispenseState() {
        System.out.println("Vending machine is in dispense state");
    }

    @Override
    public void clickOnInsertCashButton(VendingMachine VendingMachine) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public void insertCoinInTheSlot(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public void clickOnProductSelectionButon(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public void insertCodeInTheSlot(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public List<Coin> clickOnCancelButon(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public Item dispense(VendingMachine vendingMachine) throws Exception {
        Item item = vendingMachine.getChoosenItem();
        vendingMachine.setChoosenItem(null);
        vendingMachine.setState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setCoins(new ArrayList<>());
        return coins;
    }
    
}
