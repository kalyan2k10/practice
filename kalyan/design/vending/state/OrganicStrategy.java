package kalyan.design.vending.state;

import kalyan.design.vending.ItemSelf;

import java.util.function.Predicate;

public class OrganicStrategy implements FilterStrategy {
    @Override
    public Predicate getFilter() {
        Predicate<ItemSelf> isOrganic = ItemSelf::isOrganic;
        return isOrganic;
    }
}
