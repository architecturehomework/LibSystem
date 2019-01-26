package model;

import model.Strategy.ConcreteStrategy.NoStrategy;

public class Administrator extends User {

    public Administrator() {
        type = "系统管理员";
        strategy = new NoStrategy();
    }
}
