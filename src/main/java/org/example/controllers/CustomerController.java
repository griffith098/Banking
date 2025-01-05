package org.example.controllers;

import org.example.services.AccountService;
import org.example.services.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/customer/*")
public class CustomerController extends HttpServlet {
    private AccountService accountService = new AccountService();
    private TransactionService transactionService = new TransactionService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo();
        switch (action) {
            case "/dashboard":
                req.getRequestDispatcher("/customer/dashboard.jsp").forward(req, resp);
                break;
            case "/account-overview":
                req.setAttribute("account", accountService.getAccountByUser(1)); // Mocked user ID
                req.getRequestDispatcher("/customer/account-overview.jsp").forward(req, resp);
                break;
            case "/transaction-history":
                req.setAttribute("transactions", transactionService.getTransactionsForAccount(1)); // Mocked account ID
                req.getRequestDispatcher("/customer/transaction-history.jsp").forward(req, resp);
                break;
            default:
                resp.sendRedirect("dashboard");
        }
    }
}