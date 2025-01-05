package org.example.services;

import org.example.dao.TransactionDAO;
import org.example.dao.AccountDAO;
import org.example.model.Transaction;
import org.example.model.Account;

import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    private TransactionDAO transactionDAO = new TransactionDAO();
    private AccountDAO accountDAO = new AccountDAO();

    /**
     * Retrieves all transactions for a specific account.
     *
     * @param accountId - Account ID for which transactions are retrieved.
     * @return List of transactions.
     */
    public List<Transaction> getTransactionsForAccount(int accountId) {
        try {
            return transactionDAO.getTransactionsForAccount(accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching transactions: " + e.getMessage());
        }
    }

    /**
     * Handles transferring funds from one account to another.
     *
     * @param fromAccountId - Sender's account ID.
     * @param toAccountId   - Receiver's account ID.
     * @param amount        - Amount to transfer.
     */
    public void transferFunds(int fromAccountId, int toAccountId, double amount) {
        try {
            Account fromAccount = accountDAO.getAccountByAccountId(fromAccountId);
            Account toAccount = accountDAO.getAccountByAccountId(toAccountId);

            if (fromAccount == null || toAccount == null) {
                throw new IllegalArgumentException("Invalid account IDs.");
            }
            if (fromAccount.getBalance() < amount) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            accountDAO.updateAccountBalance(fromAccountId, fromAccount.getBalance() - amount);
            accountDAO.updateAccountBalance(toAccountId, toAccount.getBalance() + amount);

            transactionDAO.performTransaction(fromAccountId, toAccountId, amount);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error during fund transfer: " + e.getMessage());
        }
    }
}