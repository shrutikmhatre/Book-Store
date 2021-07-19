package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.Dao.CustomerDao;
import com.book.Dao.CustomerDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		
		int custId, choice;
		String custName, custEmail, custPassword, custContact, custAddress;
		boolean flag;
		char ch;
		
		Scanner scan=new Scanner(System.in);
		Customer customer= new Customer();
		CustomerDao cd = new CustomerDaoImpl();
		
		do {
			System.out.println("------Customer-------");
			System.out.println("1.Add Customer");
			System.out.println("2.Update Customer");
			System.out.println("3.Delete Customer");
			System.out.println("4.Show All Customer");
			System.out.println("5.Search Customer");
			System.out.println("------Enter your choice-------");
			choice=scan.nextInt();
			
			switch(choice) {
			
			case 1:
				System.out.println("---Add Customer-------");
				
				System.out.println("Enter Customer Name");
				custName=scan.next();
				System.out.println("Enter Customer Email");
				custEmail=scan.next();
				System.out.println("Enter Customer Password");
				custPassword=scan.next();
				System.out.println("Enter Customer Contact");
				custContact=scan.next();
				System.out.println("Enter Customer Address");
				custAddress=scan.next();
				
			customer =new Customer(custName, custEmail, custPassword, custContact, custAddress);
			flag=cd.addCustomer(customer);
			
			if(flag) {
				System.out.println("Customer Added Successfully.........");
			}
			else {
				System.out.println("Customer not added....");
			}
				
				break;
			
			case 2: 
				System.out.println("----------Update Customer--------");
				System.out.println("Enter Customer Id which you want to update....");
				custId=scan.nextInt();
				
				System.out.println("Enter Customer Name");
				custName=scan.next();
				System.out.println("Enter Customer Email");
				custEmail=scan.next();
				System.out.println("Enter Customer Password");
				custPassword=scan.next();
				System.out.println("Enter Customer Contact");
				custContact=scan.next();
				System.out.println("Enter Customer Address");
				custAddress=scan.next();
				
			customer =new Customer(custId,custName, custEmail, custPassword, custContact, custAddress);
			flag=cd.updateCustomer(customer);
				
			if(flag) {
				System.out.println("Customer Updated Successfully.........");
			}
			else {
				System.out.println("Customer not updated....");
			}
				
				break;
		
			case 3:
				System.out.println("-----Delete customer--------");
				System.out.println("Enter customer Id");
				custId=scan.nextInt();
				
				flag= cd.deleteCustomer(custId);
				
				if(flag) {
					System.out.println("Customer Deleted Successfully.....");
				}
				else {
					System.out.println("Customer Not Deleted....");
				}
				break;
				
			case 4:	
				System.out.println("-----show all Customer--------");
				List<Customer> list=cd.showAllCustomers();
				
				if(list!=null) {
					for(Customer c:list) {
						System.out.println(c);
					}
					
				}else {
					System.out.println("Customer list is empty!!!!!!!");
				}
				
				break;
				
			case 5:
				System.out.println("--------Search Customer------");
				System.out.println("1. Search Customer By Id");
				System.out.println("2. Search Customer By Name");
				System.out.println("3. Search Customer By Email");
				System.out.println("--------Enter your choice-------");
				choice=scan.nextInt();
				
				switch (choice) {
				case 1: 
				System.out.println("-----Search Customer By Id-------");
				System.out.println("Enter Customer Id");
				custId=scan.nextInt();

				Customer c=cd.searchCustomerById(custId);
				
				if(c!=null) {
					System.out.println(c);
				}
				else {
					System.out.println("No such customer available........");
				}
				break;	
				
				case 2:
					System.out.println("--------Search Customer By Name-------");	
					System.out.println("Enter Customer Name...");
					custName=scan.next();
					
					List<Customer> custlist=cd.searchCustomerByName(custName);
					
					if(custlist.isEmpty()) {
					System.out.println("NO such Customer Avaialable.......");
					}
					else
						for(Customer c1:custlist) {
						
						System.out.println(c1);
					}
				break;
				
				case 3:
					
					System.out.println("--------Search Customer By Email-------");	
					System.out.println("Enter Customer Email...");
					custEmail=scan.next();
					
					List<Customer> custlist1=cd.searchCustomerByEmail(custEmail);
					
					if(custlist1.isEmpty()) {
					System.out.println("NO such Email Avaialable.......");
					}
					else
						for(Customer c1:custlist1) {
						
						System.out.println(c1);
					}
					
				break;
				
			default:
				System.out.println("Wrong choice entered........");
				
			}
			}
			System.out.println("Do you Want to continue.....if yes then enter y");	
			ch=scan.next().charAt(0);
		}while(ch=='y' || ch=='Y');	
		}
	}
		

