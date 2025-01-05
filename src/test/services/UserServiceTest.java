package test.services;

import org.example.dao.UserDAO;
import org.example.model.User;
import org.example.services.UserService;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    private UserService userService; // Service to test
    private UserDAO mockUserDAO;    // Mocked DAO for the service

    @BeforeEach
    void setup() {
        // Create a mock of UserDAO
        mockUserDAO = Mockito.mock(UserDAO.class);

        // Inject the mocked DAO into UserService
        userService = new UserService(mockUserDAO);
    }

    @Test
    void testGetAllUsers() {
        // Mock behavior for getUsers()
        List<User> mockUsers = Arrays.asList(
                new User(1, "John Doe", "john.doe@example.com", "Customer"),
                new User(2, "Jane Smith", "jane.smith@example.com", "Admin")
        );
        when(mockUserDAO.getUsers()).thenReturn(mockUsers);

        // Call the service method
        List<User> users = userService.getAllUsers();

        // Verify the behavior
        assertNotNull(users, "User list should not be null.");
        assertEquals(2, users.size(), "The list should contain exactly 2 users.");
        assertEquals("John Doe", users.get(0).getName(), "The first user's name should match.");
        verify(mockUserDAO, times(1)).getUsers(); // Ensure DAO's getUsers() was called exactly once
    }

    @Test
    void testAddUser() {
        User testUser = new User(3, "Alice Johnson", "alice.johnson@example.com", "Customer");

        // Mock behavior for addUser()
        when(mockUserDAO.addUser(testUser)).thenReturn(true);

        // Call the service method
        boolean result = userService.addUser(testUser);

        // Verify the behavior
        assertTrue(result, "The user should be added successfully.");
        verify(mockUserDAO, times(1)).addUser(testUser); // Ensure DAO's addUser() was called exactly once
    }

    @Test
    void testDeleteUser() {
        int userId = 1;

        // Mock behavior for deleteUser()
        when(mockUserDAO.deleteUser(userId)).thenReturn(true);

        // Call the service method
        boolean result = userService.deleteUser(userId);

        // Verify the behavior
        assertTrue(result, "The user should be deleted successfully.");
        verify(mockUserDAO, times(1)).deleteUser(userId); // Ensure DAO's deleteUser() was called exactly once
    }

    @Test
    void testUpdateUser() {
        User updatedUser = new User(1, "John Doe Updated", "john.doe.updated@example.com", "Admin");

        // Mock behavior for updateUser()
        when(mockUserDAO.updateUser(updatedUser)).thenReturn(true);

        // Call the service method
        boolean result = userService.updateUser(updatedUser);

        // Verify the behavior
        assertTrue(result, "The user should be updated successfully.");
        verify(mockUserDAO, times(1)).updateUser(updatedUser); // Ensure DAO's updateUser() was called exactly once
    }

    @Test
    void testGetUserById() {
        int userId = 1;
        User mockUser = new User(userId, "John Doe", "john.doe@example.com", "Customer");

        // Mock behavior for getUserById()
        when(mockUserDAO.getUserById(userId)).thenReturn(mockUser);

        // Call the service method
        User result = userService.getUserById(userId);

        // Verify the behavior
        assertNotNull(result, "A user should be returned for a valid ID.");
        assertEquals(userId, result.getId(), "The user ID should match the search ID.");
        assertEquals("John Doe", result.getName(), "The user name should match.");
        verify(mockUserDAO, times(1)).getUserById(userId); // Ensure DAO's getUserById() was called exactly once
    }
}