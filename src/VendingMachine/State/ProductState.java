package VendingMachine.State;

import java.util.ArrayList;
import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.Coin.Coin;
import VendingMachine.Items.Item;

public class ProductState implements State{

    public ProductState() {
        System.out.println("Vending machine is in ProductState state");
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
        return;
    }

    @Override
    public void insertCodeInTheSlot(VendingMachine vendingMachine, int code) throws Exception {
        // get item with this code;
        int amount = 0;
        List<Coin> coins = vendingMachine.getCoins();
        for ( Coin coin: coins ) {
            amount += coin.val;
        }
        try{
            Item item = vendingMachine.getInventory().getItemWithCode(code);
            if ( item.getPrice() > amount )
                throw new Exception("Insufficient amount deposited");
            vendingMachine.setChoosenItem(item);
            vendingMachine.setState(new DispenseState());
            vendingMachine.setCoins(convertToCoins(amount-item.getPrice()));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
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
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setCoins(new ArrayList<>());
        return coins;
    }
    
    private List<Coin> convertToCoins(int amount) {
        List<Coin> coins = new ArrayList<>();
        while ( amount >= 10 ) {
            coins.add(Coin.TEN_RUPEE);
            amount -= 10;
        }
        while ( amount >= 5 ) {
            coins.add(Coin.FIVE_RUPEE);
            amount -= 5;
        }
        while ( amount >= 2 ) {
            coins.add(Coin.TWO_RUPEE);
            amount -= 2;
        }
        while ( amount >= 1 ) {
            coins.add(Coin.ONE_RUPEE);
            amount -= 1;
        }
        return coins;
    }
}
