package kalyan.design.vending;

import java.util.List;

public class ItemSelf {
    List<Item> items;
    boolean atRoomTemperature;
    boolean organic = false;

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isAtRoomTemperature() {
        return atRoomTemperature;
    }

    public void setAtRoomTemperature(boolean atRoomTemperature) {
        this.atRoomTemperature = atRoomTemperature;
    }
}
