package VendingMachine.State;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.Coin.Coin;
import VendingMachine.Items.Item;

public class MoneyState implements State {

    public MoneyState() {
        System.out.println("Vending machine is in MoneyState state");
    }
    
    @Override
    public void clickOnInsertCashButton(VendingMachine VendingMachine) throws Exception {
        return;
    }

    @Override
    public void insertCoinInTheSlot(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.addCoind(coin);
    } 

    @Override
    public void clickOnProductSelectionButon(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setState(new ProductState());
    }

    @Override
    public void insertCodeInTheSlot(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Operation not supported by this state");
    }

    @Override
    public List<Coin> clickOnCancelButon(VendingMachine vendingMachine) throws Exception {
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setCoins(new ArrayList<>());
        vendingMachine.setState(new IdleState());
        return coins;
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
