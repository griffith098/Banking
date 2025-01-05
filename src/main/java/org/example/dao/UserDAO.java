package org.example.dao;

import org.example.model.User;
import org.example.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM Users";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            users.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("role")));
        }
        return users;
    }

    public void addUser(String name, String email, String password, String role) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO Users(name, email, password, role) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareCall(query);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.setString(3, password);
        statement.setString(4, role);
        statement.executeUpdate();
    }
}