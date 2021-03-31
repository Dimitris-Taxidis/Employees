package com.employees.service;

import java.util.List;

import com.employees.dto.OrganisationDto;
import com.employees.entity.Organisation;

public interface OrganisationService {

	List<Organisation> findAll();
	
	Organisation findById(Long id);
	
	Organisation saveOrganisation(OrganisationDto organisationDto);
	
	Organisation updateOrganisation(OrganisationDto organisationDto, Long id);
	
	void deleteOrganisation(Long id);
	
}
