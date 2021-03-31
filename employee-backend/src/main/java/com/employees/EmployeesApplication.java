package com.employees;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.employees.util.GenericModelMapper;

//@ComponentScan(basePackages = "com.employees")
@Configuration
//@EntityScan(basePackages={"com.employees.entity"})
//@EnableJpaRepositories(basePackages = "com.employees.dao")
@SpringBootApplication
public class EmployeesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeesApplication.class, args);
	}
	
	@Bean
	public GenericModelMapper modelMapper() {
	    return new GenericModelMapper(new ModelMapper());
	}

}
