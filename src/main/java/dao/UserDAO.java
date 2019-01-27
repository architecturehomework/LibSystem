package dao;

import model.User;

public interface UserDAO {

    public int addUser(User user);

    public int update(User user);

    public User getUser(String id);
}
