package model;

import model.Strategy.ConcreteStrategy.GraduateStrategy;

public class Graduate extends User {
    public Graduate() {
        type = "研究生";
        strategy = new GraduateStrategy();
    }

    public Graduate(User user) {
        super(user);
        strategy = new GraduateStrategy();
    }
}
