package model.Decorator;

import model.Literature;
import model.User;
import service.ServiceFactory;
import service.UserService;

public class SearchAllDecorator extends User {
    User user;

    public SearchAllDecorator(User user) {
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
        return this.user.addUser(user);
    }

    public User searchUser(String uid) {
        return ServiceFactory.getUserService().getUser(uid);
    }
}
