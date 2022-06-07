package postoffice.database;

import postoffice.PostItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostitemDAOImpl extends  DBManager implements PostitemDAO {
    @Override
    public List<PostItem> getAllPostitem() {
        List<PostItem> postItemsList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.postitem");
            while (rs.next()) {
                PostItem postItem = new PostItem(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
                postItemsList.add(postItem);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Что-то пошло не так");
            ex.printStackTrace();
        }
        return postItemsList;
    }


    @Override
    public PostItem getPostitemById(int id) {
        PostItem postItem = null; // try catch with resources
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM postoffice3.postitem " +
                    " WHERE idPostitem = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            postItem = new PostItem(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postItem;
    }

    @Override
    public PostItem getPostItemInfo(int typePostitem_id) {
        PostItem postItem = null;
        Connection connection = getConnection();
        try {
            String sql = "SELECT idPostitem, departureDate, arrivalDate, weight, price, idRecipient, idSender, typePostitem_id, postOffice_id FROM postoffice3.postitem WHERE typePostitem_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,typePostitem_id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            postItem = new PostItem(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postItem;
    }

    @Override
    public PostItem getPostItemByLastname(String firstname, String lastname) {
        PostItem postItem = null;
        Connection connection = getConnection();
        try {
            String sql = "SELECT p.idPostitem, p.departureDate, p.arrivalDate, p.weight, p.price, p.idRecipient, p.idSender, p.typePostitem_id, p.postOffice_id, c.firstname, c.lastname FROM postoffice3.postitem p  inner join postoffice3.client c on p.idPostItem = c.idClient WHERE firstname = ? and lastname = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, firstname);
            statement.setString(2, lastname);
            ResultSet rs = statement.executeQuery();
            rs.next();
            postItem = new PostItem(rs.getInt(1), rs.getDate(2).toLocalDate(), rs.getDate(3).toLocalDate(), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return postItem;
    }

    @Override
    public void save(PostItem postItem, int postofficeId) {
        Connection connection = null;
        try {
            connection  = getConnection();
            String sql = "INSERT INTO postoffice3.postitem (idPostitem,departureDate, arrivalDate,weight,price," +
                    " idRecipient, idSender, typePostitem_id,postOffice_id) VALUES (?,?,?,?,?,?,?," +
                    " (SELECT id FROM postoffice3.typepostitem WHERE type = ?),?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, postItem.getIdPostItem());
            statement.setDate(2, Date.valueOf(postItem.getDepartureDate()));
            statement.setDate(3, Date.valueOf(postItem.getArrivalDate()));
            statement.setInt(4,postItem.getWeight());
            statement.setInt(5, postItem.getPrice());
            statement.setInt(6,postItem.getIdRecipient());
            statement.setInt(7, postItem.getIdSender());
            // statement.setInt(8, postItem.getTypePostitemId());
            statement.setString(8, postItem.getTypePostitem());
            statement.setInt(9, postofficeId);
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
