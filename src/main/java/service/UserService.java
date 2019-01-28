package service;

import model.Decorator.Decorator;
import model.User;

import java.util.ArrayList;

public interface UserService {

    public int addUser(User user);

    public int updateUser(User user);

    public User getUser(String id);

    public ArrayList<User> getAllUser();

    public User login(String id, String password);

    public int grantPriority(String id, char priority);

    public int removePriority(String id, char priority);

    public Decorator getPriorityUser(String id);

}
