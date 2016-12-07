package book;

import java.io.Serializable;
import javax.persistence.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 * Entity JPA toteututs.
 * Managed Bean tarjotaan JSF:lle. VOidaan käyttää JSF:n kontrollerista
 */

@ManagedBean
@RequestScoped
@Entity
@NamedQuery(name = "searchAllBooks", query = "SELECT b from Book b") 
public class Book implements Serializable {
  //  private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name; 


	public Book() {

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
    
    @Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + "]";
	}

}


