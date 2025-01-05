<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/general_styling.css">
    <script src="js/form_validation.js"></script>
</head>
<body>
    <h1>Login to Your Account</h1>
    <form action="LoginController" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" name="action" value="login">Login</button>
    </form>
    <p>If you don't have an account, please contact your bank administrator.</p>
</body>
</html>