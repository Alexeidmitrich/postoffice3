package postoffice.database;

import postoffice.TypePostItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypePostItemDAOImpl extends DBManager  implements TypePostItemDAO{
    @Override
    public TypePostItem getTypeByName(String type) {
            TypePostItem typePostItem = null;
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.typepostitem " +
                        " WHERE type = ?");
                statement.setString(1, type);
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    typePostItem = new TypePostItem(rs.getInt(1), rs.getString(2));

                }
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return typePostItem;
        }

    public void save(TypePostItem typePostItem) {
        try{
            Connection connection = getConnection();
            String sql = "INSERT INTO postoffice3.typepostitem (id, type) values (?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, typePostItem.getId());
            statement.setString(2,typePostItem.getTypeName());
            statement.execute();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
