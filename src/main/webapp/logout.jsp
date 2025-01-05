<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.http.*" %>
<%
    // Invalidate the current session to log the user out
    HttpSession session = request.getSession(false);
    if (session != null) {
        session.invalidate();
    }
    response.sendRedirect("login.jsp"); // Redirect back to the login page
%>