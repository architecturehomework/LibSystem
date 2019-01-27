package model.Decorator;

import model.Literature;
import model.User;
import service.ServiceFactory;

public class AddAllDecorator extends User {
    User user;

    public AddAllDecorator(User user) {
        this.user = user;
    }

    public int borrow(Literature literature) {
        return user.borrow(literature);
    }

    public int returnBook(Literature literature) {
        return user.returnBook(literature);
    }

    @Override
    public int addUser(User user) {
        return ServiceFactory.getUserService().addUser(user);
    }

    public User searchUser(String uid) {
        return user.searchUser(uid);
    }
}
