package jpaesim;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "TUOTE")
@NamedQuery(name = "selectAll", query = "SELECT t from Tuote t")
public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private static final long serialVersionUID = 1L;

	private String nimi;
	private double hinta;
	private String koodi;
	
	public Tuote() {
	
	}
	
	public Tuote(String n, double h, String t) {
		this.nimi = n;
		this.hinta = h;
		this.koodi = t;
	}
	
	public String getNimi() {
		return nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKoodi() {
		return koodi;
	}

	public void setKoodi(String koodi) {
		this.koodi = koodi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String toString() {
		return this.nimi + this.koodi;
	}
	
}
