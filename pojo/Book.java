package com.book.pojo;

/*
 * SQl Table
 * 
 * create table book(book_id int primary key auto_increment,
 * book_name varchar(10),author_name varchar(10),
 * publisher_name varchar(10),rating double,number_of_copies double,book_price double);
 */






public class Book {
	
	private int bookId;
	private String bookName;
	private String authorName;
	private String publisherName;
	private  double Rating;
	private double number_of_copies;
	private double bookPrice;
	
	
	public Book() {
		
		super();
	}
	
	
	//constructor without bookId
	public Book(String bookName, String authorName, String publisherName, double rating, double number_of_copies,
			double bookPrice) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.Rating = rating;
		this.number_of_copies = number_of_copies;
		this.bookPrice = bookPrice;
	}






	//constructor with all fields
	public Book(int bookId, String bookName, String authorName, String publisherName, double rating,
			double number_of_copies, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisherName = publisherName;
		Rating = rating;
		this.number_of_copies = number_of_copies;
		this.bookPrice = bookPrice;
	}






	public int getBookId() {
		return bookId;
	}






	public void setBookId(int bookId) {
		this.bookId = bookId;
	}






	public String getBookName() {
		return bookName;
	}






	public void setBookName(String bookName) {
		this.bookName = bookName;
	}






	public String getAuthorName() {
		return authorName;
	}






	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}






	public String getPublisherName() {
		return publisherName;
	}






	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}






	public double getRating() {
		return Rating;
	}






	public void setRating(double rating) {
		Rating = rating;
	}






	public double getNumber_of_copies() {
		return number_of_copies;
	}






	public void setNumber_of_copies(double number_of_copies) {
		this.number_of_copies = number_of_copies;
	}






	public double getBookPrice() {
		return bookPrice;
	}






	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}






	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", publisherName="
				+ publisherName + ", Rating=" + Rating + ", number_of_copies=" + number_of_copies + ", bookPrice="
				+ bookPrice + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
