package service.impl;

import dao.DAOFactory;
import dao.UserDAO;
import model.User;
import service.UserService;

import static util.ErrorCode.WrongInput;
import static util.PriorityChar.*;

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

    @Override
    public int grantPriority(String id, char priority) {
        User user = getUser(id);
        if (user == null) {
            return 0;
        }
        switch (priority) {
            case NoPriority:
                user.setPriority(String.valueOf(NoPriority));
                break;
            case AddAllPriority:
            case AddSchoolPriority:
            case SearchAllPriority:
            case SearchSchoolPriority:
                user.setPriority(user.getPriority() + priority);
                break;
            default:
                System.out.println("错误输入");
                return WrongInput;
        }
        return updateUser(user);
    }

    @Override
    public int removePriority(String id, char priority) {
        User user = getUser(id);
        if (user == null) {
            return 0;
        }
        switch (priority) {
            case AddAllPriority:
            case AddSchoolPriority:
            case SearchAllPriority:
            case SearchSchoolPriority:
                user.setPriority(user.getPriority().replace(priority, NoPriority));
                break;
            default:
                System.out.println("错误输入");
                return WrongInput;
        }
        return updateUser(user);
    }
}
