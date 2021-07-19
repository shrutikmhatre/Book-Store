package com.book.pojo;

public class Customer {

	private int custId;
	String custName;
	String custEmail;
	String custPassword;
	String custContact;
	String custAddress;
	
	//Non par const
			public Customer() {
			super();
			}
			
//			const without custId , with remaining field

	public Customer(String custName, String custEmail, String custPassword, String custContact, String custAddress) {
		super();
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custContact = custContact;
		this.custAddress = custAddress;
	}
	
//	const with all field

	public Customer(int custId, String custName, String custEmail, String custPassword, String custContact,
			String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custPassword = custPassword;
		this.custContact = custContact;
		this.custAddress = custAddress;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustContact() {
		return custContact;
	}

	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custEmail=" + custEmail + ", custPassword="
				+ custPassword + ", custContact=" + custContact + ", custAddress=" + custAddress + "]";
	}
		
}
