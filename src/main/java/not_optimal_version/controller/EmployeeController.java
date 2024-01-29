package not_optimal_version.controller;

import not_optimal_version.model.Employee;
import jakarta.validation.Valid;
import not_optimal_version.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Annotating the class as a Spring RestController, which handles HTTP requests and responses
@RestController

// Specifying the base URL path for all the endpoints in this controller
@RequestMapping("/api/v1/employees")
public class EmployeeController {

	// Injecting the EmployeeService bean into the controller using Spring's @Autowired annotation
	EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// Mapping an HTTP POST request to create a new employee with the given data
	@PostMapping
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		// Delegating the creation of the employee to the employeeService and returning the result
		return employeeService.createEmployee(employee);
	}

	// Mapping an HTTP GET request to retrieve a list of all employees
	@GetMapping
	public List<Employee> readEmployees() {
		// Delegating the retrieval of employees to the employeeService and returning the result
		return employeeService.getEmployees();
	}

	// Mapping an HTTP PUT request to update an existing employee with the given data
	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employee) {
		// Delegating the update operation to the employeeService and returning the updated employee
		return employeeService.updateEmployee(employeeId, employee);
	}

	// Mapping an HTTP DELETE request to delete an employee with the specified ID
	@DeleteMapping(value="/{employeeId}")
	public String deleteEmployees(@PathVariable Long employeeId) {
		// Delegating the deletion of the employee to the employeeService
		employeeService.deleteEmployee(employeeId);
		// Returning a success message indicating that the employee has been successfully deleted
		return "Employee " + employeeId + " successfully deleted";
	}
}
