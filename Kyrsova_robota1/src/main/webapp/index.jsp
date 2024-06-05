<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession currentSession = request.getSession(false);
    String role = (currentSession != null) ? (String) currentSession.getAttribute("role") : null;
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>English-Ukrainian Dictionary</h1>
<form action="translate" method="get">
    <label for="word">Word:</label>
    <input type="text" id="word" name="word" required><br>
    <input type="submit" value="Translate">
</form>
<%
    String word = (String) request.getAttribute("word");
    String translation = (String) request.getAttribute("translation");
    if (word != null && translation != null) {
%>
<p>Translation of '<%= word %>' is '<%= translation %>'</p>
<% } %>

<% if ("admin".equals(role)) { %>
<a href="admin">Go to Admin Page</a><br>
<% } %>
<a href="logout">Logout</a>
</body>
</html>