package book;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;


/**
 * Entity JPA toteututs.
 * Managed Bean tarjotaan JSF:lle. VOidaan käyttää JSF:n kontrollerista
 */

@ManagedBean
@RequestScoped
@Entity
@NamedQueries({ @NamedQuery(name = "haeKaikki", query = "SELECT b from Book b"),
	@NamedQuery(name = "etsiNimella", query = "SELECT b from Book b where b.name like :name") 
})
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String author;
	private String edition;
	private Integer pages;
	private String publisher;
	private String language;
	private String identifier;
	private String code;
	

	public Book() {
		this.name = "";
		this.author = "";
		this.edition = "";
		this.pages = 0;
		this.publisher = "";
		this.language = "";
		this.identifier ="";
		this.code = "";
	}

	public Book(String n, String a, String e, Integer p, String pub, String lang, String ide, String c) {
		this.name = n;
		this.author = a;
		this.edition = e;
		this.pages = p;
		this.publisher = pub;
		this.language = lang;
		this.identifier = ide;
		this.code = c;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
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

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return this.name + this.author + this.edition + this.pages + this.publisher + this.language + this.identifier + this.code;
	}

}