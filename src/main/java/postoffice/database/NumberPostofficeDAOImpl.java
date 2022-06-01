package postoffice.database;

import postoffice.Client;
import postoffice.NumberPostoffice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NumberPostofficeDAOImpl extends  DBManager implements NumberPostofficeDAO{
    @Override
    public List<NumberPostoffice> getAllNumberPostoffice() {
        List<NumberPostoffice> numberPostofficeList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.postoffice");
            while (rs.next()) {
                NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt(1),rs.getString(2));
                numberPostofficeList.add(numberPostoffice);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numberPostofficeList;
    }

    @Override
    public NumberPostoffice getNumberPostofficeById(int id) {
        NumberPostoffice numberPostoffice = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.postoffice " +
                    " WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            numberPostoffice = new NumberPostoffice(rs.getInt(1),rs.getString(2));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return numberPostoffice;
    }

    @Override
    public void save(NumberPostoffice numberPostoffice) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO postoffice3.postoffice (id,city) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, numberPostoffice.getId());
            statement.setString(2, numberPostoffice.getCity());
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
