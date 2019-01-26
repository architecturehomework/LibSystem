package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

public class GraduateStrategy implements Strategy {

    //研究生可借专业书籍30本，其他书籍20本，期限3月
    private final int majorLimit = 30;
    private final int otherLimit = 20;
    private final int timeLimit = 3;

    @Override
    public boolean borrow(Literature literature, User user) {
        return false;
    }
}
