package kalyan.design.vending.state.impl;

import kalyan.design.vending.*;
import kalyan.design.vending.state.FilterStrategy;
import kalyan.design.vending.state.OrganicStrategy;
import kalyan.design.vending.state.State;
import kalyan.design.vending.state.TemperatureFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class WaitForInputState implements State {
    VendingMachine vendingMachine;
    List<FilterStrategy> filterStrategyList;

    public List<FilterStrategy> getFilterStrategyList() {
        return filterStrategyList;
    }

    public void setFilterStrategyList(List<FilterStrategy> filterStrategyList) {
        this.filterStrategyList = filterStrategyList;
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public WaitForInputState(VendingMachine vm,List<FilterStrategy> filterStrategyList){
        this.vendingMachine = vm;
        this.filterStrategyList = filterStrategyList;
        this.display();
    }

    public void setVendingMachine(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void display() {
        System.out.println("These are the options available");
        displayAvailableItems();
    }

    private void displayAvailableItems() {
        Inventory inventory = this.getVendingMachine().getInventory();
        System.out.println("Items at room temperature");
        Predicate<ItemSelf> atRoomTemp = ItemSelf::isAtRoomTemperature;
        inventory.getItemShelfList().stream().filter(atRoomTemp).forEach(
                itemSelf -> {
                    Arrays.stream(ItemType.values()).forEach(type -> {
                        long count = itemSelf.getItems().stream().filter( item -> item.getType().equals(type)).count();
                        System.out.println(type +" has quantity " + count);
                    });
                }
        );
        System.out.println("Items at cool temperature");
        inventory.getItemShelfList().stream().filter(atRoomTemp.negate()).forEach(
                itemSelf -> {
                    Arrays.stream(ItemType.values()).forEach(type -> {
                        long count = itemSelf.getItems().stream().filter( item -> item.getType().equals(type)).count();
                        System.out.println(type +" has quantity " + count);
                    });
                }
        );
        System.out.println("Enter the item type and quantity.");
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int qty = sc.nextInt();
        this.vendingMachine.setState(new ProcessInputState(type,qty,this.getVendingMachine(), filterStrategyList));
    }
}
