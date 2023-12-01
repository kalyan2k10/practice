package kalyan.design.vending.state;

import kalyan.design.vending.ItemSelf;

import java.util.function.Predicate;

public class TemperatureFilter implements FilterStrategy{
    @Override
    public Predicate getFilter() {
        Predicate<ItemSelf> room = ItemSelf::isAtRoomTemperature;
        return room;
    }
}
