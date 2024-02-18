<%@page import="java.awt.desktop.UserSessionEvent"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" type="text/css" href="ALL_CSS/style.css">
</head>
<body>

	<%
	String user = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	
	// boolean u = user != null && user.equals("Ram");
	// boolean p = password != null && password.equals("Admin123Ram");

	%>
	
	<div class="welcome-container">
	
		<!-- 
		<h1>Welcome dadus <%= user %></h1>
		<h3> < %= u %> </h3>
		<h3> < %= p %> </h3>
		 -->
        <h1>Welcome <%=  session.getAttribute("username") %></h1>
        <p>You have successfully logged in!</p>

        <p>You are logged in as <%= session.getAttribute("username") %></p>
        
       <%
    //	 if(u==true && p==true)
    	if(user.equals("Ram") && password.equals("Admin123Ram"))
		{ %>
			<br>
    		 <a href="addEmployee.jsp">Add Employee</a>
    		 <a href="listEmployees.jsp">Employee Details</a>
	 	<%
		}
    	else if(user.equals("Akshay") && password.equals("1234")){
    		%>
			<br>
    		 <a href="listEmployees.jsp">Employee Details</a>
	 	<%
    	}
    	else if(user.equals("amar") && password.equals("1234")){
    		%>
			<br>
    		 <a href="addEmployee.jsp">Add Employees</a>
	 	<%
    	}
    	else if(user.equals("Shiv") && password.equals("12345")){
    		%>
			<br>
    		 <a href="deleteEmployee.jsp">Delete Employees</a>
	 	<%
    	}
    	else if(user.equals("Arun") && password.equals("1234")){
    		%>
			<br>
    		 <a href="updateEmployee.jsp">Update Employees</a>
		<% } %>
        
    </div>

</body>
</html>
