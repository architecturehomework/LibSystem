package dao;

import model.Record;

import java.util.ArrayList;

public interface RecordDAO {

    public int addRecord(Record record);

    public int updateRecord(Record record);

    public Record getLastRecord(String uid, String lid);

    public ArrayList<Record> getAllRecord();

    public ArrayList<Record> getRecordByUid(String uid);

    public ArrayList<Record> getNRRecordByUid(String uid);

    public int getNRNumByLid(String lid);
}
