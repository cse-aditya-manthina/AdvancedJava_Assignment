package com.capgemini.hibernate.hybernate2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String accountNumber;
	private String accountType;
	
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	public Account() {
		
	}

	/**
	 * @param id
	 * @param accountNumber
	 * @param accountType
	 * @param customer
	 */
	public Account(Long id, String accountNumber, String accountType, Customer customer) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.customer = customer;
	}

	/**
	 * @return the id
	 */
	public final Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the accountNumber
	 */
	public final String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public final void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the accountType
	 */
	public final String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public final void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the customer
	 */
	public final Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public final void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
