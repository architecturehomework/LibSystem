package model;

import model.Strategy.ConcreteStrategy.TeacherStrategy;

public class Teacher extends User {

    public Teacher() {
        type = "教师";
        strategy = new TeacherStrategy();
    }

    public Teacher(User user) {
        super(user);
        strategy = new TeacherStrategy();
    }
}
