package kalyan.design.vending;

import kalyan.design.vending.state.State;

import java.util.List;

public class VendingMachine {
    Inventory inventory;
    State state;
    List<Coin> coinsList;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public State getState() {
        return state;
    }

    public List<Coin> getCoinsList() {
        return coinsList;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCoinsList(List<Coin> coinsList) {
        this.coinsList = coinsList;
    }
}
