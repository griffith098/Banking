<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Transaction History</title>
    <link rel="stylesheet" href="../css/general_styling.css">
    <script src="../js/form_validation.js"></script>
</head>
<body>
    <h1>Transaction History</h1>
    <p>View all transactions made from your account below:</p>
    <table>
        <thead>
        <tr>
            <th>Transaction ID</th>
            <th>From Account</th>
            <th>To Account</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dynamic rows will populate the transaction data -->
        </tbody>
    </table>
</body>
</html>