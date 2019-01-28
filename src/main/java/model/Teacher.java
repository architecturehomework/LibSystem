package model;

import model.Strategy.ConcreteStrategy.TeacherStrategy;
import static util.ErrorCode.NoPriority;

public class Teacher extends User {

    public Teacher() {
        type = "教师";
        strategy = new TeacherStrategy();
    }

    public Teacher(User user) {
        super(user);
        strategy = new TeacherStrategy();
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
