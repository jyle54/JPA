package tuotejpa;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "KantaTuote")
@NamedQueries({
@NamedQuery(name = "etsiKaikkituotteet", query = "SELECT t from Tuote t"),
@NamedQuery(name = "etsihalvattuotteet", query = "SELECT t from Tuote t where t.hinta < 10")
})
//@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn (name="Kantatuote_type")
 
//@DiscriminatorValue ("Tuote")
public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nimi;
	private double hinta;

	public Tuote() {
		super();
	}
	
	public Tuote(String n, double h) {
		this.nimi = n;
		this.hinta = h;
	}
	
	

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String toString() {
		return this.nimi + this.hinta;
	}
	

}
