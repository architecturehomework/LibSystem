package model;

import model.Strategy.ConcreteStrategy.TeacherStrategy;

public class Teacher extends User {

    public Teacher() {
        type = "教师";
        strategy = new TeacherStrategy();
    }
}
