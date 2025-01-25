package VendingMachine.State;

import java.util.List;

import VendingMachine.VendingMachine;
import VendingMachine.Coin.Coin;
import VendingMachine.Items.Item;

public interface State {

    void clickOnInsertCashButton(VendingMachine VendingMachine) throws Exception;

    void insertCoinInTheSlot(VendingMachine vendingMachine, Coin coin) throws Exception;

    void clickOnProductSelectionButon(VendingMachine vendingMachine) throws Exception;

    void insertCodeInTheSlot(VendingMachine vendingMachine, int code ) throws Exception;

    List<Coin> clickOnCancelButon(VendingMachine vendingMachine) throws Exception;

    Item dispense(VendingMachine vendingMachine) throws Exception;

    List<Coin> getChange(VendingMachine vendingMachine) throws Exception;
}
