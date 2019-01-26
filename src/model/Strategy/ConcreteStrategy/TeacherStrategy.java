package model.Strategy.ConcreteStrategy;

import model.Literature;
import model.Strategy.Strategy;
import model.User;

public class TeacherStrategy implements Strategy {

    //教师可借专业书籍50本，其他书籍30本，期限6月
    private final int majorLimit = 50;
    private final int otherLimit = 30;
    private final int timeLimit = 6;

    @Override
    public boolean borrow(Literature literature, User user) {
        return false;
    }
}
