package kalyan.design.vending.state;

import java.util.function.Predicate;

public interface FilterStrategy {
    public Predicate getFilter();
}
