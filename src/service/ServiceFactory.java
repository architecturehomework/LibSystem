package service;

import service.impl.AdministratorServiceImpl;
import service.impl.LiteratureServiceImpl;
import service.impl.RecordServiceImpl;
import service.impl.UserServiceImpl;

public class ServiceFactory {

    public static AdministratorService getAdministratorService() {
        return AdministratorServiceImpl.getInstance();
    }

    public static LiteratureService getLiteratureService() {
        return LiteratureServiceImpl.getInstance();
    }

    public static RecordService getRecordService() {
        return RecordServiceImpl.getInstance();
    }

    public static UserService getUserService() {
        return UserServiceImpl.getInstance();
    }
}
