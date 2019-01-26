package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

public class GraduateStrategy implements Strategy {
    @Override
    public boolean borrow(Literature literature, User user) {
        return false;
    }
}
