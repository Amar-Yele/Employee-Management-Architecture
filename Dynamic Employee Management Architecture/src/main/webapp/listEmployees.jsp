<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
 		< %@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 -->
<%@ page import="java.util.List" %>
<%@ page import="com.Mitanand.Empl.Employee" %>
<%@ page import="com.Mitanand.Service.EmployeeService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!-- 
<c:set var="role1" value="${sessionScope.role1}" />
 -->
<%
    EmployeeService employeeService = new EmployeeService();
    List<Employee> employees = new ArrayList<>();
    employees = employeeService.getAllEmployees();

    // Store employees list in session for access in other JSP pages
    // HttpSession session = request.getSession();
    session.setAttribute("employees", employees);
	String user = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	
	// Check if user and password are not null before using them
	boolean isAdmin = user != null && password != null && user.equals("Ram") && password.equals("Admin123Ram");
	boolean isArun = user != null && password != null && user.equals("Arun") && password.equals("1234");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Employees</title>
    <link rel="stylesheet" type="text/css" href="ALL_CSS/listEmp.css">
</head>
<body>
    <h2>List of Employees</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Designation</th>
            <th>Role</th>
            <th>Password</th>
			<%
                if(isAdmin){ %>
                <th>Actions</th>
 				<%  }
                %>
        </tr>
        <% for (Employee employee : employees) { %>
        <tr>
            <td><%= employee.getId() %></td>
            <td><%= employee.getName() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getDesignation() %></td>
            <td><%= employee.getRole() %></td>
            <td><%= employee.getPassword() %></td>
            <td>
                <!-- 
                Only show edit and delete buttons if user is admin 
                -->
                
                <%
                if(isAdmin){ %>
                	
                    <a type="button" href="updateEmployee.jsp?id=<%= employee.getId() %>">Edit</a>
                    <form action="deleteEmployeeServlet" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="<%= employee.getId() %>">
                        <input type="submit" value="Delete">
                    </form>
                <%  }
                else if(isArun){
                	%>
                	<a type="button" href="updateEmployee.jsp?id=<%= employee.getId() %>">Edit</a>
               <%  }
                %>

            </td>
        </tr>
        <% } %>
    </table>
    
       <%

    //	 if(u==true && p==true)
    	if(isAdmin)
		{ %>
			<br>
    		 <a href="addEmployee.jsp">Add Employee</a>
	 	<%
		}
       %>

</body>
</html>
