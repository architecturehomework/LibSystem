package service.impl;

import dao.DAOFactory;
import dao.UserDAO;
import model.Decorator.*;
import model.Graduate;
import model.Teacher;
import model.Undergraduate;
import model.User;
import service.UserService;

import java.util.ArrayList;

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
    public ArrayList<User> getAllUser() {
        return userDAO.getAllUser();
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

    @Override
    public Decorator getPriorityUser(String id) {
        User user = getUser(id);
        if (user == null) {
            return null;
        }
        switch (user.getType()) {
            case "本科生":
                user = new Undergraduate(user);
                break;
            case "研究生":
                user = new Graduate(user);
                break;
            case "教师":
                user = new Teacher(user);
                break;
            default:
                return null;
        }



        if (user.getPriority().equals(String.valueOf(NoPriority))) {
            return new NoPriorityDecorator(user);
        }
        Decorator decorator = new NoPriorityDecorator(user);
        if (user.getPriority().contains(String.valueOf(AddSchoolPriority))) {
            decorator = new AddSchoolDecorator(decorator);
        }
        System.out.println(user);
        if (user.getPriority().contains(String.valueOf(AddAllPriority))) {
            decorator = new AddAllDecorator(decorator);
        }
        if (user.getPriority().contains(String.valueOf(SearchSchoolPriority))) {
            decorator = new SearchSchoolDecorator(decorator);
        }
        if (user.getPriority().contains(String.valueOf(SearchAllPriority))) {
            decorator = new SearchAllDecorator(decorator);
        }
        return decorator;
    }
}
