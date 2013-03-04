package com.github.osgi.dao.internal;

import java.util.Arrays;
import java.util.List;

import com.github.osgi.dao.BookshelfDao;
import com.github.osgi.model.Book;

public class BookshelfDaoImpl implements BookshelfDao {

	private Book mockBook;

	private List<Book> booksList;

	public BookshelfDaoImpl() {
		mockBook = new Book();
		mockBook.setIsbn("N/A");
		mockBook.setAuthor("Mock author");
		mockBook.setTitle("Mock title");

		booksList = Arrays.asList(mockBook);
	}

	public void addNewBook(Book book) {

	}

	public List<Book> getAllBooks() {
		return booksList;
	}

	public Book getBook(String isbn) {
		return mockBook;
	}

	public void removeBook(Book book) {

	}
}
