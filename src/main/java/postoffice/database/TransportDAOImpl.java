package postoffice.database;

import postoffice.Transport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransportDAOImpl extends DBManager implements  TransportDAO{
    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transportList = new ArrayList<>();
        Connection connection = getConnection();
        try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from postoffice3.transport");

            while (rs.next()) {
                Transport transport = new Transport(rs.getInt(1),rs.getString(2),rs.getInt(3));
                transportList.add(transport);
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return transportList;
    }

    @Override
    public Transport getTransportById(int id) {
    Transport transport = null;
        Connection connection = getConnection();
    try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.transport " +
                    " WHERE idTransport = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            transport = new Transport(rs.getInt(1), rs.getString(2),rs.getInt(3));

            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return transport;
    }

    @Override
    public void save(Transport transport) {
    try{
        Connection connection = getConnection();
        String sql = "INSERT INTO postoffice3.transport (idTransport, type, idPostitem) values (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, transport.getId());
        statement.setString(2,transport.getType());
        statement.setInt(5, transport.getIdPostitem());
        statement.execute();
        connection.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }
}
