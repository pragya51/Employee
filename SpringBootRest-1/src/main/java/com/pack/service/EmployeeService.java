package com.pack.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pack.model.Employee;
import com.pack.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	EmployeeRepository emp;
	//Set<Employee> emp=new HashSet<Employee>();
	
	/*public EmployeeService() {
		emp.add(new Employee("puja","postman",7000));
		emp.add(new Employee("Reena","clerk",9000));
		emp.add(new Employee("raju","peon",10000));
	}*/

	/*
	public Employee getProductById(int id) {
		Employee empid=emp.stream().filter(p->p.getId()==id).findAny().orElse(null);
		
		return empid;
	}*/
    public Employee addEmployee(Employee employee) {
    	emp.add(employee);
		
		emp.save(employee);
		return employee;
		
	}
	
	
}
