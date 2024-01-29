package not_optimal_version.service;

import not_optimal_version.model.NonOptimalEmployee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NonOptimalEmployeeService {

	private final Map<Long, NonOptimalEmployee> employeeMap = new HashMap<>();

	public void createNonOptimalEmployee(NonOptimalEmployee nonOptimalEmployee) {
		// Non-optimal logic for creating an employee
		employeeMap.put(nonOptimalEmployee.getEmployeeId(), nonOptimalEmployee);
	}

	public List<NonOptimalEmployee> getEmployees() {
		// Non-optimal logic for retrieving all employees
		return new ArrayList<>(employeeMap.values());
	}

	public NonOptimalEmployee getNonOptimalEmployeeById(Long nonOptimalEmployeeId) {
		// Non-optimal logic for retrieving an employee by ID
		return employeeMap.get(nonOptimalEmployeeId);
	}

	public boolean deleteNonOptimalEmployee(Long nonOptimalEmployeeId) {
		// Non-optimal logic for deleting an employee
		return employeeMap.remove(nonOptimalEmployeeId) != null;
	}
}