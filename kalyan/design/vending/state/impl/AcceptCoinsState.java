package kalyan.design.vending.state.impl;

import kalyan.design.vending.VendingMachine;
import kalyan.design.vending.state.State;

public class AcceptCoinsState implements State {
    VendingMachine vendingMachine;
    public AcceptCoinsState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        display();
    }

    @Override
    public void display() {
        System.out.println("Please give us your coins");

    }
}
