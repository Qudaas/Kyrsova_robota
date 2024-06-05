package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        if ("admin".equals(username) && "adminpass".equals(password)) {
            session.setAttribute("role", "admin");
            response.sendRedirect("admin");
        } else if ("user".equals(username) && "userpass".equals(password)) {
            session.setAttribute("role", "user");
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid login credentials.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}