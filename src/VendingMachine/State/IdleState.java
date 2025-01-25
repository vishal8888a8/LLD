package VendingMachine.State;

import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.Coin.Coin;
import VendingMachine.Items.Item;

public class IdleState implements State {

    public IdleState() {
        System.out.println("Vending machine is in IdleState state");
    }
    
    @Override
    public void clickOnInsertCashButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setState(new MoneyState());
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
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public List<Coin> getChange(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Operation not supported by this state");
    }
    
}