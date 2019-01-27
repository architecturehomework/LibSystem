package service.impl;

import dao.DAOFactory;
import dao.RecordDAO;
import model.Record;
import service.RecordService;

import java.util.ArrayList;

public class RecordServiceImpl implements RecordService {

    private RecordDAO recordDAO;
    private static RecordServiceImpl recordService = new RecordServiceImpl();
    public static RecordServiceImpl getInstance() {
        return recordService;
    }
    private RecordServiceImpl() {
        recordDAO = DAOFactory.getRecordDAO();
    }
    @Override
    public int addRecord(Record record) {
        return recordDAO.addRecord(record);
    }

    @Override
    public int updateRecord(Record record) {
        return recordDAO.updateRecord(record);
    }

    @Override
    public Record getLastRecord(String uid, String lid) {
        return recordDAO.getLastRecord(uid, lid);
    }

    @Override
    public ArrayList<Record> getAllRecord() {
        return null;
    }

    @Override
    public ArrayList<Record> getRecordByUid(String uid) {
        return null;
    }

    @Override
    public ArrayList<Record> getNRRecordByUid(String uid) {
        return null;
    }

    @Override
    public int getNRNumByLid(String lid) {
        return 0;
    }
}
