package com.decathlon.employee.service;

import java.util.List;

import com.decathlon.employee.model.Employee;
import com.decathlon.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	//CREATE
	public Employee createEmployee(Employee employee) {
	    return employeeRepository.save(employee);
	}
	
	//READ
	public List<Employee> getEmployees() {
	    return employeeRepository.findAll();
	}

	//UPDATE
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(empId).get();
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		return employeeRepository.save(employee);
	}

	//DELETE
	public void deleteEmployee(Long empId) {
	    employeeRepository.deleteById(empId);
	}
}

