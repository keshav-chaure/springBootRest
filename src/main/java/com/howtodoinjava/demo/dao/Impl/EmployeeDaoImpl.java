package com.howtodoinjava.demo.dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.howtodoinjava.demo.dao.EmployeeDao;
import com.howtodoinjava.demo.model.Employee;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	
	@Override
	public List getAllEmployee() {
		
		Session session =sessionFactory.openSession();
		List<Employee> employeesList = session.createQuery("from Employee").list();
		for(Employee p : employeesList){
			System.out.println("employeesList::"+p);
		}
		return employeesList;
		
	}

	@Override
	public Employee get(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Employee e = (Employee) session.get(Employee.class, new Integer(id));
	//	logger.info("Person loaded successfully, Person details="+e);
		return e;
	}

	@Override
	public int addEmployee(Employee e) {
		int result=1;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.save(e);
			System.out.println("persist in db"+e);
		} catch(Exception ex){
			 result=0;
		} 
		
		 return result;
	}
	

}
