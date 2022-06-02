package postoffice.database;

import postoffice.TypePostItem;

public interface TypePostItemDAO {

    TypePostItem getTypeByName(String type);
    void save(TypePostItem typePostItem);
}
