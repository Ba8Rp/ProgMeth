package logic;

public class OrderItem {
    Item item;
    int itemAmount;

    public OrderItem(Item item, int itemAmount) {
        this.setItem(item);
        this.setItemAmount(itemAmount);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        if (itemAmount < 0) {
            this.itemAmount = 0;
        } else {
            this.itemAmount = itemAmount;
        }
    }

    public void increaseItemAmount(int amount) {
        if (amount < 0) return;
        this.itemAmount = getItemAmount() + amount;

    }

    public int calculateTotalPrice(){
        int price = item.getPricePerPiece()*getItemAmount();
        return price;
    }

}
