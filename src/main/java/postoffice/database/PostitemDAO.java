package postoffice.database;

import postoffice.PostItem;
import java.util.List;

public interface PostitemDAO {

    List<PostItem> getAllPostitem();


    PostItem getPostitemById(int id);

    PostItem getPostItemInfo(int typePostitem_id);

    PostItem getPostItemByLastname(String firstname, String lastname);


    void save(PostItem postItem, int postofficeId);
}
