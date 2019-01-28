package model;

import model.Strategy.ConcreteStrategy.GraduateStrategy;
import static util.ErrorCode.NoPriority;

public class Graduate extends User {
    public Graduate() {
        type = "研究生";
        strategy = new GraduateStrategy();
    }

    public Graduate(User user) {
        super(user);
        strategy = new GraduateStrategy();
    }

    @Override
    public User searchUser(String uid) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return NoPriority;
    }
}
