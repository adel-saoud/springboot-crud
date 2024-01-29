package not_optimal_version.controller;

import not_optimal_version.model.NonOptimalEmployee;
import not_optimal_version.service.NonOptimalEmployeeService;

import java.util.List;
import java.util.Map;

public class NonOptimalEmployeeController {

	private final NonOptimalEmployeeService nonOptimalEmployeeService;

	public NonOptimalEmployeeController(NonOptimalEmployeeService nonOptimalEmployeeService) {
		this.nonOptimalEmployeeService = nonOptimalEmployeeService;
	}

	public String createEmployee(Map<String, String> employeeData) {
		// Non-optimal logic for creating an employee
		NonOptimalEmployee employee = new NonOptimalEmployee(employeeData.get("firstName"),
				employeeData.get("lastName"),
				employeeData.get("email"));
		nonOptimalEmployeeService.createNonOptimalEmployee(employee);
		return "Employee created successfully";
	}

	public List<NonOptimalEmployee> readEmployees() {
		// Non-optimal logic for retrieving all employees
		return nonOptimalEmployeeService.getEmployees();
	}

	public String updateEmployee(Long nonOptimalEmployeeId, Map<String, String> employeeData) {
		// Non-optimal logic for updating an employee
		NonOptimalEmployee employee = nonOptimalEmployeeService.getNonOptimalEmployeeById(nonOptimalEmployeeId);
		if (employee != null) {
			employee.setFirstName(employeeData.get("firstName"));
			employee.setLastName(employeeData.get("lastName"));
			employee.setEmail(employeeData.get("email"));
			return "Employee updated successfully";
		} else {
			return "Employee not found";
		}
	}

	public String deleteEmployees(Long nonOptimalEmployeeId) {
		// Non-optimal logic for deleting an employee
		if (nonOptimalEmployeeService.deleteNonOptimalEmployee(nonOptimalEmployeeId)) {
			return "Employee deleted successfully";
		} else {
			return "Employee not found";
		}
	}
}