package dao;

import model.Literature;

import java.util.ArrayList;

public interface LiteratureDAO {

    public int addLiterature(Literature literature);

    public int updateLiterature(Literature literature);

    public Literature getLiterature(String id);

    public ArrayList<Literature> getAllLiterature();

    public ArrayList<Literature> getLiteratureByCategory(String category);
}
