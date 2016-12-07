package jpaesim;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Kauppa
 *
 */
@javax.persistence.Entity
@Table(name = "KAUPPA2")
@NamedQueries({
@NamedQuery(name = "selectKaupat", query = "SELECT k from Kauppa k"),
@NamedQuery(name = "selecttuotteet", query = "SELECT t from Tuote t")
//@NamedQuery(name = "etsiNimella", query = "SELECT b from Book b where b.name like 'Java EE%'")
})
public class Kauppa implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nimi;
	private String osoite;

	@ManyToMany(mappedBy="kaupat")
	private Collection<Tuote> tuotteet;


	public Kauppa() {
		super();
	}

	public Kauppa(String n, String o) {
		this.nimi = n;
		this.osoite = o;
	}
	
	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Collection<Tuote> getTuotteet() {
		return tuotteet;
	}

	public void setTuotteet(Collection<Tuote> tuotteet) {
		this.tuotteet = tuotteet;
	}

	public String toString() {
	//	return this.nimi + this.osoite;
		String tulos = "";
		for(Tuote tuotteet : this.tuotteet) {
			tulos += this.nimi + " [id: " + tuotteet.getId() + " " + tuotteet.getNimi() + " " + tuotteet.getHinta() + " " + tuotteet.getKoodi() + "]" + "\n";
		}
		return tulos;
	}

}
