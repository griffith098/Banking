package org.example.services;

import org.example.dao.UserDAO;
import org.example.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    /**
     * Retrieves all registered users.
     *
     * @return List of all users.
     */
    public List<User> getAllUsers() {
        try {
            return userDAO.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching users: " + e.getMessage());
        }
    }

    /**
     * Adds a new user to the database.
     *
     * @param name     - User's name.
     * @param email    - User's email.
     * @param password - User's password.
     * @param role     - Role of the user (Admin or Customer).
     */
    public void addUser(String name, String email, String password, String role) {
        try {
            if (!ValidationUtil.isValidEmail(email)) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (!ValidationUtil.isStrongPassword(password)) {
                throw new IllegalArgumentException("Password must be at least 8 characters, with a number and special character.");
            }
            userDAO.addUser(name, email, password, role);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding user: " + e.getMessage());
        }
    }
}