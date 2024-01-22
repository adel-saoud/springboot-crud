package com.decathlon.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.decathlon.employee.model.Employee;

// Annotating the interface as a Spring Repository, indicating that it should be treated as a repository for data access
@Repository

// Extending the JpaRepository interface with Employee as the entity type and Long as the type of the entity's primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
