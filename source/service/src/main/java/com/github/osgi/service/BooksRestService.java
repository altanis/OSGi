package com.github.osgi.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.github.osgi.model.Book;

@Path("/books")
public class BooksRestService {

	@Produces("application/xml")
	@GET
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		
		Book b = new Book();
		b.setAuthor("Seba");
		
		books.add(b);
		return books;
	}
	
}
