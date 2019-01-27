package dao.impl;

import dao.AdministratorDAO;
import model.Administrator;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDAOImpl implements AdministratorDAO {

    private static AdministratorDAOImpl administratorDAO = new AdministratorDAOImpl();
    public static AdministratorDAOImpl getInstance() {
        return administratorDAO;
    }

    @Override
    public Administrator getAdministrator(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Administrator administrator = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from administrators where id=?");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                administrator = new Administrator();
                administrator.setId(id);
                administrator.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return administrator;
    }
}
