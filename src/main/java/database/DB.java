package database;

import database.exception.CloseConnectionException;
import database.exception.CloseResultSetException;
import database.exception.CloseStatementException;
import database.exception.ConnectionErrorException;

import java.sql.*;

public class DB {
    private static String url = "jdbc:mysql://localhost:3306/crudsupport";
    private static String user = "root";
    private static String password = "vinijava";

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
            }
        }catch (SQLException e) {
            throw new ConnectionErrorException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new CloseConnectionException(e.getMessage());
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new CloseStatementException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new CloseStatementException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new CloseResultSetException(e.getMessage());
            }
        }
    }
}
