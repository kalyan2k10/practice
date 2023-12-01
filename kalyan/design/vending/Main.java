package kalyan.design.vending;

import kalyan.design.vending.state.FilterStrategy;
import kalyan.design.vending.state.OrganicStrategy;
import kalyan.design.vending.state.TemperatureFilter;
import kalyan.design.vending.state.impl.WaitForInputState;

import java.util.ArrayList;
import java.util.List;

import static kalyan.design.vending.ItemType.COKE;
import static kalyan.design.vending.ItemType.PEPSI;

public class Main {
    public static void main(String[] args){
        VendingMachine vendingMachine = new VendingMachine();
        populateItems(vendingMachine);

        FilterStrategy organicFilter = new OrganicStrategy();
        List<FilterStrategy> filterStrategyList = new ArrayList<>();
        //filterStrategyList.add(organicFilter);

        WaitForInputState waitForInputState = new WaitForInputState(vendingMachine,filterStrategyList);
        vendingMachine.setState(waitForInputState);
    }

    private static void populateItems(VendingMachine vendingMachine) {
        Inventory inventory = new Inventory();
        List<ItemSelf> itemshelfList = new ArrayList<>();

        ItemSelf roomTempShelf = new ItemSelf();
        List<Item> itemsAtRoomTemp = new ArrayList<>();
        itemsAtRoomTemp.add(new Item(COKE, 10));
        itemsAtRoomTemp.add(new Item(COKE, 10));
        itemsAtRoomTemp.add(new Item(PEPSI, 15));
        itemsAtRoomTemp.add(new Item(PEPSI, 15));
        roomTempShelf.setAtRoomTemperature(true);
        roomTempShelf.setItems(itemsAtRoomTemp);

        ItemSelf coldTempShelf = new ItemSelf();
        List<Item> coldItems = new ArrayList<>();
        coldItems.add(new Item(COKE, 10));
        coldItems.add(new Item(COKE, 10));
        coldItems.add(new Item(COKE, 10));
        coldItems.add(new Item(PEPSI, 15));
        coldItems.add(new Item(PEPSI, 15));
        coldItems.add(new Item(PEPSI, 15));
        coldTempShelf.setAtRoomTemperature(false);
        coldTempShelf.setItems(coldItems);

        ItemSelf organicSelf = new ItemSelf();
        List<Item> organicItems = new ArrayList<>();
        organicItems.add(new Item(COKE, 10));
        organicItems.add(new Item(COKE, 10));
        organicItems.add(new Item(COKE, 10));
        organicItems.add(new Item(PEPSI, 15));
        organicItems.add(new Item(PEPSI, 15));
        organicItems.add(new Item(PEPSI, 15));
        organicSelf.setAtRoomTemperature(true);
        organicSelf.setOrganic(true);
        organicSelf.setItems(organicItems);

        itemshelfList.add(roomTempShelf);
        itemshelfList.add(coldTempShelf);
        itemshelfList.add(organicSelf);

        inventory.setItemShelfList(itemshelfList);
        vendingMachine.setInventory(inventory);
    }
}
