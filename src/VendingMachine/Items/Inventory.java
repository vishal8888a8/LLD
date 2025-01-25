package VendingMachine.Items;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> itemShelfs;

    public Inventory() {
        itemShelfs = new ArrayList<>();
    }

    public List<ItemShelf> getItemShelfs() {
        return itemShelfs;
    }

    public void setItemShelfs(List<ItemShelf> itemShelfs) {
        this.itemShelfs = itemShelfs;
    }

    public void addItemShelf(ItemShelf itemShelf) {
        itemShelfs.add(itemShelf);
    }
    
    public Item getItemWithCode(int code) throws Exception {
        for ( ItemShelf itemShelf: itemShelfs ) {
            if ( itemShelf.getCode() == code ) {
                if ( itemShelf.getQuantity() == 0 )
                    throw new Exception("The product is out of stock!");
                else {
                    itemShelf.setQuantity(itemShelf.getQuantity()-1);
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Item with the following code doesn't exist!");
    }
}
