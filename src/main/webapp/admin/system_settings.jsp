<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>System Settings</title>
    <link rel="stylesheet" href="../css/general_styling.css">
    <script src="../js/form_validation.js"></script>
</head>
<body>
    <h1>System Settings</h1>
    <form action="../AdminController" method="post">
        <label for="setting1">Setting 1:</label>
        <input type="text" id="setting1" name="setting1">

        <label for="setting2">Setting 2:</label>
        <input type="text" id="setting2" name="setting2">

        <button type="submit" name="action" value="updateSettings">Save Settings</button>
    </form>
</body>
</html>