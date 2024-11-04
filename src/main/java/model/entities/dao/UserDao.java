package model.entities.dao;

import database.DB;
import model.entities.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDao {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public User findById(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM user WHERE id = ?";

        try {
            ps = DB.getConnection().prepareStatement(sql);
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
            DB.closePreparedStatement(ps);
            DB.closePreparedStatement(rs);
        }
    }

    public void insert(User user) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (name, cpf, email, password, dateOfBirth) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = DB.getConnection().prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getCpf());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setDate(5, new java.sql.Date(user.getDateOfBirth().getTime()));

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closePreparedStatement(ps);
        }
    }
}
