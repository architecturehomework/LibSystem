package service.impl;

import dao.DAOFactory;
import dao.UserDAO;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;
    private static UserServiceImpl userService = new UserServiceImpl();
    public static UserServiceImpl getInstance() {
        return userService;
    }
    private UserServiceImpl() {
        userDAO = DAOFactory.getUserDAO();
    }
    @Override
    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDAO.update(user);
    }

    @Override
    public User getUser(String id) {
        return userDAO.getUser(id);
    }

    @Override
    public User login(String id, String password) {
        User user = userDAO.getUser(id);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }
}
