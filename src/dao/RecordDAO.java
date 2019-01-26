package dao;

import model.Record;

public interface RecordDAO {

    public int addRecord(Record record);

    public int updateRecord(Record record);

    public int getRecord(String rid);
}
