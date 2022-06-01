package postoffice.database;

import postoffice.Client;
import postoffice.NumberPostoffice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends DBManager implements ClientDAO{
    @Override
    public List<Client> getAllClient() {
        List<Client> clientList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.client");

            while (rs.next()) {
                NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt("id"), rs.getString("city"));
                Client client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3),numberPostoffice);
                clientList.add(client);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client getClientById(int id) {
        Client client = null;
        Connection connection = getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.client " +
                    " WHERE sendersid = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt("id"), rs.getString("city"));
            client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3), numberPostoffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    @Override
    public Client getClientName(String firstname, String lastname) {
        Client client = null;
        Connection connection = getConnection();
        try {
            String sql = "SELECT idClient, firstname, lastname, id , city from postoffice3.client "+
                    " inner join postoffice3.postoffice on idClient = id  WHERE firstname = ? and lastname = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,firstname);
            statement.setString(2,lastname);
            ResultSet rs = statement.executeQuery();
            rs.next();
            NumberPostoffice numberPostoffice = new NumberPostoffice(rs.getInt("id"), rs.getString("city"));
            client = new Client(rs.getInt(1),rs.getString(2), rs.getString(3),numberPostoffice);

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return client;
    }

    @Override
    public void save(Client client, int postofficeId) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO postoffice3.client (idClient,firstname, lastname,postOfficeid) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, client.getId());
            statement.setString(2, client.getFirstName() );
            statement.setString(3, client.getLastName());
            statement.setInt(4, postofficeId);
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
