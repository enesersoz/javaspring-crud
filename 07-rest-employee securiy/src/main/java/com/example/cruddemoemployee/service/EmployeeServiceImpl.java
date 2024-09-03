package com.example.cruddemoemployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.cruddemoemployee.Entity.Employee;
import com.example.cruddemoemployee.dao.EmployeeDao;
import com.example.cruddemoemployee.dao.EmployeeDaoImpl;

import jakarta.transaction.Transactional;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;

	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId) ;
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.save(theEmployee);
	}
	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
	}
	@Transactional
    @Override
    public Employee update(Employee employee) {
        return employeeDao.save(employee);
    }
	

}
