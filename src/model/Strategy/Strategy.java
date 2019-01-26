package model.Strategy;

import model.Literature;
import model.User;

public interface Strategy {

    public boolean borrow(Literature literature, User user);
}
