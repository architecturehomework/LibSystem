package service;

import model.Administrator;

public interface AdministratorService {

    public Administrator getAdministrator(String id);

    public Administrator login(String id, String password);
}
