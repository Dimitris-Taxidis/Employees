package com.employees.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employees.dto.EmployeeDto;
import com.employees.entity.Employee;
import com.employees.service.EmployeeService;
import com.employees.util.GenericModelMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

//	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private GenericModelMapper modelMapper;
	
	// expose "/employees" and return list of employees
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<EmployeeDto> findAll() {
		List<Employee> employees = employeeService.findAll();
		if( employees.isEmpty() ) {
			return null;
		}
		List<EmployeeDto> employeesDto = modelMapper.convertEmployeesToDto(employees);
		return employeesDto;
	}
	
	// add mapping for GET /employee/id
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public EmployeeDto getEmployee(@PathVariable Long id) {
		
		Employee employee = employeeService.findById(id);	
		EmployeeDto employeeDto = null;
		if ( null != employee ) {
			employeeDto = modelMapper.convertEmployeeToDto(employee);
		}
		return employeeDto;
	}
	
	// add mapping for POST /employee - add new employee
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee addEmployee(@RequestBody EmployeeDto employeeDto) {	
		Employee employee = null;
		if( null != employeeDto ) {
			employee = employeeService.saveEmployee(employeeDto);
		}
		return employee;
	}
	
	// add mapping for PUT /employee/id - update existing employee
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Employee updateEmpl(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) {	
		
		Employee employee = null;
		if( null != employeeDto && null != id) {
			employee = employeeService.updateEmployee(employeeDto, id);
		}

		return employee;
	}
	
	// add mapping for DELETE /employee/id - delete employee
	
	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Long deleteEmpl(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return id;
	}
	
}
