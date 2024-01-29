package com.decathlon.employee.aop;

import com.decathlon.employee.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j //automatically generates a logger for the class. The log variable can be used to log messages
@Aspect //contains cross-cutting concerns (like logging, security, etc.) that can be applied to multiple parts of the application
@Component // marks the class as a Spring component, indicating that it should be automatically detected and registered as a Spring bean because it was newly created by myself
@RequiredArgsConstructor //generates a constructor for the class that initializes all final fields with required dependencies
public class EmployeeAspect {

    @Before("@annotation(EmployeeValidator)") //indicates that the validateDTO method should be executed before a method annotated with @EmployeeValidator is invoked
    public void validateModel(JoinPoint jp) { //JoinPoint in AOP represents a point in the execution of the application where the advice (logic) will be applied.
        log.info("Start validating input data");
        Object[] args = jp.getArgs(); //Retrieves the arguments passed to the method being intercepted
        Employee employee = (args != null && args.length > 0) ? (Employee) args[0] : null; //Extracts the first argument and assumes it is an instance of the Employee class. If no arguments are present, it sets employee to null
        Assert.notNull(employee, "Input data is invalid"); //check employee + fields
        Assert.notNull(employee.getFirstName(), "Input first name is invalid/missing");
        Assert.notNull(employee.getLastName(), "Input last name is invalid/missing");
        Assert.notNull(employee.getEmail(), "Input email is invalid/missing");
    }

}