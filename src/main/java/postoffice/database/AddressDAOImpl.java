package postoffice.database;

import postoffice.Address;
import postoffice.NumberPostoffice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl extends DBManager implements  AddressDAO{
    @Override
    public List<Address> getAllAddress() {
        List<Address> addressList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.address");
            while (rs.next()){
                Address address = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getInt(8));
           addressList.add(address);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return addressList;
    }

    @Override
    public Address getAddressById(int id) {
        Address address = null;
        Connection connection = getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.address " +
            " WHERE idAddress = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            address = new Address(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getInt(8));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return address;
    }

    @Override
    public void save(Address address) {
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO postoffice3.address (idAddress,city, street, house, bilding, flat, phone, idClient) values (?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, address.getIdAddress());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setString(4,address.getHouse());
            statement.setString(5, address.getBilding());
            statement.setString(6, address.getFlat());
            statement.setString(7, address.getPhone());
            statement.setInt(8, address.getIdClient());
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
