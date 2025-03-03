package com.pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import com.pack.model.Employee;
import com.pack.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public Employee saveEmp(Employee employee) {
		if(employee.getSalary()>5000f) {
			employee.setInsScheme("A");
		}
		else employee.setInsScheme("B");
		
		return repository.save(employee);
	}
	public List<Employee> getEmployee(){
		return repository.findAll();
	}
	
	public Employee getEmpById(long id) {
		Optional<Employee>emp=repository.findById(id);
		if(emp.isPresent()) return emp.get();
		else return null;
	}
	public void removeEmp(Employee emp) {
		repository.remove(emp);
	}


}
