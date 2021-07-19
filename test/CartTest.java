package com.book.test;

import java.util.List;
import java.util.Scanner;

import com.book.Dao.CartDao;
import com.book.Dao.CartDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.pojo.Customer;

public class CartTest {

	public static void main(String[] args) {
		
		int cartID, bookId, choice, quantity;
		String custEmail, bookName;
		double bookPrice;
		boolean flag;
		char ch;
		
		Scanner scan=new Scanner(System.in);
		Cart ca=new Cart();
		CartDao cad=new CartDaoImpl();
		
		do {
			System.out.println("------Cart-------");
			System.out.println("1.Add To Cart");
			System.out.println("2.Update Cart");
			System.out.println("3.Remove From Cart");
			System.out.println("4.Show Cart");
			System.out.println("5.Search From Cart");
			System.out.println("6.Clear Cart ");
			System.out.println("------Enter your choice-------");
			choice=scan.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("-----Add To Cart------");
				System.out.println("Enter Book Id");
				bookId=scan.nextInt();
				System.out.println("Enter Customer Email ");
				custEmail=scan.next();
				System.out.println("Enter Quantity");
				quantity=scan.nextInt();
				
				ca=new Cart(bookId, custEmail,quantity);
				flag=cad.addToCart(ca);
				
				if(flag) {
					System.out.println("Book Added SuccessFully into Cart........");
				}
				else {
					System.out.println("Book Not Added in cart......");
				}
				break;
				
			case 2:
				System.out.println("----------Update Cart--------");
				System.out.println("Enter Cart Id which you want to update....");
				int cartId=scan.nextInt();
				System.out.println("Enter Book Id");
				bookId=scan.nextInt();
				System.out.println("Enter Customer Email ");
				custEmail=scan.next();
				System.out.println("Enter Quantity");
				quantity=scan.nextInt();
				
				ca=new Cart(cartId, bookId, custEmail, quantity);
				flag=cad.updateCart(ca);
				
			if(flag) {
				System.out.println("Cart Updated Successfully.........");
			}
			else {
				System.out.println("Cart not updated....");
			}
				
				break;
				
			case 3:
				System.out.println("----Remove from cart-------");
				System.out.println("1.Remove from cart by id");
				System.out.println("2.Remove from cart by customer Email");
				System.out.println("----ENter Your Choice-------");
				choice=scan.nextInt();
				
		switch (choice) {
			case 1:
				System.out.println("-----remove cart by id--------");
				System.out.println("Enter Id");
				int custId=scan.nextInt();
				
				flag= cad.removeFromCartByCartId(custId);
				
				if(flag) {
					System.out.println("Book removed from cart Successfully.....");
				}
				else {
					System.out.println("Book Not removed from cart....");
				}
				break;
				
			case 2:
				System.out.println("--------remove cart by customer email------");
				System.out.println("Enter customer email");
				custEmail=scan.next();
				
				flag=cad.clearCart(custEmail);
				
				if(flag) {
					System.out.println("Cleared  from cart successfully of"+custEmail);
				}	
				else {	
					System.out.println("Cart Not cleared......");
				}	
				}
				
				break;
				
			case 4: 
				System.out.println("-----show cart-------");
				List<Cart> list=cad.showCart();
				
				if(list.isEmpty()) {
					System.out.println("Cart list is Empty");
				}
				else {
						for(Cart ca1:list) {
							System.out.println(ca1);
							
						}	
						}
				break;
				
			case 5:
				System.out.println("Search By:");
				System.out.println("1.Search Cart By CartID");
				System.out.println("2.Search By Email");
				int select=scan.nextInt();
				
				switch(select) {
				
				case 1:
					System.out.println("Enter CartId:");
					cartID=scan.nextInt();
					Cart c=cad.searchFromCartByCartId(cartID);
				
				if(c!=null) {
					System.out.println(c);
				}
				else {
					System.out.println("No such CartID available........");
				}
				break;	
				
				case 2:
					System.out.println("Enter Customer Email:");
					String email=scan.next();
					List<Cart> cartlist=cad.searchFromCartBycustEmail(email);				
				

					if(cartlist.isEmpty()) {
					System.out.println("NO such Customer email Avaialable.......");
					}
					else
						for(Cart c1:cartlist) {
						
						System.out.println(c1);
					}
					
		
					break;
				}
				break;
			case 6:
				System.out.println("Enter Customer Email to Clear:");
				String email=scan.next();
				flag=cad.clearCart(email);
				if(flag)
					System.out.println("Deleted cart successfully");
				
				else
					System.out.println("Unable to delete cart");
				
				break;
				default:
					System.out.println("Wrong choice entered........");
					break;
			}
			
				System.out.println("DO you want to continue.....if yes then enter y");
				ch=scan.next().charAt(0);
				
			}while(ch=='y' || ch=='Y');		
	}

}
