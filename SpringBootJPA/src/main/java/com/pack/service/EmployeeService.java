package com.pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.model.Employee;
import com.pack.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	public void addEmployee(Employee employee) {
		
		empRepo.save(employee);
		
	}
	
	public List<Employee> viewAll(){
		return empRepo.findAll();
	}
	
	public void deleteEmployeeById(int eno) {
        empRepo.deleteById(eno);
    }
	
	public List<Employee> viewOnDesig(String desig)
	  {
		  return empRepo.findByDesigg(desig);
		  
	  }
	
	public void updateEmployee(Employee employee)
	  
	  { empRepo.save(employee);
	 
	  
	  }
	  


}
