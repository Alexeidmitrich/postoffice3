package postoffice.database;

import postoffice.TypePostItem;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class TypePostItemDAOImpl extends DBManager  implements TypePostItemDAO{
    @Override
    public TypePostItem getTypeByName(String type) {
            TypePostItem typePostItem = null;
            Connection connection = getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("SELECT * from postoffice3.typepostitem " +
                        " WHERE type = ?");
                statement.setString(1, type);
               // Statement statement = connection.createStatement();
               // ResultSet rs = statement.executeQuery( "SELECT * from postoffice3.typepostitem WHERE type = '" + type + "'");
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

    public static void main(String[] args) {
        TypePostItemDAO dao = new TypePostItemDAOImpl();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        TypePostItem type = dao.getTypeByName(text);
        if (type != null) {
            System.out.println(type.getId() + " " + type.getTypeName());
        }
    }
}
