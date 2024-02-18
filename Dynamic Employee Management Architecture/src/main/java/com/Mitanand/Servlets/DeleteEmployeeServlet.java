package com.Mitanand.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Mitanand.Service.EmployeeService;
//import com.Mitanand.Empl.Employee;

@WebServlet("/deleteEmployeeServlet")
public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    public DeleteEmployeeServlet() {
        employeeService = new EmployeeService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Set the username attribute in the session
        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("password", password);
       
        System.out.println("Username set in session: " + username);
        System.out.println("Password set in session: " + password);
        
        boolean isAdmin = username != null && password != null && username.equals("Ram") && password.equals("Admin123Ram");
        
        if(isAdmin) {
        	response.sendRedirect("listEmployees.jsp");
        }
        else {
//        	response.sendRedirect("error.jsp");
            PrintWriter out = response.getWriter();

            // Now you can use this PrintWriter object to write output
            out.println("<html>");
            out.println("<head><title>DELETE INFO</title></head>");
            out.println("<body style='color:pink;'>");
//            out.println("<h1>Data Deleted Successfully.....!</h1>");
//            out.println("<a href=\"login.jsp\">Log In Once again</a>");
//            out.println("<a href=\"listEmployees.jsp\"> List</a>");            
            out.println("<h1 style=\"color: #333333; font-family: Arial, sans-serif; text-align: center;\">Data Deleted Successfully.....!</h1>");
            out.println("<a href=\"login.jsp\" style=\"display: block; text-align: center; margin-top: 20px; color: rgb(60, 189, 103; text-decoration: none;\"><h2>Log In Once again</h2></a>");
            out.println("<a href=\"listEmployees.jsp\" style=\"display: block; text-align: center; margin-top: 20px; color: Red; text-decoration: none;\"><h1>List</h1></a>");
 
            out.println("</body>");
            out.println("</html>");
        }

    }
}

