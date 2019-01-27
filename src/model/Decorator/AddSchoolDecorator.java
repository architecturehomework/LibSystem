package model.Decorator;

import model.Literature;
import model.User;
import service.ServiceFactory;

import static util.ErrorCode.NoPriority;

public class AddSchoolDecorator extends User{
    User user;

    public AddSchoolDecorator(User user) {
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
        if (user.getSchool().equals(this.user.getSchool())) {
            return ServiceFactory.getUserService().addUser(user);
        }
        return NoPriority;
    }

    public User searchUser(String uid) {
        return user.searchUser(uid);
    }
}
