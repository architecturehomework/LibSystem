package dao.impl;

import dao.RecordDAO;
import model.Record;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordDAOImpl implements RecordDAO {

    private static RecordDAOImpl recordDAO = new RecordDAOImpl();
    public static RecordDAOImpl getInstance() {
        return recordDAO;
    }

    @Override
    public int addRecord(Record record) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("insert into records values (?, ?, ?, ?, ?);");
            statement.setString(1, record.getUid());
            statement.setString(2, record.getLid());
            statement.setTimestamp(3, record.getStartTime());
            statement.setTimestamp(4, record.getEndTime());
            statement.setTimestamp(5, record.getScheduleTime());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public int updateRecord(Record record) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("update records set endTime = ? where uid=? and lid=? and endTime is null ;");
            statement.setTimestamp(1, record.getEndTime());
            statement.setString(2, record.getUid());
            statement.setString(3, record.getLid());
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return result;
    }

    @Override
    public Record getLastRecord(String uid, String lid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Record record = null;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from records where uid = ? and lid = ? and endTime is null;");
            statement.setString(1, uid);
            statement.setString(2, lid);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                record = new Record();
                record.setUid(uid);
                record.setLid(lid);
                record.setStartTime(resultSet.getTimestamp("startTime"));
                record.setEndTime(resultSet.getTimestamp("endTime"));
                record.setScheduleTime(resultSet.getTimestamp("scheduleTime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return record;
    }

    @Override
    public ArrayList<Record> getAllRecord() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Record> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from records;");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Record record = new Record();
                record.setUid(resultSet.getString("uid"));
                record.setLid(resultSet.getString("lid"));
                record.setStartTime(resultSet.getTimestamp("startTime"));
                record.setEndTime(resultSet.getTimestamp("endTime"));
                record.setScheduleTime(resultSet.getTimestamp("scheduleTime"));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public ArrayList<Record> getRecordByUid(String uid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Record> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from records where uid=?;");
            statement.setString(1, uid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Record record = new Record();
                record.setUid(resultSet.getString("uid"));
                record.setLid(resultSet.getString("lid"));
                record.setStartTime(resultSet.getTimestamp("startTime"));
                record.setEndTime(resultSet.getTimestamp("endTime"));
                record.setScheduleTime(resultSet.getTimestamp("scheduleTime"));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public ArrayList<Record> getNRRecordByUid(String uid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Record> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select * from records where uid=? and endTime is null;");
            statement.setString(1, uid);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Record record = new Record();
                record.setUid(resultSet.getString("uid"));
                record.setLid(resultSet.getString("lid"));
                record.setStartTime(resultSet.getTimestamp("startTime"));
                record.setEndTime(resultSet.getTimestamp("endTime"));
                record.setScheduleTime(resultSet.getTimestamp("scheduleTime"));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

    @Override
    public int getNRNumByLid(String lid) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int result = 0;
        try {
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement("select count(*) as num from records where lid=? and endTime is null;");
            statement.setString(1, lid);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = resultSet.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return result;
    }
}
