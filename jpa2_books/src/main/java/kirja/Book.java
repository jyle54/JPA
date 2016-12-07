package kirja;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Book
 *
 */
@javax.persistence.Entity
@NamedQueries({
@NamedQuery(name = "selectAll", query = "SELECT b from Book b"),
@NamedQuery(name = "searchAllBooks", query = "SELECT b from Book b ORDER BY b.name DESC"),
@NamedQuery(name = "etsiNimella", query = "SELECT b from Book b where b.name like 'Java EE%'"),
@NamedQuery(name = "etsiNimella2", query = "SELECT b from Book b where b.name like 'Java 8%'")
//@NamedQuery(name = "selectAllOrder2", query = "SELECT b from Book b ORDER BY lang.name")
})
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//@Column
	private String name;
	private String author;
	private String edition;
	private Integer pages;
	private String publisher;
	private String language;
	private String asin;
	
	

	public Book() {
		super();
	}   

	public Book(long id, String n, String aut, String e, Integer p, String pub, String l, String a) {
		this.id = id;
		this.name = n;
		this.author = aut;
		this.edition = e;
		this.pages = p;
		this.publisher = pub;
		this.language = l;
		this.asin = a;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getAsin() {
		return asin;
	}

	public void setAsin(String asin) {
		this.asin = asin;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String toString() {
		return this.name + this.author + this.edition + this.pages + this.publisher + this.language + this.asin;
	}
   
}
