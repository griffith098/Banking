package org.example.controllers;

import org.example.model.User;
import org.example.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/manage-users":
                req.setAttribute("users", userService.getAllUsers());
                req.getRequestDispatcher("/admin/manage-users.jsp").forward(req, resp);
                break;
            case "/monitor-transactions":
                req.getRequestDispatcher("/admin/monitor-transactions.jsp").forward(req, resp);
                break;
            default:
                req.getRequestDispatcher("/admin/dashboard.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getPathInfo();
        if ("/manage-users".equals(action)) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String role = req.getParameter("role");
            userService.addUser(name, email, "password123", role);
            resp.sendRedirect("manage-users");
        }
    }
}