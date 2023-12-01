package kalyan.design.decorator;

public class VeggieDelightPizza extends BasePizza{
    @Override
    public int cost() {
        return super.cost() + 50;
    }
}
