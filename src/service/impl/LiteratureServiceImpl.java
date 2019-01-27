package service.impl;

import dao.DAOFactory;
import dao.LiteratureDAO;
import model.Literature;
import service.LiteratureService;

import java.util.ArrayList;

public class LiteratureServiceImpl implements LiteratureService {

    private LiteratureDAO literatureDAO;
    private static LiteratureServiceImpl literatureService = new LiteratureServiceImpl();
    public static LiteratureServiceImpl getInstance() {
        return literatureService;
    }
    private LiteratureServiceImpl() {
        literatureDAO = DAOFactory.getLiteratureDAO();
    }
    @Override
    public int addLiterature(Literature literature) {
        return literatureDAO.addLiterature(literature);
    }

    @Override
    public int updateLiterature(Literature literature) {
        return literatureDAO.updateLiterature(literature);
    }

    @Override
    public Literature getLiterature(String id) {
        return literatureDAO.getLiterature(id);
    }

    @Override
    public ArrayList<Literature> getAllLiterature() {
        return literatureDAO.getAllLiterature();
    }

    @Override
    public ArrayList<Literature> getLiteratureByCategory(String category) {
        return literatureDAO.getLiteratureByCategory(category);
    }
}
