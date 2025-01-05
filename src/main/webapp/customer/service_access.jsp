<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Service Access</title>
    <link rel="stylesheet" href="../css/general_styling.css">
    <script src="../js/form_validation.js"></script>
</head>
<body>
    <h1>Service Access</h1>
    <form action="../CustomerController" method="post">
        <label for="service">Select a Service:</label>
        <select id="service" name="service">
            <option value="Loan Application">Loan Application</option>
            <option value="Account Upgrade">Account Upgrade</option>
            <option value="Customer Support">Customer Support</option>
        </select>

        <button type="submit" name="action" value="requestService">Request Service</button>
    </form>
</body>
</html>