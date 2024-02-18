<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.Mitanand.Empl.Employee" %>
<%@ page import="com.Mitanand.Service.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Retrieve employee details from session
    // HttpSession session = request.getSession();
    List<Employee> employees = (List<Employee>) session.getAttribute("employees");
    int id = Integer.parseInt(request.getParameter("id"));
    Employee employeeToUpdate = null;
    
    // Used For each Loop for retrieving the data from Employee Object
    for (Employee employee : employees) {
        if (employee.getId() == id) {
            employeeToUpdate = employee;
            break;
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <link rel="stylesheet" type="text/css" href="ALL_CSS/update.css"> 
</head>
<body>
    <h2>Update Employee</h2>
    <form action="updateEmployeeServlet" method="post">
        <input type="hidden" name="id" value="<%= employeeToUpdate.getId() %>">
        Name: <input type="text" name="name" value="<%= employeeToUpdate.getName() %>"><br>
        Email: <input type="email" name="email" value="<%= employeeToUpdate.getEmail() %>"><br>
        Designation: <input type="text" name="designation" value="<%= employeeToUpdate.getDesignation() %>"><br>
        Role: <input type="text" name="role" value="<%= employeeToUpdate.getRole() %>"><br>
        Password: <input type="text" name="password" value="<%= employeeToUpdate.getPassword() %>"><br>
        <input type="submit" value="Submit">
    </form>
    <br>
    <a href="listEmployees.jsp">Back to List</a>
</body>
</html>