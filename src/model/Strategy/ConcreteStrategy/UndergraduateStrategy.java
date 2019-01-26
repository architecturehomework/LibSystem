package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

public class UndergraduateStrategy implements Strategy {
    @Override
    public boolean borrow(Literature literature, User user) {
        return false;
    }
}
