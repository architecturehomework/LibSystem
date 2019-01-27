package model.Decorator;

import model.Literature;
import model.User;
import service.ServiceFactory;

public class SearchSchoolDecorator extends User{
    User user;

    public SearchSchoolDecorator(User user) {
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
        User u = ServiceFactory.getUserService().getUser(uid);
        if (u.getSchool().equals(user.getDepartment())) {
            return u;
        }
        return null;
    }
}
