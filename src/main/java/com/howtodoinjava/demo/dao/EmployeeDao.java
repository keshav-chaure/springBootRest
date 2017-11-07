package com.howtodoinjava.demo.dao;

import java.util.List;

import com.howtodoinjava.demo.model.Employee;

public interface EmployeeDao {
	public List getAllEmployee();
	public Employee get(int id);
	public int addEmployee(Employee e);
}
