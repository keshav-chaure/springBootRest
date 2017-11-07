package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.howtodoinjava.demo.model.Employee;

@RestController
public class EmployeeController {
	List<Employee> employeesList = new ArrayList<Employee>();
	
	//@RequestMapping(value="employee/getAll",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	
	@RequestMapping(value = "employee/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getEmployees() 
    {
		//List<Employee> employeesList = new ArrayList<Employee>();
		employeesList.add(new Employee(1,"lokesh","gupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(2,"mokesh","hupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(3,"nokesh","iupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(4,"ookesh","gupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(5,"pokesh","gupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(6,"qokesh","gupta","howtodoinjava@gmail.com"));
		employeesList.add(new Employee(7,"rokesh","gupta","howtodoinjava@gmail.com"));
		return employeesList;
    }
	@RequestMapping(value = "employee/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployee(@PathVariable String id) 
    {
				return employeesList.get(Integer.parseInt(id));
    }
	 

	 @RequestMapping(value = "/employee", method = RequestMethod.POST, headers = "Accept=application/json")
	 public boolean addCountry(@RequestBody Employee employee) {
	  return employeesList.add(employee);
	 }


}
