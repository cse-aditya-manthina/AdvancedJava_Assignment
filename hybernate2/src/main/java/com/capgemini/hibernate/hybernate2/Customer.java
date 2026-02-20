package com.capgemini.hibernate.hybernate2;


@Entity
public class Customer {
	@Id
	@GenaratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="account_id", referencedColumn)
	private Account account;
	
	public Customer() {
		  
	}

	/**
	 * @param id
	 * @param name
	 * @param account
	 */
	public Customer(Long id, String name, Account account) {
	
		this.id = id;
		this.name = name;
		this.account = account;
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
	 * @return the account
	 */
	public final Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public final void setAccount(Account account) {
		this.account = account;
	}
	
	

}
