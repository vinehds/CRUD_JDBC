package model.entities.dao;

import database.DB;
import database.exception.DatabaseOperationException;
import model.entities.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class  UserDao {

    public static List<User> findAll(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        List<User> usersFound = new ArrayList<>();
        String sql = "SELECT * FROM user";

        try {
            conn = DB.getConnection();

            st = conn.createStatement();

            rs = st.executeQuery(sql);


            while(rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String password = rs.getString("password");
                LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();

                User newUser = new User(name,cpf,email,password,dateOfBirth);
                newUser.setId(id);

                usersFound.add(newUser);
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection(conn);
        }
        return usersFound;
    }

    public static User findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE id = ?";

        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String password = rs.getString("password");
                LocalDate dateOfBirth = rs.getDate("dateOfBirth").toLocalDate();

                User userUpdate = new User(name,cpf,email,password,dateOfBirth);
                userUpdate.setId(id);
                return userUpdate;
            } else {
                throw new DatabaseOperationException("User not found");
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        } finally {
            DB.closeResultSet(rs);
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public static int insert(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (name, cpf, email, password, dateOfBirth) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = DB.getConnection();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);



            ps.setString(1, user.getName());
            ps.setString(2, user.getCpf());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setDate(5, java.sql.Date.valueOf(user.getDateOfBirth()));

            int id = 0;
            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();

                while (rs.next()) {
                    id = rs.getInt(1);
                }
            }
            return id;
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public static int update(User updatedUser, int userId){
        Connection conn = null;

        PreparedStatement ps = null;

        String sql = "UPDATE user SET name = ?, cpf = ?, email = ?, password = ?, dateOfBirth = ? WHERE id = ?";

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);

            ps.setString(1, updatedUser.getName());
            ps.setString(2, updatedUser.getCpf());
            ps.setString(3, updatedUser.getEmail());
            ps.setString(4, updatedUser.getPassword());
            ps.setDate(5, java.sql.Date.valueOf(updatedUser.getDateOfBirth()));

            ps.setInt(6, userId);

            int rowsAffected = ps.executeUpdate();

            conn.commit();

            return rowsAffected;

        } catch (SQLException e) {
            try{
                conn.rollback();
                throw new DatabaseOperationException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
               throw new DatabaseOperationException("Error trying to rollback! Caused by: " + ex.getMessage());
            }
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public static int  delete(int userId){
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DB.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseOperationException(e.getMessage());
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }
}
