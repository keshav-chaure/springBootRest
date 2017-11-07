package com.howtodoinjava.demo.service;

import java.util.List;

import com.howtodoinjava.demo.model.Employee;

public interface EmployeeService {
	public List<Employee>  getAll();
	public Employee get(int id);
	public int addEmployee(Employee e);
	public Employee updateEmployee(Employee e);
	public void deleteEmployee(int id);

}
