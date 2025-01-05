<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Monitor Transactions</title>
    <link rel="stylesheet" href="../css/general_styling.css">
    <script src="../js/form_validation.js"></script>
</head>
<body>
    <h1>Monitor Transactions</h1>
    <form action="../TransactionService" method="get">
        <label for="accountId">Account ID:</label>
        <input type="number" id="accountId" name="accountId">
        <button type="submit">View Transactions</button>
    </form>

    <h2>Transaction History</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>From Account</th>
            <th>To Account</th>
            <th>Amount</th>
            <th>Timestamp</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dynamic rows will be populated from the controller -->
        </tbody>
    </table>
</body>
</html>