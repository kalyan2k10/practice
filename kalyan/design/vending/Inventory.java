package kalyan.design.vending;

import java.util.List;

public class Inventory {
    public List<ItemSelf> getItemShelfList() {
        return itemShelfList;
    }

    public void setItemShelfList(List<ItemSelf> itemShelfList) {
        this.itemShelfList = itemShelfList;
    }

    List<ItemSelf> itemShelfList;
}
