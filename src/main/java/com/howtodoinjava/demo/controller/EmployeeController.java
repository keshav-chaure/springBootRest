package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;
import com.howtodoinjava.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	List<Employee> employeesList = new ArrayList<Employee>();
	
	@Autowired
	private EmployeeService employeeService;
	/*
	@Autowired(required=true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService es){
		this.employeeService = es;
	}
	*/
	//@RequestMapping(value="employee/getAll",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
	@RequestMapping(value = "employee/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployees() 
    {
		System.out.println(employeeService);
		return employeeService.getAll();
		
    }
	@RequestMapping(value = "employee/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable String id) 
    {
				return employeeService.get(Integer.parseInt(id));
    }
	 

	 @RequestMapping(value = "/employee", method = RequestMethod.POST, headers = "Accept=application/json")
	 public boolean addCountry(@RequestBody Employee employee) {
	  return employeesList.add(employee);
	 }


}
