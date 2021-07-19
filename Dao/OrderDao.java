package com.book.Dao;

import java.util.List;

import com.book.pojo.Order;

public interface OrderDao {

	Order placeOrder(String custEmail);
	List<Order> showAllOrders();
	List<Order> showMyOrders(String email);
	boolean cancelOrder(int orderId);
	
	
	
}
