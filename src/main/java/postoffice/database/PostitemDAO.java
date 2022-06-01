package postoffice.database;

import postoffice.PostItem;
import java.util.List;

public interface PostitemDAO {

    List<PostItem> getAllPostitem();


    PostItem getPostitemById(int id);


    void save(PostItem postItem, int postofficeId);
}
