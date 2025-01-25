package VendingMachine;

import java.util.List;

import VendingMachine.Coin.Coin;
import VendingMachine.Items.Inventory;
import VendingMachine.Items.Item;
import VendingMachine.Items.ItemShelf;

public class Main {
    public static void main(String[] args) {

        try {
            //Initializing our vending machine
            VendingMachine vendingMachine = new VendingMachine();

            //stocking up our vending machine
            stockUpThevendingMachine(vendingMachine);

            //Insert cash money
            vendingMachine.getState().clickOnInsertCashButton(vendingMachine);

            //Inset coins
            vendingMachine.getState().insertCoinInTheSlot(vendingMachine, Coin.TEN_RUPEE);
            vendingMachine.getState().insertCoinInTheSlot(vendingMachine, Coin.FIVE_RUPEE);

            //tap select product button
            vendingMachine.getState().clickOnProductSelectionButon(vendingMachine);

            //enter our product code
            vendingMachine.getState().insertCodeInTheSlot(vendingMachine, 102);

            //get our changes
            List<Coin> coins = vendingMachine.getState().getChange(vendingMachine);

            //dispense the product
            Item item = vendingMachine.getState().dispense(vendingMachine);

            //print out money and item
            System.out.print(item.getName()+"\n");
            for ( Coin coin: coins)
                System.out.println(coin.val);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static void stockUpThevendingMachine(VendingMachine vendingMachine) {
        Inventory inventory = new Inventory();
        ItemShelf itemShelf1 = new ItemShelf(new Item(0,"coke", 20), 100, 2);
        ItemShelf itemShelf2 = new ItemShelf(new Item(1,"pepsi", 10), 101, 1);
        ItemShelf itemShelf3 = new ItemShelf(new Item(2,"fiji water", 5), 102, 2);
        inventory.addItemShelf(itemShelf1);
        inventory.addItemShelf(itemShelf2);
        inventory.addItemShelf(itemShelf3);
        vendingMachine.setInventory(inventory);
    }
}
