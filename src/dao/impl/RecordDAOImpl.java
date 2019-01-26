package dao.impl;

import dao.RecordDAO;
import model.Record;

import java.util.ArrayList;

public class RecordDAOImpl implements RecordDAO {
    @Override
    public int addRecord(Record record) {
        return 0;
    }

    @Override
    public int updateRecord(Record record) {
        return 0;
    }

    @Override
    public Record getRecord(String uid, String lid) {
        return null;
    }

    @Override
    public ArrayList<Record> getRecordByUid(String uid) {
        return null;
    }
}
