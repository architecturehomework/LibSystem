package model.Strategy;

import model.Literature;
import model.User;

public interface Strategy {

    public int borrow(Literature literature, User user);

    public int returnBook(Literature literature, User user);
}
