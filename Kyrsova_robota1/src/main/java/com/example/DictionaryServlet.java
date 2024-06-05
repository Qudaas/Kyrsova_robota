package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/translate")
public class DictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String word = request.getParameter("word");
        Map<String, String> dictionary = (Map<String, String>) getServletContext().getAttribute("dictionary");

        String translation = dictionary != null ? dictionary.get(word) : "Translation not found";

        request.setAttribute("word", word);
        request.setAttribute("translation", translation);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}