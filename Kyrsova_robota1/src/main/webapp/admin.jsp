<%@ page import="java.util.Map" %>
<%@ page import="java.util.Map.Entry" %>
<%
    String role = (String) session.getAttribute("role");
    if (!"admin".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }

    Map<String, String> dictionary = (Map<String, String>) application.getAttribute("dictionary");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Admin Page</h1>
<form action="admin" method="post">
    <input type="hidden" name="action" value="add">
    <label for="word">Word:</label>
    <input type="text" id="word" name="word" required><br>
    <label for="translation">Translation:</label>
    <input type="text" id="translation" name="translation" required><br>
    <input type="submit" value="Add">
</form>

<h2>Dictionary</h2>
<table border="1">
    <tr>
        <th>Word</th>
        <th>Translation</th>
        <th>Actions</th>
    </tr>
    <%
        if (dictionary != null) {
            for (Entry<String, String> entry : dictionary.entrySet()) {
                String word = entry.getKey();
                String translation = entry.getValue();
    %>
    <tr>
        <td><%= word %></td>
        <td><%= translation %></td>
        <td>
            <form action="editWord" method="get" style="display:inline;">
                <input type="hidden" name="word" value="<%= word %>">
                <input type="submit" value="Edit">
            </form>
            <form action="admin" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="word" value="<%= word %>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

<a href="index.jsp">Go to Dictionary</a><br>
<a href="logout">Logout</a>
</body>
</html>