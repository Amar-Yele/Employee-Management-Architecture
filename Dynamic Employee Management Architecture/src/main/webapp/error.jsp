<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
    <h2>Error</h2>
    <%-- Check if error message is available in request attribute --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <p><strong>Error Message:</strong> <%= request.getAttribute("errorMessage") %></p>
    <% } else { %>
        <p>No error message available.</p>
    <% } %>
</body>
</html>
