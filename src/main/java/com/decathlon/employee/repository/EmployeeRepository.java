package com.decathlon.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.decathlon.employee.model.Employee;

// Annotating the interface as a Spring Repository, indicating that it should be treated as a repository for data access
//Certainly! In non-technical terms, think of a repository as a kind of storage or database that holds information. It's a place where you can organize and manage data related to a specific topic or area. In this case, the repository is designed to handle information about employees.

@Repository

// Extending the JpaRepository interface with Employee as the entity type and Long as the type of the entity's primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> { //= storage/database that handle information about employees.

}
