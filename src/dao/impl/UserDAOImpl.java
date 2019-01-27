package dao.impl;

import dao.UserDAO;
import model.User;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    private static UserDAOImpl userDAO = new UserDAOImpl();
    public static UserDAOImpl getInstance() {
        return userDAO;
    }

    @Override
    public int addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("insert into users values (?,?,?,?,?,?,?,?,?,?);");
            statement.setString(1, user.getId());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getType());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getSchool());
            statement.setString(8, user.getDepartment());
            statement.setDouble(9, user.getMoney());
            statement.setInt(10, user.getPriority());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public int update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("update users set password=?,mail=?,phone=?,money=?,priority=? where id=?");
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getMail());
            statement.setString(3, user.getPhone());
            statement.setDouble(4, user.getMoney());
            statement.setInt(5, user.getPriority());
            statement.setString(6, user.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public User getUser(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = new User();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from users where id = ?");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setId(id);
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setType(resultSet.getString("type"));
                user.setMail(resultSet.getString("mail"));
                user.setSchool(resultSet.getString("school"));
                user.setDepartment(resultSet.getString("department"));
                user.setMoney(resultSet.getDouble("money"));
                user.setPriority(resultSet.getInt("priority"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return user;
    }
}
