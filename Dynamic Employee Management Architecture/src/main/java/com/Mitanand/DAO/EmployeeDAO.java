package com.Mitanand.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.Mitanand.Empl.Employee;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO() {
        // Establish database connection
    	
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management", "root", "1234");
            System.out.println("Connection happens succesful...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createEmployee(Employee employee) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Employees (name, email, designation, role, password) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDesignation());
            statement.setString(4, employee.getRole());
            statement.setString(5, employee.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            // Executing the query using the ResultSet
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employees");
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setRole(resultSet.getString("role"));
                employee.setPassword(resultSet.getString("password"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    // Implementing update methods
    
    public void updateEmployee(Employee employee) {
        try {
        	// Prepare the Statement
            PreparedStatement statement = connection.prepareStatement("UPDATE Employees SET name=?, email=?, designation=?, role=?, password=? WHERE id=?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getEmail());
            statement.setString(3, employee.getDesignation());
            statement.setString(4, employee.getRole());
            statement.setString(5, employee.getPassword());
            
            statement.setInt(6, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implementing delete methods similarly
    public void deleteEmployee(int employeeId) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Employees WHERE id=?");
            statement.setInt(1, employeeId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}