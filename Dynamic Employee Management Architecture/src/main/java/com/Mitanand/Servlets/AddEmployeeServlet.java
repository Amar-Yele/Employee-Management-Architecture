package com.Mitanand.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Mitanand.Service.EmployeeService;
import com.Mitanand.Empl.Employee;

@WebServlet("/addEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    public AddEmployeeServlet() {
        employeeService = new EmployeeService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	HttpSession session = request.getSession();
    	String role1 = (String) session.getAttribute("role1");
    	
//    	if("admin".equals(role1)) {
    		
        	String name = request.getParameter("name");
            String email = request.getParameter("email");
            String designation = request.getParameter("designation");
            String role = request.getParameter("role");
            String password = request.getParameter("password");

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setDesignation(designation);
            employee.setRole(role);
            employee.setPassword(password);

            employeeService.addEmployee(employee);

            response.sendRedirect("listEmployees.jsp");
    		
//    	}
//    	else {
//    		response.sendRedirect("error.jsp");
//    	}

    }
}

