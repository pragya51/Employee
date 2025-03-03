package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pack.model.Employee;
import com.pack.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee saveEmp(@RequestBody Employee employee) {
		return service.saveEmp(employee);
	}
    
	@GetMapping("Employee")
	public List<Employee> getEmp(){
		return service.getEmployee();
	}
	@GetMapping("Employee/{id}")
	public  ResponseEntity<Employee> getEmpById(@PathVariable long id){
		Employee emp=service.getEmpById(id);
		if(emp==null) return new ResponseEntity<Employee>(emp,HttpStatus.NOT_FOUND);
		else return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}
	
	@PutMapping("Employee/{id}")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp,@PathVariable int id){
		Employee emp1=service.getEmpById(id);
		if(emp1==null) {
			return new ResponseEntity<Employee>(emp1,HttpStatus.NOT_FOUND);
		}
		else {
			emp1.setName(emp.getName());
			emp1.setDesignation(emp.getDesignation());
			//emp1.setInsScheme(emp.getInsScheme());
			emp1.setSalary(emp.getSalary());
		    service.saveEmp(emp1);
		    return new ResponseEntity<Employee>(emp1,HttpStatus.OK);
		}
		
		
	}
	@DeleteMapping("Employee/{id}")
	public ResponseEntity<Object>delEmp(@PathVariable int id){
		Employee emp1=service.getEmpById(id);
		if(emp1==null) {
			return ResponseEntity.notFound().build();
		}
		
		else {
			 service.removeEmp(emp1);
			 return ResponseEntity.ok().build();
		}
		
	}
}
