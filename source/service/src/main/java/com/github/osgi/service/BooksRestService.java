package com.github.osgi.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.osgi.extensions.annotation.ServiceReference;
import org.springframework.osgi.extensions.annotation.ServiceReferenceCardinality;
import org.springframework.stereotype.Service;

import com.github.osgi.dao.BookshelfDao;
import com.github.osgi.model.Book;

@Path("/books")
@Service(value = "booksRestService")
public class BooksRestService {

	private static final Logger logger = Logger
			.getLogger(BooksRestService.class.getCanonicalName());

	private BookshelfDao dao;

	@Produces("application/xml")
	@GET
	public List<Book> getAllBooks() {
		logger.info("Getting all books");
		return dao.getAllBooks();
	}

	@GET
	@Path("{isbn}")
	@Produces("application/xml")
	public Book getBook(@PathParam("isbn") String isbn) {
		logger.info("Getting book with isbn: " + isbn);
		return dao.getBook(isbn);
	}

	@DELETE
	@Path("{isbn}")
	public Response removeBook(@PathParam("isbn") String isbn) {
		logger.info("Removing book with isbn: " + isbn);
		final Book toBeDeleted = dao.getBook(isbn);
		if (toBeDeleted == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			dao.removeBook(toBeDeleted);
			return Response.status(Response.Status.OK).build();
		}
	}

	@POST
	@Consumes("application/xml")
	public Response addNewBook(Book book) {
		logger.info("Adding new book with isbn: " + book.getIsbn());
		dao.addNewBook(book);
		return Response.status(Response.Status.CREATED).build();
	}

	@ServiceReference(cardinality = ServiceReferenceCardinality.C0__1, timeout = 100)
	public void setDao(BookshelfDao dao) {
		this.dao = dao;
	}

}
