package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.Dao.OrderDao;
import com.book.Dao.OrderDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
	
		int orderId,choice;
		String orderDate,orderStatus,custEmail;
		double totalPrice;
		boolean flag;
		char ch;
		
		Scanner scan=new Scanner(System.in);
		Order o= new Order();
		OrderDao od=new OrderDaoImpl();
		
		do {
			System.out.println("------Orders---------");
			System.out.println("1.PLace Order");
			System.out.println("2.Show All Order");
			System.out.println("3.Show My Order");
			System.out.println("4.Cancel Order");
			System.out.println("----------Enter Your Choice-------");
			choice=scan.nextInt();
			
		switch(choice) {
		case 1:
		
			System.out.println("Enter Customer Email");
			custEmail=scan.next();
			
			o=od.placeOrder(custEmail);			
			
			if(o!=null) {
				System.out.println("Order Placed Successfully.........");
				System.out.println(o);
			}
			else {
				System.out.println("Order not placed.......");
			}
			
			
		break;
		
		case 2:
			System.out.println("-----show all Orders--------");
			List<Order> list=od.showAllOrders();
			
			if(list!=null) {
				for(Order o1:list) {
					System.out.println(o1);
				}
				
			}else {
				System.out.println("Order list is empty!!!!!!!");
			}
		break;	
			
		case 3:	
			System.out.println("Enter your email Id");
			String email=scan.next();
			List<Order> lst=od.showMyOrders(email);
			if(lst!=null) {
				for(Order o1:lst) {
					System.out.println(o1);
					
				}
				
			}
			else
				System.out.println("No Orders Placed");
			
			
			
		break;	
			
		case 4:	
			System.out.println("Enter Order Id to Cancel Order:");
			orderId=scan.nextInt();
			if(od.cancelOrder(orderId)) {
				System.out.println("Order cancellation Successfull");
				
			}
			else
				System.out.println("Unable to Cancel Order");
			
			
		break;	
			
		default:	
			System.out.println("Wrong Choice ENtered........");
			break;
		}
			
		System.out.println("Do you Want to continue...if yes then Enter y");	
			ch=scan.next().charAt(0);
			
		}while(ch=='Y' || ch=='y');
			
	}
		
	}


