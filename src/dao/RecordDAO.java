package dao;

import model.Record;

import java.util.ArrayList;

public interface RecordDAO {

    public int addRecord(Record record);

    public int updateRecord(Record record);

    public Record getRecord(String uid, String lid);

    public ArrayList<Record> getRecordByUid(String uid);
}
