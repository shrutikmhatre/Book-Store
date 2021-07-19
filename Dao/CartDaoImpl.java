package com.book.Dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Book;
import com.book.pojo.Cart;
import com.book.utility.DBCConnection;

public class CartDaoImpl implements CartDao {

	Connection con=DBCConnection.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	int result;
	String sql;
	Cart c;
	
	
	
	@Override
	public boolean addToCart(Cart ca) {

		
		sql="insert into cart(bookid,custEmail,quantity) values(?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, ca.getBookId());
			ps.setString(2, ca.getCustEmail());
			ps.setInt(3, ca.getQuantity());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0)
			return true;
		else
			return false;
		
		
		
		
	}

	@Override
	public boolean updateCart(Cart ca) {
		
		
		sql="update cart set bookid=? ,custEmail=? ,quantity=? where cartid=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, ca.getBookId());
			ps.setString(2, ca.getCustEmail());
			ps.setInt(3, ca.getQuantity());
			ps.setInt(4, ca.getCartId());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean removeFromCartByCartId(int cartId) {
		
		try {
			sql="delete from cart where cartid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
		
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
	public boolean clearCart(String custEmail) {
		
		
		
		try {
			sql="delete from cart where custEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, custEmail);
		
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
	public List<Cart> showCart() {
		
		List<Cart> list=new ArrayList<Cart>();
		
		try {
			sql="select ca.cartid,b.book_id, b.book_name, b.book_price, ca.custEmail, ca.quantity from cart ca inner join book b on ca.bookid=b.book_id";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
		
		while(rs.next()) {
			c=new Cart();
			c.setCartId(rs.getInt(1));
			c.setBookId(rs.getInt(2));
			c.setBookName(rs.getString(3));
			c.setBookPrice(rs.getDouble(4));
			c.setCustEmail(rs.getString(5));
			c.setQuantity(rs.getInt(6));
			
			list.add(c);
		}	
		}catch(SQLException e)	{
			
			e.printStackTrace();
		}	
		return list;
		
		
		
		
		
	}

	@Override
	public Cart searchFromCartByCartId(int cartId) {

	
		sql="select *from cart where cartid=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
			rs=ps.executeQuery();
			while(rs.next()) {
				c=new Cart();
				c.setCartId(rs.getInt(1));
				c.setBookId(rs.getInt(2));
				c.setCustEmail(rs.getString(3));
				c.setQuantity(rs.getInt(4));
			
			return c;
				
				
				
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		
		return null;
		
		
		
		
	}
	
	

	@Override
	public List<Cart> searchFromCartBycustEmail(String custEmail) {
		List<Cart> list1=new ArrayList<Cart>();
	
		
		try {
			sql="select ca.cartid,b.book_id, b.book_name, b.book_price, ca.custEmail, ca.quantity from cart ca inner join book b on ca.bookid=b.book_id where ca.custEmail=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, custEmail);
			rs=ps.executeQuery();
		
		while(rs.next()) {
			c=new Cart();
			c.setCartId(rs.getInt(1));
			c.setBookId(rs.getInt(2));
			c.setBookName(rs.getString(3));
			c.setBookPrice(rs.getDouble(4));
			c.setCustEmail(rs.getString(5));
			c.setQuantity(rs.getInt(6));
			
			list1.add(c);
		}	
		}catch(SQLException e)	{
			
			e.printStackTrace();
		}	
		
		
		
		
		return list1;
	}

	
	
}
