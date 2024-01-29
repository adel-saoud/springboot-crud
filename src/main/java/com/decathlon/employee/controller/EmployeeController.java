package com.decathlon.employee.controller;

import java.util.List;

import com.decathlon.employee.aop.EmployeeValidator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


import com.decathlon.employee.model.Employee;
import com.decathlon.employee.service.EmployeeService;


@RestController // Annotating the class as a Spring RestController, which handles HTTP requests and responses
@RequestMapping("/api/v1/employees") // Specifying the base URL path for all the endpoints in this controller
public class EmployeeController {


//	@Autowired
	// classes depends on other classes or components.
	// These dependencies are typically injected into the class through either constructor injection or @Autowired annotation.
	EmployeeService employeeService; // Injecting the EmployeeService bean into the controller using Spring's @Autowired annotation


	//dependencies are explicitly declared in the class's constructor -> makes it clear what the dependencies of a class are right from the beginning + easier to write unit tests
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

//	@EmployeeValidator
	@PostMapping // Mapping an HTTP POST request to create a new employee with the given data
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		// Delegating the creation of the employee to the employeeService and returning the result
		return employeeService.createEmployee(employee);
	}


	@GetMapping // Mapping an HTTP GET request to retrieve a list of all employees
	public List<Employee> readEmployees() {
		// Delegating the retrieval of employees to the employeeService and returning the result
		return employeeService.getEmployees();
	}


//	@EmployeeValidator
	@PutMapping("/{employeeId}") // Mapping an HTTP PUT request to update an existing employee with the given data
	public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employee) {
		// Delegating the update operation to the employeeService and returning the updated employee
		return employeeService.updateEmployee(employeeId, employee);
	}


	@DeleteMapping(value="/{employeeId}") // Mapping an HTTP DELETE request to delete an employee with the specified ID
	public String deleteEmployees(@PathVariable Long employeeId) {
		// Delegating the deletion of the employee to the employeeService
		employeeService.deleteEmployee(employeeId);
		// Returning a success message indicating that the employee has been successfully deleted
		return "Employee " + employeeId + " successfully deleted";
	}
}
