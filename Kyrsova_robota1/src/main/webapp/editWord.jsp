<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%
    String role = (String) session.getAttribute("role");
    if (!"admin".equals(role)) {
        response.sendRedirect("login.jsp");
        return;
    }

    String word = (String) request.getAttribute("word");
    String translation = (String) request.getAttribute("translation");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Word</title>
</head>
<body>
<h1>Edit Word</h1>
<form action="admin" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="oldWord" value="<%= word %>">
    <label for="word">Word:</label>
    <input type="text" id="word" name="word" value="<%= word %>" required><br>
    <label for="translation">Translation:</label>
    <input type="text" id="translation" name="translation" value="<%= translation %>" required><br>
    <input type="submit" value="Save">
</form>

<a href="admin">Back to Admin Page</a><br>
<a href="logout">Logout</a>
</body>
</html>