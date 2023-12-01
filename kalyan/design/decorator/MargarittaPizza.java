package kalyan.design.decorator;

public class MargarittaPizza extends BasePizza{

    public int cost() {
        return  super.cost() + 60;
    }
}
