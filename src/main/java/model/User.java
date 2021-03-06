package model;

import model.Strategy.Strategy;

import static util.ErrorCode.NoPriority;

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
    protected String priority;

    public User() {

    }

    public User(User user) {
        this.id = user.id;
        this.password = user.password;
        this.name = user.name;
        this.type = user.type;
        this.mail = user.mail;
        this.phone = user.phone;
        this.school = user.school;
        this.department = user.department;
        this.money = user.money;
        this.strategy = user.strategy;
        this.priority = user.priority;
    }

    public int borrow(Literature literature) {
        return strategy.borrow(literature, this);
    }

    public int returnBook(Literature literature) {
        return strategy.returnBook(literature, this);
    }

    public User searchUser(String uid) {
        return null;
    }

    public int addUser(User user) {
        return NoPriority;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
