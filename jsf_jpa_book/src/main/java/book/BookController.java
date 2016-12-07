package book;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
// JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.sql.DataSource;
import javax.transaction.UserTransaction;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;

@ManagedBean
public class BookController {
	// olio sisältää datan tallennuksen ja haun tietokannasta JPA:lla
	@EJB
	private BookEjb bookEjb;

	@ManagedProperty(value = "#{book}")
	private Book book;

	public BookController() {
		//tkJpa.alustaTietokoneet();

	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String tallennaBook() {
		String palautus = "Tallennus onnistui: " + book;

		FacesContext facesContext = FacesContext.getCurrentInstance();
		// JSF:ssa luodun beanin nimellä päästään olioon kiinni "fish"
		// (faces-config.xml)
		Book bk = (Book) facesContext.getExternalContext().getRequestMap().get("book");
		System.out.println("bk:" + bk);
		// System.out.println("tietokone:" + tietokone);

		bookEjb.tallennaBook(bk);
		// tkJpa.tallennaTietokone(tietokone);

		return palautus;
	}

	public List<Book> getBooks() {
		return bookEjb.haeBook();
	}

	public String alustaBook() {
		bookEjb.alustaBook();
		return "index";
	}
}
