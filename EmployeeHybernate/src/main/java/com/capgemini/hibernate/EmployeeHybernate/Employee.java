package com.capgemini.hibernate.EmployeeHybernate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int employeeId;
	String name;
	String department;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn()
	private Locker locker;
	
	
	public Employee() {
		
	}

	/**
	 * @param employeeId
	 * @param name
	 * @param department
	 */
	public Employee(int employeeId, String name, String department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
	}

	/**
	 * @return the employeeId
	 */
	public final int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public final void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public final String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public final void setDepartment(String department) {
		this.department = department;
	}
	

}
