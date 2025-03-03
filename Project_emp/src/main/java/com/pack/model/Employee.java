package com.pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee6")
public class Employee { 

	
	 public Employee(String name, String designation, float salary) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}

	public Employee()
	 {
		 
		 
	 }
	 
	public String getName() {
		return name;
	}
	
	 	 
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getInsScheme() {
		return insScheme;
	}
	public void setInsScheme(String insScheme) {
		this.insScheme = insScheme;
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="empname")
	private String name;
	
	@Column(name="desig")
	private String designation;
	
	@Column(name="salary")
	private float salary;
	
	@Column(name="ins_scheme")
	private  String insScheme;
}
