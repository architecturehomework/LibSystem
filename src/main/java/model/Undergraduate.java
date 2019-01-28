package model;

import model.Strategy.ConcreteStrategy.UndergraduateStrategy;

import static util.ErrorCode.NoPriority;

public class Undergraduate extends User {
    public Undergraduate() {
        type = "本科生";
        strategy = new UndergraduateStrategy();
    }

    public Undergraduate(User user) {
        super(user);
        strategy = new UndergraduateStrategy();
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
