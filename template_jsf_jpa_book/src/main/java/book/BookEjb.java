package book;

// JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class  BookEjb {
	
	
	@PersistenceContext(unitName = "jpa_book") // Name in persistence.xml
	private EntityManager em;

	public BookEjb() {

	}
	
	public void init() {
		Book b1= new Book();
		b1.setName("Elements of Programming Interviews in Java");

		//System.out.println("saved book: " + b1);
		em.persist(b1);
	}

	public void save(Book book) {
		// persist book in database
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getBooks() {
		List<Book> books = null; 
		// get all books from the database
		books = em.createNamedQuery("searchAllBooks").getResultList();
		System.out.println("*********** search all ********** => " + books);
		return books;
	}
	
}