package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Employee;

@RepositoryRestResource(collectionResourceRel="staff", path = "staff")
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	
	public List<Employee> findByEmail(@Param("email") String email);

}
