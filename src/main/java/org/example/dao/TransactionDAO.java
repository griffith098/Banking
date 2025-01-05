package org.example.dao;

import org.example.model.Transaction;
import org.example.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    /**
     * Fetch all transactions for a specific account.
     *
     * @param accountId - The account ID for which transactions are fetched.
     * @return - List of transactions for the account.
     * @throws SQLException - If any database error occurs.
     */
    public List<Transaction> getTransactionsForAccount(int accountId) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM Transactions WHERE fromAccount = ? OR toAccount = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, accountId);
        statement.setInt(2, accountId);

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            transactions.add(new Transaction(
                    resultSet.getInt("id"),
                    resultSet.getInt("fromAccount"),
                    resultSet.getInt("toAccount"),
                    resultSet.getDouble("amount"),
                    resultSet.getTimestamp("timestamp")
            ));
        }

        resultSet.close();
        statement.close();
        return transactions;
    }

    /**
     * Perform a transaction from one account to another.
     *
     * @param fromAccount - The sender's account ID.
     * @param toAccount   - The receiver's account ID.
     * @param amount      - The transaction amount.
     * @throws SQLException - If any database error occurs.
     */
    public void performTransaction(int fromAccount, int toAccount, double amount) throws SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO Transactions (fromAccount, toAccount, amount) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, fromAccount);
        statement.setInt(2, toAccount);
        statement.setDouble(3, amount);

        statement.executeUpdate();
        statement.close();
    }
}