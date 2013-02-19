package com.github.osgi.dao;

import java.util.List;

import com.github.osgi.model.Book;

public interface BookshelfDao {

	public List<Book> getAllBooks();
	public void addNewBook(Book book);
	public Book getBook(String isbn);
	public void removeBook(Book book);
	
}
