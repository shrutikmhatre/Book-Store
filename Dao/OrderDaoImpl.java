package com.book.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.book.pojo.Order;
import com.book.utility.DBCConnection;

public class OrderDaoImpl implements OrderDao{
 
	Connection con=DBCConnection.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	int result;
	String sql;
	boolean flag;
	Order o;
	double totalPrice;
	
	
	@Override
	public Order placeOrder(String custEmail) {
		
		try {
			//fetching Date
		Date d=new Date();
		String orderDate=d.toString();
		
		//calculating total price
		sql="select sum(b.book_price*ca.quantity) as totalprice from book b inner join cart ca on b.book_id=ca.bookid where custEmail=?";
		ps=con.prepareStatement(sql);		
		ps.setString(1, custEmail);
		rs=ps.executeQuery();
		
		while(rs.next()) {
		totalPrice=rs.getDouble(1);
		}
		
		//inserting values in orders tables
		sql="insert into orders(orderdate,orderstatus,custemail,totalprice) values(?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1, orderDate);
		ps.setString(2, "Processing....");
		ps.setString(3, custEmail);
		ps.setDouble(4, totalPrice);
		
		result =ps.executeUpdate();
		
		//remove from cart after place order
		new CartDaoImpl().clearCart(custEmail);
		
		//fetching order which is placed
		sql="select * from orders";
		ps=con.prepareStatement(sql);
		rs=ps.executeQuery();
		
		while(rs.next()) {
			o=new Order();
			o.setOrderId(rs.getInt(1));
			o.setOrderDate(rs.getString(2));
			o.setOrderStatus(rs.getString(3));
			o.setCustEmail(rs.getString(4));
			o.setTotalPrice(rs.getDouble(5));
		}	
		}	catch(SQLException e) {	
			
			e.printStackTrace();
		}
		
		return o;
		
	}
	@Override
	public List<Order> showAllOrders() {
		sql="select *from orders";
		List<Order> lst=new ArrayList<Order>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			

			while(rs.next()) {
				o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getString(2));
				o.setOrderStatus(rs.getString(3));
				o.setCustEmail(rs.getString(4));
				o.setTotalPrice(rs.getDouble(5));
				lst.add(o);
				
			}	
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lst;
	}
	
	@Override
	public List<Order> showMyOrders(String email) {
		
		sql="select *from orders where custemail=?";
		List<Order> lst1=new ArrayList<Order>();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, email);
			rs=ps.executeQuery();
			

			while(rs.next()) {
				o=new Order();
				o.setOrderId(rs.getInt(1));
				o.setOrderDate(rs.getString(2));
				o.setOrderStatus(rs.getString(3));
				o.setCustEmail(rs.getString(4));
				o.setTotalPrice(rs.getDouble(5));
				lst1.add(o);
				
			}	
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lst1;
		
		
	}
	@Override
	public boolean cancelOrder(int orderId) {
		
		
		sql="delete from orders where orderid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, orderId);
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0)
		{
			return true;
		}
		else
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
