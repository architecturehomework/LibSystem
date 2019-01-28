package dao;

import model.User;

import java.util.ArrayList;

public interface UserDAO {

    public int addUser(User user);

    public int update(User user);

    public User getUser(String id);

    public ArrayList<User> getAllUser();
}
