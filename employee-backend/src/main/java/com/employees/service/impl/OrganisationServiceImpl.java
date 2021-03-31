package com.employees.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.dao.OrganisationRepository;
import com.employees.dto.OrganisationDto;
import com.employees.entity.Employee;
import com.employees.entity.Organisation;
import com.employees.service.OrganisationService;

@Service
@Transactional
public class OrganisationServiceImpl implements OrganisationService {
	
	private static final Logger log = LoggerFactory.getLogger(OrganisationServiceImpl.class);
	
	@Autowired
    private OrganisationRepository organisationRepository;
	
	@Override
	public List<Organisation> findAll() {
		return organisationRepository.findAll();
	}
	
	@Override
	public Organisation findById(Long id) {		
		return organisationRepository.findById(id).orElse(null);
	}
	
	@Override
	public Organisation saveOrganisation(OrganisationDto organisationDto) {
		Organisation organisation = new Organisation(organisationDto.getName(), organisationDto.getBusinessRegistrationNumber(),
				organisationDto.getAddress());
		return organisationRepository.save(organisation);
	}
	
	@Override
	public Organisation updateOrganisation(OrganisationDto organisationDto, Long id) {
		Organisation organisation = null;
		if( null != id) {
			organisation = organisationRepository.findById(id).orElse(null);			
		}
		if( null != organisation ) {
			organisation.setName(organisationDto.getName());
			organisation.setBusinessRegistrationNumber(organisationDto.getBusinessRegistrationNumber());
			organisation.setAddress(organisationDto.getAddress());
		}else {
			return organisation;
		}
				
		return organisationRepository.save(organisation);
	}
	
	@Override
	public void deleteOrganisation(Long id) {
		Organisation organisation = null;
		if(null != id){
			organisation = organisationRepository.findById(id).orElse(null);
		}
		if( null != organisation ) {
			organisationRepository.deleteById(id);
		}else {
			throw new RuntimeException("Organisation with id not found - " + id);
		}
	}
	
	

}
