package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/translate")
public class TranslateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String word = request.getParameter("word");
        Object Dictionary = new Object();
        String translation = String.valueOf(Dictionary.getClass());
        request.setAttribute("word", word);
        request.setAttribute("translation", translation);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}