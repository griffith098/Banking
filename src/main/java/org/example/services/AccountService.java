package org.example.services;

import org.example.dao.AccountDAO;
import org.example.model.Account;

import java.sql.SQLException;

public class AccountService {
    private AccountDAO accountDAO = new AccountDAO();

    /**
     * Retrieves account details for a specific user.
     *
     * @param userId - User ID whose account is retrieved.
     * @return Account object if found.
     */
    public Account getAccountByUser(int userId) {
        try {
            return accountDAO.getAccountByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching account: " + e.getMessage());
        }
    }

    /**
     * Updates the account balance.
     *
     * @param accountId  - Account ID.
     * @param newBalance - New balance to set.
     */
    public void updateAccountBalance(int accountId, double newBalance) {
        try {
            accountDAO.updateAccountBalance(accountId, newBalance);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating account balance: " + e.getMessage());
        }
    }
}