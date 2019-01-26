package model;

import model.Strategy.Strategy;

public class User {
    protected String id;
    protected String password;
    protected String name;
    protected String type;
    protected String mail;
    protected String phone;
    protected String school;
    protected String department;
    protected double money;
    protected Strategy strategy;

    public boolean borrow(Literature literature) {
        return strategy.borrow(literature, this);
    }
}
