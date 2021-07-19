package com.book.pojo;

public class Order {

	private int orderId;
	private String orderDate,orderStatus,custEmail;
	private double totalPrice;
	
	//no args constructor
	public Order() {
	super();
	}
	//without primary key
	public Order(String orderDate, String orderStatus, String custEmail, double totalPrice) {
		super();
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.custEmail = custEmail;
		this.totalPrice = totalPrice;
	}
	
	
	//with all parameter
	public Order(int orderId, String orderDate, String orderStatus, String custEmail, double totalPrice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.custEmail = custEmail;
		this.totalPrice = totalPrice;
	}
	
	//getter and setters
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", custEmail=" + custEmail + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
}
