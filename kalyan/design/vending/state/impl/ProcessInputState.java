package kalyan.design.vending.state.impl;

import kalyan.design.vending.Inventory;
import kalyan.design.vending.ItemSelf;
import kalyan.design.vending.ItemType;
import kalyan.design.vending.VendingMachine;
import kalyan.design.vending.state.FilterStrategy;
import kalyan.design.vending.state.State;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class ProcessInputState implements State {
    VendingMachine vendingMachine;
    String requiredItemType;
    int qty;
    List<FilterStrategy> filterStrategy;

    public List<FilterStrategy> getFilterStrategy() {
        return filterStrategy;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public String getRequiredItemType() {
        return requiredItemType;
    }

    public void setRequiredItemType(String requiredItemType) {
        this.requiredItemType = requiredItemType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public ProcessInputState(String type, int qty, VendingMachine vendingMachine, List<FilterStrategy> fs) {
        this.requiredItemType = type;
        this.qty = qty;
        this.display();
        this.setVendingMachine(vendingMachine);
        this.filterStrategy = fs;
        this.processInput();
    }

    @Override
    public void display() {
        System.out.println("User given input is " + requiredItemType + " and quantity is " + qty);
    }

    @Override
    public void processInput() {
        boolean isValidItem = Arrays.stream(ItemType.values()).anyMatch(item -> item.name().equals(requiredItemType));
        if(isValidItem) {
            System.out.println("Checking if we have the quantity requested as per your preference");
            long availableQty = getAvailableQty(this.vendingMachine.getInventory(), this.getRequiredItemType());
            if(availableQty >= this.getQty()){
                System.out.println("We have sufficient quantity and hence proceeding");
                vendingMachine.setState(new AcceptCoinsState(vendingMachine));
            } else {
                System.out.println("++++++++++Insufficient Quantity+++++++++++++++");
                vendingMachine.setState(new WaitForInputState(vendingMachine,filterStrategy));
            }
        } else {
            System.out.println("++++++++++INVALID INPUT+++++++++++++++");
            vendingMachine.setState(new WaitForInputState(vendingMachine,filterStrategy));
        }

    }

    private long getAvailableQty(Inventory inventory, String requiredItemType) {
        Predicate combinedPredicate = this.filterStrategy.stream().map(FilterStrategy::getFilter).
                reduce(Predicate::and)
                .orElse(s -> true);
        List<ItemSelf> itemSelfList = inventory.getItemShelfList().stream().filter(combinedPredicate).toList();
        long availableQty =0;
        for(ItemSelf itemSelf : itemSelfList) {
            long count = itemSelf.getItems().stream().filter(item -> item.getType().toString().equals(requiredItemType)).count();
            availableQty += count;
        }
        System.out.println(requiredItemType +" has quantity " + availableQty);
        return availableQty;
    }
}
