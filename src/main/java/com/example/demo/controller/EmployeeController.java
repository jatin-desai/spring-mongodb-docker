package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepo;
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee create (@RequestBody Employee emp) {
		Employee result = employeeRepo.insert(emp);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public Collection<Employee> getEmployeeList() {
		return employeeRepo.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{employeeId}")
	public Employee getEmployee(@PathVariable String employeeId) {
		return employeeRepo.findOne(employeeId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{employeeId}")
	public String delete(@PathVariable String employeeId) {
		employeeRepo.delete(employeeId);
		return "Success" ;
	}
}
