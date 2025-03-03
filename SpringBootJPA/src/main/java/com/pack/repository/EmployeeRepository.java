package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pack.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
//public List<Employee> findByDesig(String desig);
	
	
	 @Query("select e from Employee e where e.desig = :des") List<Employee>
	 findByDesigg(@Param("des") String desig);
	 
}


