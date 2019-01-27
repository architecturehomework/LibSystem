package dao;

import dao.impl.AdministratorDAOImpl;
import dao.impl.LiteratureDAOImpl;
import dao.impl.RecordDAOImpl;
import dao.impl.UserDAOImpl;

public class DAOFactory {

    public static AdministratorDAO getAdministratorDAO() {
        return AdministratorDAOImpl.getInstance();
    }

    public static LiteratureDAO getLiteratureDAO() {
        return LiteratureDAOImpl.getInstance();
    }

    public static RecordDAO getRecordDAO() {
        return RecordDAOImpl.getInstance();
    }

    public static UserDAO getUserDAO() {
        return UserDAOImpl.getInstance();
    }
}
