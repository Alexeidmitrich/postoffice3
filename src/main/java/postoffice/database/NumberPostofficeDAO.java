package postoffice.database;

import postoffice.NumberPostoffice;

import java.util.List;

public interface NumberPostofficeDAO {


    List<NumberPostoffice> getAllNumberPostoffice();

    NumberPostoffice getNumberPostofficeById(int id);

    void save(NumberPostoffice numberPostoffice);
}
