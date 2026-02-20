package com.capgemini.hibernate.EmployeeHybernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Locker {
	
	@Id
	int lockerId;
	int lockerNumber;
	int floor;
	
	@OneToOne
	private Employee employee;
	
	public Locker() {
		
	}

	/**
	 * @param lockerId
	 * @param lockerNumber
	 * @param floor
	 * @param employee
	 */
	public Locker(int lockerId, int lockerNumber, int floor, Employee employee) {
		super();
		this.lockerId = lockerId;
		this.lockerNumber = lockerNumber;
		this.floor = floor;
		this.employee = employee;
	}

	/**
	 * @return the lockerId
	 */
	public final int getLockerId() {
		return lockerId;
	}

	/**
	 * @param lockerId the lockerId to set
	 */
	public final void setLockerId(int lockerId) {
		this.lockerId = lockerId;
	}

	/**
	 * @return the lockerNumber
	 */
	public final int getLockerNumber() {
		return lockerNumber;
	}

	/**
	 * @param lockerNumber the lockerNumber to set
	 */
	public final void setLockerNumber(int lockerNumber) {
		this.lockerNumber = lockerNumber;
	}

	/**
	 * @return the floor
	 */
	public final int getFloor() {
		return floor;
	}

	/**
	 * @param floor the floor to set
	 */
	public final void setFloor(int floor) {
		this.floor = floor;
	}

	/**
	 * @return the employee
	 */
	public final Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public final void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
