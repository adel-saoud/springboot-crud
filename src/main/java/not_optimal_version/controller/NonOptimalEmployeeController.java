package not_optimal_version.controller;

import not_optimal_version.model.NonOptimalEmployee;
import not_optimal_version.service.NonOptimalEmployeeService;

import java.util.List;
import java.util.Map;

public class NonOptimalEmployeeController {

	private final NonOptimalEmployeeService employeeService;

	public NonOptimalEmployeeController(NonOptimalEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String createEmployee(Map<String, String> employeeData) {
		// Non-optimal logic for creating an employee
		NonOptimalEmployee employee = new NonOptimalEmployee(employeeData.get("firstName"),
				employeeData.get("lastName"),
				employeeData.get("email"));
		employeeService.createEmployee(employee);
		return "Employee created successfully";
	}

	public List<NonOptimalEmployee> readEmployees() {
		// Non-optimal logic for retrieving all employees
		return employeeService.getEmployees();
	}

	public String updateEmployee(Long employeeId, Map<String, String> employeeData) {
		// Non-optimal logic for updating an employee
		NonOptimalEmployee employee = employeeService.getEmployeeById(employeeId);
		if (employee != null) {
			employee.setFirstName(employeeData.get("firstName"));
			employee.setLastName(employeeData.get("lastName"));
			employee.setEmail(employeeData.get("email"));
			return "Employee updated successfully";
		} else {
			return "Employee not found";
		}
	}

	public String deleteEmployees(Long employeeId) {
		// Non-optimal logic for deleting an employee
		if (employeeService.deleteEmployee(employeeId)) {
			return "Employee deleted successfully";
		} else {
			return "Employee not found";
		}
	}
}