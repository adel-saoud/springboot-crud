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

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/create-employees-by-id", method=RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
	    return employeeService.createEmployee(employee);
	}

	@RequestMapping(value="/read-employees", method=RequestMethod.GET)
	public List<Employee> readEmployees() {
	    return employeeService.getEmployees();
	}

	@RequestMapping(value="/update-employee-by-id/{empId}", method=RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee employee) {
	    return employeeService.updateEmployee(id, employee);
	}
	
	@RequestMapping(value="/delete-employees-by-id/{empId}", method=RequestMethod.DELETE)
	public String deleteEmployees(@PathVariable(value = "empId") Long id) {
	    employeeService.deleteEmployee(id);
		return "Employee " + id + " successfully deleted";
	}
}



