<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Manage Users</title>
    <link rel="stylesheet" href="../css/general_styling.css">
    <script src="../js/form_validation.js"></script>
</head>
<body>
    <h1>Manage Users</h1>
    <form action="../AdminController" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">

        <label for="email">Email:</label>
        <input type="email" id="email" name="email">

        <label for="role">Role:</label>
        <select id="role" name="role">
            <option value="Admin">Admin</option>
            <option value="Customer">Customer</option>
        </select>

        <button type="submit" name="action" value="addUser">Add User</button>
    </form>

    <h2>Current Users</h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
        </tr>
        </thead>
        <tbody>
        <!-- Dynamic rows will be populated from the controller -->
        </tbody>
    </table>
</body>
</html>