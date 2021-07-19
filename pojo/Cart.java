package com.book.pojo;

public class Cart {
	
	private int cartId;
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String custEmail;
	private int quantity;
	
	
	
	
	
	
	public Cart() {
		super();
	}


	//with bookid,custemail,quantity
	public Cart(int bookId, String custEmail, int quantity) {
		super();
		this.bookId = bookId;
		this.custEmail = custEmail;
		this.quantity = quantity;
	}
	
	
	//with cartId,Custemail, book Id, Quantiity
	public Cart(int cartId, int bookId, String custEmail, int quantity) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.custEmail = custEmail;
		this.quantity = quantity;
	}
	//without cartId
	public Cart(int bookId, String bookName, double bookPrice, String custEmail, int quantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.custEmail = custEmail;
		this.quantity = quantity;
	}
	//fully parameterized constructor
	public Cart(int cartId, int bookId, String bookName, double bookPrice, String custEmail, int quantity) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.custEmail = custEmail;
		this.quantity = quantity;
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice
				+ ", custEmail=" + custEmail + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
	
	
}
