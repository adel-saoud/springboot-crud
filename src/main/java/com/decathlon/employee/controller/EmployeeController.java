package com.decathlon.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.decathlon.employee.model.Employee;
import com.decathlon.employee.service.EmployeeService;

// Annotating the class as a Spring RestController, which handles HTTP requests and responses
@RestController

// Specifying the base URL path for all the endpoints in this controller
@RequestMapping("/api/v1")
public class EmployeeController {

	// Injecting the EmployeeService bean into the controller using Spring's @Autowired annotation
	@Autowired
	EmployeeService employeeService;

	// Mapping an HTTP POST request to create a new employee with the given data
	@RequestMapping(value="/employees", method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		// Delegating the creation of the employee to the employeeService and returning the result
		return employeeService.createEmployee(employee);
	}

	// Mapping an HTTP GET request to retrieve a list of all employees
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> readEmployees() {
		// Delegating the retrieval of employees to the employeeService and returning the result
		return employeeService.getEmployees();
	}

	// Mapping an HTTP PUT request to update an existing employee with the given data
	@RequestMapping(value="/employees/{employeeId}", method=RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable(value = "employeeId") Long id, @RequestBody Employee employee) {
		// Delegating the update operation to the employeeService and returning the updated employee
		return employeeService.updateEmployee(id, employee);
	}

	// Mapping an HTTP DELETE request to delete an employee with the specified ID
	@RequestMapping(value="/employees/{employeeId}", method=RequestMethod.DELETE)
	public String deleteEmployees(@PathVariable(value = "employeeId") Long id) {
		// Delegating the deletion of the employee to the employeeService
		employeeService.deleteEmployee(id);
		// Returning a success message indicating that the employee has been successfully deleted
		return "Employee " + id + " successfully deleted";
	}
}
