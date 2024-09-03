package com.example.cruddemoemployee.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemoemployee.Entity.Employee;
import com.example.cruddemoemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")

	public List<Employee> getEmployees() {
		try {
			// Assuming employeeDao is properly initialized and available
			return employeeService.findAll();
		} catch (Exception exc) {
			// Handle the exception appropriately, like logging or throwing a custom
			// exception
			exc.printStackTrace();
			// Return an empty list or null depending on your application logic
			return new ArrayList<>(); // or return null;
		}
	}

	@GetMapping("/employees/{employeeId}")
	public Employee GetEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employye id not found with id " + employeeId);
		}
		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee employee = employeeService.save(theEmployee);
		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee employee = employeeService.save(theEmployee);
		return employee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);

		if (employee == null) {
			throw new RuntimeException("Employee id not found " + employeeId);

		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id :"+employeeId;

	}

}
