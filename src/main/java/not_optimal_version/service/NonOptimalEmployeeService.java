package not_optimal_version.service;

import not_optimal_version.model.NonOptimalEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonOptimalEmployeeService {

	private final Map<Long, NonOptimalEmployee> employeeMap = new HashMap<>();

	public void createEmployee(NonOptimalEmployee employee) {
		// Non-optimal logic for creating an employee
		employeeMap.put(employee.getEmployeeId(), employee);
	}

	public List<NonOptimalEmployee> getEmployees() {
		// Non-optimal logic for retrieving all employees
		return new ArrayList<>(employeeMap.values());
	}

	public NonOptimalEmployee getEmployeeById(Long employeeId) {
		// Non-optimal logic for retrieving an employee by ID
		return employeeMap.get(employeeId);
	}

	public boolean deleteEmployee(Long employeeId) {
		// Non-optimal logic for deleting an employee
		return employeeMap.remove(employeeId) != null;
	}
}