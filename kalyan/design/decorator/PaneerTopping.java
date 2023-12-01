package kalyan.design.decorator;

public class PaneerTopping extends ToppingPizza{
    public PaneerTopping(BasePizza basePizza) {
        super(basePizza);
    }
    public int cost(){
        return this.basePizza.cost() + 90;
    }
}
