package com.employees.util;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import com.employees.dto.EmployeeDto;
import com.employees.dto.OrganisationDto;
import com.employees.entity.Employee;
import com.employees.entity.Organisation;



public class GenericModelMapper {
	
	private ModelMapper modelMapper;
		
	public GenericModelMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}	
	
	public ModelMapper getModelMapper() {
		return modelMapper;
	}
	
	public List<EmployeeDto> convertEmployeesToDto(List<Employee> employees) {

		Type listType = new TypeToken<List<EmployeeDto>>() {}.getType();
		List<EmployeeDto> result = modelMapper.map(employees, listType);
		return result; 		
	}
	
	public EmployeeDto convertEmployeeToDto(Employee employee) {

		Type listType = new TypeToken<EmployeeDto>() {}.getType();
		EmployeeDto result = modelMapper.map(employee, listType);
		return result; 		
	}
	
	public List<OrganisationDto> convertOrganisationsToDto(List<Organisation> organisations) {

		Type listType = new TypeToken<List<OrganisationDto>>() {}.getType();
		List<OrganisationDto> result = modelMapper.map(organisations, listType);
		return result; 		
	}
	
	public OrganisationDto convertOrganisationToDto(Organisation organisation) {

		Type listType = new TypeToken<OrganisationDto>() {}.getType();
		OrganisationDto result = modelMapper.map(organisation, listType);
		return result; 		
	}
	
	
}
