package com.example.cruddemoemployee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.cruddemoemployee.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

		// execute query and get result list
		List<Employee> employess = theQuery.getResultList();

		// return the results
		return employess;
	}

	@Override
	public Employee findById(int theId) {

		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);

		return dbEmployee;
	}

	@Override
	public void deleteById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class,theId);
		entityManager.remove(theEmployee);
		
	}
	@Override
	public Employee update(Employee theEmployee) {
		// Explicit update method
		Employee dbEmployee = entityManager.merge(theEmployee);
		return dbEmployee;
	}
}
