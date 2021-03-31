package com.employees.service;

import java.util.List;

import com.employees.dto.EmployeeDto;
import com.employees.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(Long id);
	
	Employee saveEmployee(EmployeeDto employeeDto);
	
	Employee updateEmployee(EmployeeDto employeeDto, Long id);
	
	void deleteEmployee(Long id);
}
