package model;

import model.Strategy.ConcreteStrategy.UndergraduateStrategy;

public class Undergraduate extends User {
    public Undergraduate() {
        type = "本科生";
        strategy = new UndergraduateStrategy();
    }

    public Undergraduate(User user) {
        super(user);
        strategy = new UndergraduateStrategy();
    }
}
