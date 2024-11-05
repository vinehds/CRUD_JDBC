package model.entities.dao;

import database.DB;
import model.entities.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public List<User> findAll(){
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
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Date dateOfBirth = rs.getDate("dateOfBirth");

                usersFound.add(new User(name,cpf,email,password,dateOfBirth));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection(conn);
        }

        return usersFound;
    }

    public User findById(int id) {
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
                Date dateOfBirth = rs.getDate("dateOfBirth");

                return new User(name, cpf, email, password, dateOfBirth);
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public int insert(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (name, cpf, email, password, dateOfBirth) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = DB.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getName());
            ps.setString(2, user.getCpf());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));

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
            throw new RuntimeException(e);
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public int update(User updatedUser, int userId){
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DB.getConnection();
        String sql = "UPDATE user SET name = ?, cpf = ?, email = ?, password = ?, dateOfBirth = ? WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, updatedUser.getName());
            ps.setString(2, updatedUser.getCpf());
            ps.setString(3, updatedUser.getEmail());
            ps.setString(4, updatedUser.getPassword());
            ps.setDate(5, new java.sql.Date(updatedUser.getDateOfBirth().getTime()));

            ps.setInt(6, userId);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }

    public int delete(int userId){
        Connection conn = null;
        PreparedStatement ps = null;

        conn = DB.getConnection();
        String sql = "DELETE FROM user WHERE id = ?";

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, userId);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closePreparedStatement(ps);
            DB.closeConnection(conn);
        }
    }
}
