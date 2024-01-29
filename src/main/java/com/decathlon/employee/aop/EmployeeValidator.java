package com.decathlon.employee.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A Marker annotation.
 * It will validate the input data
 * For Each method annotated with this annotation, an aspect will be triggered
 *
 * @see EmployeeAspect
 */
@Target({ElementType.METHOD}) //indicate that @EmployeeValidator can only be applied to methods
@Retention(RetentionPolicy.RUNTIME) //Specifies that the annotation information should be retained at runtime
public @interface EmployeeValidator {
}
