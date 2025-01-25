package VendingMachine.Items;

public class ItemShelf {
    Item item;
    int code;
    int quantity;
    public ItemShelf(Item item, int code, int quantity) {
        this.item = item;
        this.code = code;
        this.quantity = quantity;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
