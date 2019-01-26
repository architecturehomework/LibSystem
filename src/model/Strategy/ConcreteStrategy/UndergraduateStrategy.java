package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

public class UndergraduateStrategy implements Strategy {

    //本科生可借专业书籍20本，其他书籍10本，期限2月
    private final int majorLimit = 20;
    private final int otherLimit = 10;
    private final int timeLimit = 2;

    @Override
    public boolean borrow(Literature literature, User user) {
        return false;
    }
}
