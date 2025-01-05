package org.example.dao;

import org.example.model.Account;
import org.example.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    /**
     * Retrieve account details by account ID.
     *
     * @param accountId - The account ID.
     * @return - The Account object if found, null otherwise.
     * @throws SQLException - If any database error occurs.
     */
    public Account getAccountByAccountId(int accountId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM Accounts WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, accountId);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Account(
                    resultSet.getInt("id"),
                    resultSet.getInt("userId"),
                    resultSet.getDouble("balance")
            );
        }

        resultSet.close();
        statement.close();
        return null;
    }

    /**
     * Retrieve account details using the user ID.
     *
     * @param userId - The user ID linked to the account.
     * @return - The Account object if found, null otherwise.
     * @throws SQLException - If any database error occurs.
     */
    public Account getAccountByUserId(int userId) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM Accounts WHERE userId = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, userId);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Account(
                    resultSet.getInt("id"),
                    resultSet.getInt("userId"),
                    resultSet.getDouble("balance")
            );
        }

        resultSet.close();
        statement.close();
        return null;
    }

    /**
     * Update the balance of an account.
     *
     * @param accountId   - The ID of the account to update.
     * @param newBalance  - The new balance of the account.
     * @throws SQLException - If any database error occurs.
     */
    public void updateAccountBalance(int accountId, double newBalance) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "UPDATE Accounts SET balance = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDouble(1, newBalance);
        statement.setInt(2, accountId);

        statement.executeUpdate();
        statement.close();
    }
}