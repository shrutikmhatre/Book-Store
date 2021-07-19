package com.book.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.pojo.Book;
import com.book.utility.DBCConnection;
public class BookDaoImpl implements BookDao {
	
	Connection con=DBCConnection.getConnection();
	PreparedStatement ps=null;
	ResultSet rs=null;
	int result;
	String sql;
	Book b;
	@Override
	public boolean addBook(Book b) {

		
		
		try {
			sql="insert into book (book_name,author_name,publisher_name ,rating ,number_of_copies ,book_price) values(?,?,?,?,?,?)";

			ps=con.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthorName());
			ps.setString(3, b.getPublisherName());
			ps.setDouble(4, b.getRating());
			ps.setDouble(5, b.getNumber_of_copies());
			ps.setDouble(6, b.getBookPrice());
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result>0) {
			return true;
		}
		else
		return false;
	}

	@Override
	public boolean updateBook(Book b) {

		try {
			sql="update book set book_name=?, author_name=?, publisher_name=?, rating=?, number_of_copies=?, book_price=? where book_id=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthorName());
			ps.setString(3, b.getPublisherName());
			ps.setDouble(4, b.getRating());
			ps.setDouble(5, b.getNumber_of_copies());
			ps.setDouble(6, b.getBookPrice());
		    ps.setInt(7,b.getBookId());
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
	public boolean deleteBook(int bookId) {
		try {
			sql="delete from book where book_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);
		
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
	public List<Book> showAllBooks() {
		
List<Book> list=new ArrayList<Book>();
		
		try {
			sql="select * from book";
			ps=con.prepareStatement(sql);
		
			rs=ps.executeQuery();
		
			while(rs.next()) {
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setPublisherName(rs.getString(4));
				b.setRating(rs.getDouble(5));
				b.setNumber_of_copies(rs.getDouble(6));
				b.setBookPrice(rs.getDouble(7));
				
				list.add(b);
			}
		}catch(SQLException e) {	
			
				e.printStackTrace();
		}	
		return list;		
		
		
		
		
	}

	@Override
	public Book searchBookById(int bookId) {
		
		try {
			sql="select * from book where book_id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, bookId);
	
			rs=ps.executeQuery();
	
			while(rs.next()) {
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setPublisherName(rs.getString(4));
				b.setRating(rs.getDouble(5));
				b.setNumber_of_copies(rs.getDouble(6));
				b.setBookPrice(rs.getDouble(7));
				
				return b;
			}
			
	} catch (SQLException e) {
			
			e.printStackTrace();
	}
				
	return null;
	}

	@Override
	public List<Book> searchBookByName(String bookName) {
		List<Book> list=new ArrayList<Book>();
		try {
			sql="select * from book where book_name=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, bookName);
	
			rs=ps.executeQuery();
	
			while(rs.next()) {
				b=new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setPublisherName(rs.getString(4));
				b.setRating(rs.getDouble(5));
				b.setNumber_of_copies(rs.getDouble(6));
				b.setBookPrice(rs.getDouble(7));
				list.add(b);
					
			}
			
	} catch (SQLException e) {
			
			e.printStackTrace();
	}
		return list;
	}
}


