package dao.impl;

import dao.LiteratureDAO;
import model.Literature;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LiteratureDAOImpl implements LiteratureDAO {

    private static LiteratureDAOImpl literatureDAO = new LiteratureDAOImpl();

    public static LiteratureDAOImpl getInstance() {
        return literatureDAO;
    }

    @Override
    public int addLiterature(Literature literature) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("insert into literature values (?, ?, ?, ?, ?, ?, ?);");
            statement.setString(1, literature.getId());
            statement.setString(2, literature.getName());
            statement.setString(3, literature.getAuthor());
            statement.setString(4, literature.getCategory());
            statement.setString(5, literature.getDescription());
            statement.setString(6, literature.getPath());
            statement.setInt(7, literature.getNum());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public int updateLiterature(Literature literature) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("update literature set name=?, author=?, category=?, description=?, path=?, num=? where id=?;");
            statement.setString(1, literature.getName());
            statement.setString(2, literature.getAuthor());
            statement.setString(3, literature.getCategory());
            statement.setString(4, literature.getDescription());
            statement.setString(5, literature.getPath());
            statement.setInt(6, literature.getNum());
            statement.setString(7, literature.getId());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public Literature getLiterature(String id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Literature literature = new Literature();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from literature where id = ?;");
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                literature.setId(id);
                literature.setName(resultSet.getString("name"));
                literature.setAuthor(resultSet.getString("author"));
                literature.setDescription(resultSet.getString("description"));
                literature.setCategory(resultSet.getString("category"));
                literature.setPath(resultSet.getString("path"));
                literature.setNum(resultSet.getInt("num"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return literature;
    }

    @Override
    public ArrayList<Literature> getAllLiterature() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Literature> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from literature;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Literature literature = new Literature();
                literature.setId(resultSet.getString("id"));
                literature.setName(resultSet.getString("name"));
                literature.setAuthor(resultSet.getString("author"));
                literature.setDescription(resultSet.getString("description"));
                literature.setCategory(resultSet.getString("category"));
                literature.setPath(resultSet.getString("path"));
                literature.setNum(resultSet.getInt("num"));
                list.add(literature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public ArrayList<Literature> getLiteratureByCategory(String category) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Literature> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from literature where category = ?;");
            statement.setString(1, category);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Literature literature = new Literature();
                literature.setId(resultSet.getString("id"));
                literature.setName(resultSet.getString("name"));
                literature.setAuthor(resultSet.getString("author"));
                literature.setDescription(resultSet.getString("description"));
                literature.setCategory(resultSet.getString("category"));
                literature.setPath(resultSet.getString("path"));
                literature.setNum(resultSet.getInt("num"));
                list.add(literature);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }
}
