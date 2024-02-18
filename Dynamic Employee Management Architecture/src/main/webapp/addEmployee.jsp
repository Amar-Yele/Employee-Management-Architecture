<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Mitanand.Empl.Employee" %>
<%@ page import="com.Mitanand.Service.EmployeeService" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="ALL_CSS/addEmployee.css">
</head>
<body>
    <h2>Add Employee</h2>
    <form action="addEmployeeServlet" method="post">
        Name: <input type="text" name="name"><br>
        Email: <input type="email" name="email"><br>
        Designation: <input type="text" name="designation"><br>
        Role: <input type="text" name="role"><br>
        Password: <input type="text" name="password"><br>
        <input type="submit" value="Submit">
    </form>
    
    <%
   			String user = (String) session.getAttribute("username");
   			String password = (String) session.getAttribute("password");

    	if(user.equals("Ram") && password.equals("Admin123Ram"))
		{ %>
			<br>
    		 <a href="listEmployees.jsp">Back to List</a>
	 	<%
		}
       %>
    
    <br>
    
</body>
</html>
