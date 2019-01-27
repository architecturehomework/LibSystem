package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

import static util.ErrorCode.CantBorrow;

public class NoStrategy implements Strategy {
    @Override
    public int borrow(Literature literature, User user) {
        return CantBorrow;
    }

    @Override
    public int returnBook(Literature literature, User user) {
        return CantBorrow;
    }
}
