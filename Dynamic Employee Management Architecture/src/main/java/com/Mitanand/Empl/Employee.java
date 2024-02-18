package com.Mitanand.Empl;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String designation;
	private String role;
    private String password;
    
    // Constructor, getters, and setters
    
	public Employee() {
		super();
		// Constructor....
	}
	public Employee(int id, String name, String email, String designation, String role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.designation = designation;
		this.role = role;
		this.password = password;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
    public String getRole() {
    	return role;
    }
    public void setRole(String role) {
    	this.role = role;
    }
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }


   
    
}