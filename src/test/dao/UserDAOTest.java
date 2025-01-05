package test.dao;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static UserDAO userDAO;

    @BeforeAll
    static void setup() {
        userDAO = new UserDAO(); // Initialize the UserDAO
    }

    @BeforeEach
    void init() {
        // Any setup needed before each test runs, e.g., resetting DB, etc.
    }

    @AfterEach
    void teardown() {
        // Clean up resources after each test, e.g., clearing test data.
    }

    @Test
    void testAddUser() {
        User testUser = new User(1, "John Doe", "john.doe@example.com", "Customer");

        boolean result = userDAO.addUser(testUser);

        assertTrue(result, "The user should have been added successfully.");
    }

    @Test
    void testGetUserById() {
        int validUserId = 1;
        User result = userDAO.getUserById(validUserId);

        assertNotNull(result, "User should be returned for a valid ID.");
        assertEquals(validUserId, result.getId(), "The returned user ID should match the search ID.");
    }

    @Test
    void testGetUsers() {
        List<User> users = userDAO.getUsers();

        assertNotNull(users, "The user list should not be null.");
        assertTrue(users.size() > 0, "The user list should contain users.");
    }

    @Test
    void testDeleteUser() {
        int testUserId = 1; // Assuming this ID exists in test DB.

        boolean result = userDAO.deleteUser(testUserId);

        assertTrue(result, "The user should be deleted successfully.");
    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User(1, "John Doe Updated", "john.doe.updated@example.com", "Admin");

        boolean result = userDAO.updateUser(updatedUser);

        assertTrue(result, "The user should be updated successfully.");
    }
}