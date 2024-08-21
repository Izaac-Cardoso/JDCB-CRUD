package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/employee";
    private static final String password = "admim";
    private static final String user = "root";

    private static Connection connect = null;

    public static Connection connect() {
        if(connect == null) {
            try {
                connect = DriverManager.getConnection(url, user, password);
            }

            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public static void closeConnection() {
        if(connect != null) {
            try {
                connect.close();
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
