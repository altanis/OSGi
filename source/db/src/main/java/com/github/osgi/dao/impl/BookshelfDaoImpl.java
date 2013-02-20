package com.github.osgi.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.osgi.dao.BookshelfDao;
import com.github.osgi.model.Book;

public class BookshelfDaoImpl implements BookshelfDao {

	private List<Book> books = new ArrayList<Book>();
	
	public void addNewBook(Book book) {
		books.add(book);
	}

	public List<Book> getAllBooks() {
		return Collections.unmodifiableList(books);
	}

	public Book getBook(String isbn) {
		for(Book b : books) {
			if(b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		
		return null;
	}

	public void removeBook(Book book) {
		books.remove(book);
	}
	
}
