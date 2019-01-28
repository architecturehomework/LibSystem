package model.Decorator;

import model.Literature;
import model.User;

public abstract class Decorator extends User {
    User user;

    public Decorator(User user) {
        super(user);
        this.user = user;
    }

    public int borrow(Literature literature) {
        return user.borrow(literature);
    }

    public int returnBook(Literature literature) {
        return user.returnBook(literature);
    }
    public abstract User searchUser(String uid);
    public abstract int addUser(User user);


}
