package com.book.Dao;

import java.util.List; 

import com.book.pojo.Book;

public interface BookDao {

	boolean addBook(Book b);
	boolean updateBook(Book b);
	boolean deleteBook(int bookId);
	List<Book> showAllBooks();
	Book searchBookById(int bookId);
	List<Book> searchBookByName(String bookName);
}
