package com.book.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Book;
import com.book.pojo.Customer;
import com.book.utility.DBCConnection;

public class CustomerDaoImpl implements CustomerDao {

	Connection con=DBCConnection.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	int result;
	String sql;
	Customer c;
	
	@Override
	public boolean addCustomer(Customer c) {
		try {
			sql="insert into Customer (custName, custEmail, custPassword, custContact, custAddress)" + "values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getCustEmail());
			ps.setString(3, c.getCustPassword());
			ps.setString(4, c.getCustContact());
			ps.setString(5, c.getCustAddress());
			
			result=ps.executeUpdate();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		if(result>0) { 	
			return true;
		}
		else {	
			return false;
			
		}
		
	}

	@Override
	public boolean updateCustomer(Customer c) {
		
		try {
			sql="update customer set custName=?, custEmail=?, custPassword=?, custContact=?, custAddress=? where custid=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getCustEmail());
			ps.setString(3, c.getCustPassword());
			ps.setString(4, c.getCustContact());
			ps.setString(5, c.getCustAddress());
		    ps.setInt(6,c.getCustId());
			result=ps.executeUpdate();
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		if(result>0) { 	
			return true;
		}
		else {	
			return false;
		}
	}

	@Override
	public boolean deleteCustomer(int custId) {
		try {
			sql="delete from customer where custid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
		
			result=ps.executeUpdate();
		}catch (SQLException e) {
		
		e.printStackTrace();
		}
			if(result>0) {
				return true;
			}
			else {
		
		return false;
	}
	}
	@Override
	public List<Customer> showAllCustomers() {
		List<Customer> list=new ArrayList<Customer>();
		
		try {
			sql="select * from Customer";
			ps=con.prepareStatement(sql);
		
			rs=ps.executeQuery();
		
			while(rs.next()) {
				c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustPassword(rs.getString(4));
				c.setCustContact(rs.getString(5));
				c.setCustAddress(rs.getString(6));
				
				
				list.add(c);
			}
		}catch(SQLException e) {	
			
				e.printStackTrace();
		}	
		return list;
		
	}

	@Override
	public Customer searchCustomerById(int custId) {
		try {
			sql="select * from customer where custId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, custId);
	
			rs=ps.executeQuery();
	
			while(rs.next()) {
				c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustPassword(rs.getString(4));
				c.setCustContact(rs.getString(5));
				c.setCustAddress(rs.getString(6));
				
				
				return c;
			}
			
	} catch (SQLException e) {
			
			e.printStackTrace();
	}
		return null;
	}

	@Override
	public List<Customer> searchCustomerByName(String custName) {
		List<Customer> list=new ArrayList<Customer>();
		try {
			sql="select * from customer where custName=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, custName);
	
			rs=ps.executeQuery();
	
			while(rs.next()) {
				c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustPassword(rs.getString(4));
				c.setCustContact(rs.getString(5));
				c.setCustAddress(rs.getString(6));
				
				list.add(c);
					
			}
			
	} catch (SQLException e) {
			
			e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Customer> searchCustomerByEmail(String custEmail) {
		List<Customer> list1=new ArrayList<Customer>();
		try {
			sql="select * from customer where custEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, custEmail);
	
			rs=ps.executeQuery();
	
			while(rs.next()) {
				c=new Customer();
				c.setCustId(rs.getInt(1));
				c.setCustName(rs.getString(2));
				c.setCustEmail(rs.getString(3));
				c.setCustPassword(rs.getString(4));
				c.setCustContact(rs.getString(5));
				c.setCustAddress(rs.getString(6));
				
				list1.add(c);
					
			}
			
	} catch (SQLException e) {
			
			e.printStackTrace();
		
	}
		return list1;
	}
	
	
	
	
	
	
	
}
