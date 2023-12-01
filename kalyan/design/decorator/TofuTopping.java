package kalyan.design.decorator;

public class TofuTopping extends ToppingPizza{
    public TofuTopping(BasePizza basePizza) {
        super(basePizza);
    }
    public int cost(){
        return this.basePizza.cost() + 120;
    }
}
