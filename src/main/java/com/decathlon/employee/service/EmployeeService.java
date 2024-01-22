package com.decathlon.employee.service;

import java.util.List;

import com.decathlon.employee.model.Employee;
import com.decathlon.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Annotating the class as a Spring Service, indicating that it holds business logic
@Service
public class EmployeeService {

	// Injecting the EmployeeRepository bean into the service using Spring's @Autowired annotation
	@Autowired
	EmployeeRepository employeeRepository;

	// Method for creating a new employee by saving it using the employeeRepository
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	// Method for retrieving a list of all employees using the employeeRepository
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	// Method for updating an existing employee's details based on the provided employee ID and new details
	public Employee updateEmployee(Long empId, Employee employeeDetails) {
		// Retrieving the existing employee from the repository based on the provided employee ID
		Employee employee = employeeRepository.findById(empId).get();

		// Updating the employee's details with the new information
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());

		// Saving the updated employee to the repository and returning the updated instance
		return employeeRepository.save(employee);
	}

	// Method for deleting an employee based on the provided employee ID
	public void deleteEmployee(Long empId) {
		// Deleting the employee from the repository based on the provided employee ID
		employeeRepository.deleteById(empId);
	}
}
