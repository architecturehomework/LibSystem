package service.impl;

import dao.AdministratorDAO;
import dao.DAOFactory;
import model.Administrator;
import service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService {

    private AdministratorDAO administratorDAO;
    private static AdministratorServiceImpl administratorService = new AdministratorServiceImpl();
    public static AdministratorServiceImpl getInstance() {
        return administratorService;
    }

    private AdministratorServiceImpl() {
        administratorDAO = DAOFactory.getAdministratorDAO();
    }

    @Override
    public Administrator getAdministrator(String id) {
        return administratorDAO.getAdministrator(id);
    }

    @Override
    public Administrator login(String id, String password) {
        Administrator administrator = administratorDAO.getAdministrator(id);
        if (administrator == null || !administrator.getPassword().equals(password)) {
            return null;
        }
        return administrator;
    }
}
