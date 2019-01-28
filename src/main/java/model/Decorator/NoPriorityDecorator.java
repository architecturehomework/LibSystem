package model.Decorator;

import model.User;

import static util.ErrorCode.NoPriority;

public class NoPriorityDecorator extends Decorator {
    public NoPriorityDecorator(User user) {
        super(user);
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
