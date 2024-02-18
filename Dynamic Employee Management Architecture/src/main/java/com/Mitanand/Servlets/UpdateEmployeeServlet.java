package com.Mitanand.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mitanand.Service.EmployeeService;
import com.Mitanand.Empl.Employee;

@WebServlet("/updateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    public UpdateEmployeeServlet() {
        employeeService = new EmployeeService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        String role = request.getParameter("role");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setEmail(email);
        employee.setDesignation(designation);
        employee.setRole(role);
        employee.setPassword(password);

        employeeService.updateEmployee(employee);
        System.out.println("Inside the Update Servelet");

        response.sendRedirect("listEmployees.jsp");
    }
}

