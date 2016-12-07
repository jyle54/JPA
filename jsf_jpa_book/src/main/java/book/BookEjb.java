package book;

// JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;

@Stateless
public class BookEjb {
	// http://stackoverflow.com/questions/21038706/persistenceunit-vs-persistencecontext
	@PersistenceContext(unitName = "jpa_book")
	private EntityManager manageri;

	public BookEjb() {
	}

	public void tallennaBook(Book book) {
		try {
			manageri.persist(book);
			System.out.println("persist tietokone:" + book);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Tallennus ei onnistunut!");
		}
	}
	
	public void alustaBook() {
		Book b1 = new Book();
	        b1.setName("Java: A Beginner's Guide");
	        b1.setAuthor("Herbert Schildt");
	        b1.setEdition("6th Edition");
	        b1.setPages(728);
	        b1.setPublisher("McGraw-Hill Education");
	        b1.setLanguage("English");
	        b1.setIdentifier("1");
	        b1.setCode("978-0071809252");
	        
	        Book b2 = new Book();
	        b2.setName("Elements of Programming Interviews in Java");
	        b2.setAuthor("Adnan Aziz");
	        b2.setEdition("2nd edition");
	        b2.setPages(542);
	        b2.setPublisher("CreateSpace Independent Publishing Platform");
	        b2.setLanguage("English");
	        b2.setIdentifier("2");
	        b2.setCode("978-1517435806");
	        
	        Book b3 = new Book();
	        b3.setName("Functional Java: A Guide to Lambdas and Functional Programming in Java 8");
	        b3.setAuthor("Nick Maiorano");
	        b3.setEdition("1st edition");
	        b3.setPages(208);
	        b3.setPublisher("ThoughtFlow Solutions inc.");
			b3.setLanguage("English");
			b3.setIdentifier("3");
			b3.setCode("B00JZ7GD46");
	        
	        Book b4 = new Book();
	        b4.setName("Java 8 in Action: Lambdas, Streams, and functional-style programming");
	        b4.setAuthor("Raoul-Gabriel Urma");
	        b4.setEdition("1st edition");
	        b4.setPages(424);
	        b4.setPublisher("Manning Publications");
			b4.setLanguage("English");
			b4.setIdentifier("4");
			b4.setCode("978-1617291999");
	        
	        Book b5 = new Book();
	        b5.setName("Getting started with Spring Framework");
	        b5.setAuthor("J Sharma");
	        b5.setEdition("3th Edition");
	        b5.setPages(626);
	        b5.setPublisher("Amazon Digital Services LLC");
			b5.setLanguage("English");
			b5.setIdentifier("5");
			b5.setCode("B01HZXQFUS");
	                
	        Book b6 = new Book();
	        b6.setName("Java EE 7: The Big Picture");
	        b6.setAuthor("Dr. Danny Coward");
	        b6.setEdition("1st edition");
	        b6.setPages(512);
	        b6.setPublisher("McGraw-Hill Education");
			b6.setLanguage("English");
			b6.setIdentifier("6");
			b6.setCode("978-0071837347");
	        
			Book b7 = new Book();
	        b7.setName("Murach's Java Servlets and JSP");
	        b7.setAuthor("Joel Murach");
	        b7.setEdition("3rd edition");
	        b7.setPages(758);
	        b7.setPublisher("Mike Murach & Associates");
			b7.setLanguage("English");
			b7.setIdentifier("7");
			b7.setCode("978-1890774783");
	        
			Book b8 = new Book();
	        b8.setName("Java EE 7 Essentials: Enterprise Developer Handbook");
	        b8.setAuthor("Arun Gupta");
	        b8.setEdition("1st edition");
	        b8.setPages(362);
	        b8.setPublisher("O'Reilly Media");
			b8.setLanguage("English");
			b8.setIdentifier("8");
			b8.setCode("978-1449370176");
	        
			manageri.persist(b1);
	        manageri.persist(b2);
	        manageri.persist(b3);
	        manageri.persist(b4);
	        manageri.persist(b5);
	        manageri.persist(b6);
	        manageri.persist(b7);
	        manageri.persist(b8);
	}
	  	
		@SuppressWarnings("unchecked")
		public List<Book> haeBook() {
		List<Book> books = null; 
		books = manageri.createNamedQuery("haeKaikki").getResultList();
		System.out.println("haetut kirjat");
		return books;
	}


}
