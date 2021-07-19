package com.book.Dao;

import java.util.List;

import com.book.pojo.Customer;

public interface CustomerDao {

	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomer(int custId);
	List<Customer>showAllCustomers();	
	Customer searchCustomerById(int custId);
	List<Customer>searchCustomerByName(String custName);
	List<Customer>searchCustomerByEmail(String custEmail);
	
}
