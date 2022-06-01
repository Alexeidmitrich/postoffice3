package postoffice.database;

import postoffice.NumberPostoffice;
import postoffice.PostItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostitemDAOImpl extends  DBManager implements PostitemDAO {
    @Override
    public List<PostItem> getAllPostitem() {
        List<PostItem> postItemsList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.postitem");

            while (rs.next()) {
                NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt("id"), rs.getString("city"));
                PostItem postItem = new PostItem(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), numberPostoffice);
                postItemsList.add(postItem);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postItemsList;
    }


    @Override
    public PostItem getPostitemById(int id) {
        PostItem postItem = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.postitem " +
                    " WHERE sendersid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt("id"), rs.getString("city"));
            postItem = new PostItem(rs.getInt(1), rs.getDate(2), rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), numberPostoffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postItem;
    }

    @Override
    public void save(PostItem postItem, int postofficeId) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO postoffice3.postitem (idPostitem,departureDate, arrivalDate,weight,price,idRecipient, idSender, typePostitemId,numberPostoffice) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postItem.getIdPostItem());
            statement.setDate(2, postItem.getDepartureDate());
            statement.setDate(3, postItem.getArrivalDate());
            statement.setInt(4,postItem.getWeight());
            statement.setInt(5, postItem.getPrice());
            statement.setInt(6,postItem.getIdRecipient());
            statement.setInt(7, postItem.getIdSender());
            statement.setInt(8, postItem.getTypePostitemId());
            statement.setObject(9, postItem.getNumberPostoffice());
            statement.setInt(10, postofficeId);
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
