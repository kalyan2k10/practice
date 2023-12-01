package kalyan.design.vending.state;

public interface State {
    public void display();
    default public void rollback(){ System.out.println("Default rollback"); }
    default public int getInput() { return -1;}
    default public void processInput() {System.out.println("Default process input");};
    default public void acceptCoins() {System.out.println("Default accept coins");};
}
