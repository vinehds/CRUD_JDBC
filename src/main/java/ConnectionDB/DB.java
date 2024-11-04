package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB{
    private static String url = "jdbc:mysql://localhost:3306/crudsupport";
    private static String user = "root";
    private static String password = "vinijava";


    private static Connection conn = null;

    private static Connection getConnection(){
        if(conn == null){
            try {
                DriverManager.getConnection(url, user, password);
                return conn;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{ return conn; }
    }
}
