package com.employees.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.EmployeeRepository;
import com.employees.dto.EmployeeDto;
import com.employees.entity.Employee;
import com.employees.entity.Organisation;
import com.employees.service.EmployeeService;
import com.employees.service.OrganisationService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Autowired
	private OrganisationService organisationService;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(Long id) {		
		return employeeRepository.findById(id).orElse(null);
	}
	
	@Override
	public Employee saveEmployee(EmployeeDto employeeDto) {
		Organisation organisation = null;
		if( null != employeeDto.getOrganisation() && null != employeeDto.getOrganisation().getId() ){
			organisation = organisationService.findById(employeeDto.getOrganisation().getId());
		}	
		Employee  employee = new Employee(employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getEmail(),
				employeeDto.getAddress(), employeeDto.getMobilePhoneNumber(), 
				organisation);
		
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(EmployeeDto employeeDto, Long id) {
		
		Employee  employee = employeeRepository.findById(id).orElse(null);
		Organisation organisation = null;
		if(null != employeeDto.getOrganisation() && null != employeeDto.getOrganisation().getId() ){
			organisation = organisationService.findById(employeeDto.getOrganisation().getId());
		}	
		if( null != employee) {
			employee.setFirstName(employeeDto.getFirstName());
			employee.setLastName(employeeDto.getLastName());
			employee.setEmail(employeeDto.getEmail());
			employee.setAddress(employeeDto.getAddress());
			employee.setMobilePhoneNumber(employeeDto.getMobilePhoneNumber());
			employee.setOrganisation(organisation);
			
		}else {
			return employee;
		}
				
		return employeeRepository.save(employee);
	}
	
	@Override
	public void deleteEmployee(Long id) {
		Employee employee = null;
		if(null != id){
			employee = employeeRepository.findById(id).orElse(null);
		}
		if( null != employee ) {
			employeeRepository.deleteById(id);
		}else {
			throw new RuntimeException("Employee with id not found - " + id);
		}
	}
	

}
