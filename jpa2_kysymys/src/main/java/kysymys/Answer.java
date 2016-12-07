package kysymys;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ @NamedQuery(name = "haeKaikki2", query = "SELECT a from Answer a"),
	@NamedQuery(name = "etsiNimella2", query = "SELECT a from Answer a where a.vastaus like :nimi") 
})
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String vastaus;
	
	public Answer() {
		super();
	}
	
	
}
