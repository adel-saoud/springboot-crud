package com.decathlon.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity //used to mark the class as a JPA entity. It indicates that the class is an entity and is mapped to a database table.
@Table(name = "employee") //used to specify the name of the table that the entity is mapped to
@Getter //generate getters and setters
@Setter
public class Employee {
	
	@Id //specify the primary key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) //used to specify the strategy for generating primary keys
	@Column(name="employee_id") //specify the name of the column that the field is mapped to
    private Long employeeId;

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
}
