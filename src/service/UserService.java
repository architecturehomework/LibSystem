package service;

import model.User;

public interface UserService {

    public int addUser(User user);

    public int updateUser(User user);

    public User getUser(String id);

    public User login(String id, String password);

}
