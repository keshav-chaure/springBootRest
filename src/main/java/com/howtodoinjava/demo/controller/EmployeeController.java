package com.howtodoinjava.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	 /*
	 {
	//"id": "3",
	"firstName": "rawan",
	"lastName": "lankesh",
	"gender": "M",
	"dob": "2011-01-01",
	"doj": "2017-01-12"
	}
	use post method with application/json as header Accept
	  	  */

	 @RequestMapping(value = "/employee/add", method = RequestMethod.POST, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
	 public int addEmployee(@RequestBody Employee employee) {
		 System.out.println("$$$$:"+employee.getId());
		 return employeeService.addEmployee(employee);
	 }
	 
	 @RequestMapping(value = "/employee/update", method = RequestMethod.PUT, headers = "Accept=application/json", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Employee> updateArticle(@RequestBody Employee employee) {
			employeeService.updateEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
	 @RequestMapping(value = "employee/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
			employeeService.deleteEmployee(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}


}
