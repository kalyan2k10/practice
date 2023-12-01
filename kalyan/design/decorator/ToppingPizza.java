package kalyan.design.decorator;

public class ToppingPizza extends BasePizza{
    BasePizza basePizza;
    public ToppingPizza(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}
