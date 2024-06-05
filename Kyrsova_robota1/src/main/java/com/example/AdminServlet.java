package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String role = (session != null) ? (String) session.getAttribute("role") : null;
        if (!"admin".equals(role)) {
            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");
        String word = request.getParameter("word");
        String translation = request.getParameter("translation");
        Map<String, String> dictionary = (Map<String, String>) getServletContext().getAttribute("dictionary");
        if (dictionary == null) {
            dictionary = new HashMap<>();
            getServletContext().setAttribute("dictionary", dictionary);
        }

        if ("add".equals(action)) {
            dictionary.put(word, translation);
        } else if ("edit".equals(action)) {
            String oldWord = request.getParameter("oldWord");
            dictionary.remove(oldWord);
            dictionary.put(word, translation);
        } else if ("delete".equals(action)) {
            dictionary.remove(word);
        }

        request.setAttribute("dictionary", dictionary);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}