package com.pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pack.exception.EmployeeNotFoundException;
import com.pack.model.Employee;
import com.pack.service.EmployeeService;


//import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "index";
		
	}
	
	@RequestMapping("/addEmp")
	public String addEmp(Model m) {
		m.addAttribute("empBean",new Employee());
		return "emp";
		
	}
	
	@ RequestMapping("/empsave")
	public String saveEmp(@ModelAttribute("empBean") Employee e) {
		
		empService.addEmployee(e);
		return "success";
		
	}
	
	@RequestMapping("/viewform")
	public String viewemp(Model m) {
		List<Employee> list=empService.viewAll();
		m.addAttribute("list",list);
		return "view";
	}
	
	@RequestMapping("/delete")
	public String del(Model m) {
		m.addAttribute("empBean", new Employee());
		return "getID";
	}
	@RequestMapping("/deleteid")
    public String deleteEmployee(@RequestParam("eno") int eno, Model m) {
        empService.deleteEmployeeById(eno);
        m.addAttribute("message", "Employee deleted successfully!");
        return "redirect:/viewform"; // Redirect to the page showing all employees
    }
	@RequestMapping("/customQuery") 
	  public String viewByDesig()
	  {

		  return "customQuery";
	  }
	
	@RequestMapping("/viewByDesig") 
	  public String findByDesig(@RequestParam("desig")String desig,Model m) {

		  List<Employee> emps= empService.viewOnDesig(desig);
		  if(emps.isEmpty()) {
			  m.addAttribute("message", "No employee found with the designation: " + desig);
		  }
		  else {
		  m.addAttribute("list", emps);
		 
		  }
		  return "view";

	  }
	/*
	@RequestMapping(value="/update", method = RequestMethod.POST)  
	public String update(@RequestParam("eno") int  eno,Model m)
	{
		Employee employee=null;
		String page=null;
		try
				{
		 if (empService.getEmployeeById(eno).isPresent())
		 {
			  employee=empService.getEmployeeById(eno).get();
			  m.addAttribute("updateBean", employee);
			  page="showUpdateForm";
			 
		 }
		 else if (empService.getEmployeeById(eno).isEmpty())
		 {
			 System.out.println("emp "+employee);
		  throw new EmployeeNotFoundException();
		   
			  }
			}
			  catch(EmployeeNotFoundException e)
			  {
				  m.addAttribute("exception",e);
			    	page="ExceptionPage";
				 
			  }

	     return page;
	}*/

}
