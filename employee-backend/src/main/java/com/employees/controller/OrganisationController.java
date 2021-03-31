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

import com.employees.dto.OrganisationDto;
import com.employees.entity.Organisation;
import com.employees.service.OrganisationService;
import com.employees.util.GenericModelMapper;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class OrganisationController {

//	private static final Logger log = LoggerFactory.getLogger(OrganisationController.class);

	@Autowired
	private OrganisationService organisationService;
	
	@Autowired
	private GenericModelMapper modelMapper;
	
	// expose "/organisations" and return list of organisations
	
	@RequestMapping(value = "/organisations", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<OrganisationDto> findAll() {
		List<Organisation> organisations = organisationService.findAll();
		if( organisations.isEmpty() ) {
			return null;
		}
		List<OrganisationDto> organisationsDto = modelMapper.convertOrganisationsToDto(organisations);
		return organisationsDto;
	}
	
	// add mapping for GET /organisation/id
	
	@RequestMapping(value = "/organisation/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public OrganisationDto getOrganisation(@PathVariable Long id) {
		
		Organisation organisation = organisationService.findById(id);		
		OrganisationDto organisationsDto = null;
		if( null != organisation ) {
			organisationsDto = modelMapper.convertOrganisationToDto(organisation);
		}
		return organisationsDto;
	}
	
	// add mapping for POST /organisation - add new organisation
	
	@RequestMapping(value = "/organisation", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Organisation addOrganisation(@RequestBody OrganisationDto organisationDto) {	
		Organisation organisation = null;
		if( null != organisationDto ) {
			organisation = organisationService.saveOrganisation(organisationDto);
		}

		return organisation;
	}
	
	// add mapping for PUT /organisation/id - update existing organisation
	
	@RequestMapping(value = "/organisation/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Organisation updateOrg(@RequestBody OrganisationDto organisationDto, @PathVariable Long id) {	

		Organisation organisation = null;
		if( null != organisationDto && null != id ) {
			organisation = organisationService.updateOrganisation(organisationDto, id);
		}
		
		return organisation;
	}
	
	// add mapping for DELETE /organisation/id - delete organisation
	
	@RequestMapping(value = "/organisation/{id}", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public void deleteOrg(@PathVariable Long id) {
		organisationService.deleteOrganisation(id);
	}
	
}
