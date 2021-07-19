package com.book.test;

import java.util.List;
import java.util.Scanner;
import com.book.Dao.BookDao;
import com.book.Dao.BookDaoImpl;
import com.book.pojo.Book;

public class BookTest {
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
			Book book;
			BookDao bd=new BookDaoImpl();
			int bookId;
			String bookName,authorName,publisherName;
			double rating,numberOfCopies,price;
			boolean flag;
			int choice;
			char ch;
			do {
			System.out.println("-----Book Store----");
			
			System.out.println("1.Add Book");
			System.out.println("2.Update Book");
			System.out.println("3.Delete Book By ID");
			System.out.println("4.Show All Books");
			System.out.println("5.Search Book");
		
			System.out.println("Enter Your Choice");
			choice=scan.nextInt();
		switch(choice) {
		
		case 1:
			System.out.println("-----Enter Book Details----- ");
		
			System.out.println("Enter Book Name");
			bookName=scan.next();
			System.out.println("Enter Author Name");
			authorName=scan.next();
			System.out.println("Enter Publisher Name");
			publisherName=scan.next();
			System.out.println("Enter Rating");
			rating=scan.nextDouble();
			System.out.println("Enter Number Of Copies");
			numberOfCopies=scan.nextDouble();
			System.out.println("Enter Book Price");
			price=scan.nextDouble();
			book=new Book(bookName, authorName, publisherName, rating, numberOfCopies,price);
			
			flag=bd.addBook(book);
			if(flag) {
				
				System.out.println("Book Added successfully");
			}
			else {
				
				System.out.println("Unable To Add Book");
			}
		
		break;
		
		case 2:
			System.out.println("----------Update book--------");
			System.out.println("Enter Book Id which you want to update....");
			bookId=scan.nextInt();
			
			
			System.out.println("Enter Book Name");
			bookName=scan.next();
			System.out.println("Enter Author Name");
			authorName=scan.next();
			System.out.println("Enter Publisher Name");
			publisherName=scan.next();
			System.out.println("Enter Rating");
			rating=scan.nextDouble();
			System.out.println("Enter no_of_copies");
			numberOfCopies=scan.nextDouble();			
			System.out.println("Enter Book Price");
			price=scan.nextDouble();
			
			book=new Book(bookId,bookName, authorName,publisherName, rating, numberOfCopies, price);
			flag=bd.updateBook(book);
			
			if(flag) {
				System.out.println("Book Updated Successfully.........");
			}
			else {
				System.out.println("Book not updated....");
			}
			
			break;
	
		case 3:
			System.out.println("-----Delete books--------");
			System.out.println("Enter Book Id");
			bookId=scan.nextInt();
			
			flag= bd.deleteBook(bookId);
			
			if(flag) {
				System.out.println("Book Deleted Successfully.....");
			}
			else {
				System.out.println("Book Not Deleted....");
			}
			break;
		
		case 4:
			
			
			System.out.println("-----show all books--------");
			List<Book> list=bd.showAllBooks();
			
			if(list!=null) {
				for(Book b:list) {
					System.out.println(b);
				}
				
			}else {
				System.out.println("Book list is empty!!!!!!!");
			}
			
			break;
		
	
			
			
		case 5:
			System.out.println("--------Search Book------");
			System.out.println("1. Search Book By Id");
			System.out.println("2. Search Book By Name");
			System.out.println("--------Enter your choice-------");
			choice=scan.nextInt();
			
			switch (choice) {
			case 1: 
			System.out.println("-----Search Book By Id-------");
			System.out.println("Enter Book Id");
			bookId=scan.nextInt();

			Book b=bd.searchBookById(bookId);
			
			if(b!=null) {
				System.out.println(b);
			}
			else {
				System.out.println("No such book available........");
			}
			break;	
				
			case 2:
				System.out.println("--------Search Book By Name-------");	
				System.out.println("Enter Book Name...");
				bookName=scan.next();
				
				List<Book> booklist=bd.searchBookByName(bookName);
				
				if(booklist.isEmpty()) {
				System.out.println("NO such Book Avaialable.......");
				}
				else
					for(Book b1:booklist) {
					
					System.out.println(b1);
				}
				
	
				break;
			
		default:
			System.out.println("Wrong choice entered.....");
			}
			break;
			
		default:
			System.out.println("Wrong choice entered.....");
			
		}
			
		System.out.println("Do you Want to continue.....if yes then enter y");	
		ch=scan.next().charAt(0);
		}while(ch=='y' || ch=='Y');
	
			
			
			
			
			
			
			
			
		
		
		}
		
		
		
	}
	
	



