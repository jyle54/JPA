package book;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import java.util.List;
import javax.ejb.EJB;

@ManagedBean
public class BookController {

	// EJB-komponentti sisältää datan tallennuksen ja haun tietokannasta JPA:lla
	@EJB
	private BookEjb bookEjb;

	@ManagedProperty(value = "#{book}")
	private Book book;

	public BookController() {
		// bookEjb.alustaBooket();

	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String save() {
		String viesti = "Tallennus onnistui: " + book;

		FacesContext facesContext = FacesContext.getCurrentInstance();

		// save book and set facesMessage if error

		
		FacesMessage facesMessage = new FacesMessage(viesti);
		facesContext.addMessage(null, facesMessage);

		return "index";
	}

	public List<Book> getBooks() {
		return bookEjb.getBooks();
	}

	public String initialize() {
		bookEjb.init();
		return null;
	}
}
