package com.example.cruddemoemployee.dao;

import java.util.List;

import com.example.cruddemoemployee.Entity.Employee;

public interface EmployeeDao {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

	Employee update(Employee employee);
	
	

}
