package tuotejpa;

//import java.io.Serializable;
import javax.persistence.*;

@javax.persistence.Entity
@NamedQuery(name = "etsiKaikkiKirjat", query = "SELECT k from Kirja k")
//@PrimaryKeyJoinColumn(name="TUOTE_ID") 
//@DiscriminatorValue ("Kirja")
public class Kirja extends Tuote {

	private String isbn;
    private String tekijat;
	
	public Kirja() {
	} 

	public Kirja(String i, String t) {
		this.isbn = i;
		this.tekijat = t;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTekijat() {
		return tekijat;
	}

	public void setTekijat(String tekijat) {
		this.tekijat = tekijat;
	}
	
	public String toString() {
		return this.isbn + " " + this.getNimi() + " " + this.tekijat + " " + this.getHinta();
	}
	
}
