package com.employees.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employees.entity.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
	
	
}
