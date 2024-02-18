<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Employee</title>
     <link rel="stylesheet" type="text/css" href="ALL_CSS/deleteEmp.css">
</head>
<body>
    <h2>Delete Employee</h2>
    
           <%
   			String user = (String) session.getAttribute("username");
   			String password = (String) session.getAttribute("password");
   			
   			boolean isAdmin = ((user != null && password != null) && 
   					(user.equals("Ram") && password.equals("Admin123Ram"))
   					|| (user.equals("Shiv") && password.equals("12345"))
   					);
		
		if(isAdmin){
		%>
		
			<form action="deleteEmployeeServlet" method="post">
       			Employee ID: <input type="text" name="id"><br>
        	<input type="submit" value="Submit">
    		</form>
		
			<br>
    		<!-- 
    		 <a href="addEmployee.jsp">Add Employee</a>
    		 --> 
	 	<%
		}
       %>
    

</body>
</html>
