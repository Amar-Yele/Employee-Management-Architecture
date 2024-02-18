package com.Mitanand.Service;

import java.util.List;

import com.Mitanand.DAO.EmployeeDAO;
import com.Mitanand.Empl.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeService() {
        employeeDAO = new EmployeeDAO();
    }

    public void addEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    // Implemented update and delete methods similarly
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }
}
