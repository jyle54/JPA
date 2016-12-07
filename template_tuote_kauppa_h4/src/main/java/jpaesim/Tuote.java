package jpaesim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "TUOTE2")
@NamedQuery(name = "selectTuotteet", query = "SELECT t from Tuote t")

public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	// Määrittelee tuote - kauppa suhteen 1 - n 
	@OneToMany( targetEntity=Kauppa.class )
	private List<Kauppa> kaupat;
	private String nimi;
	private double hinta;
	private String koodi;
	
	public Tuote() {
		this.kaupat = new ArrayList<>();
	}
	
	public Tuote(String n, double h, String t) {
		this.nimi = n;
		this.hinta = h;
		this.koodi = t;
	}

	public List<Kauppa> getKaupat() {
		return kaupat;
	}

	public void setKaupat(List<Kauppa> kaupat) {
		this.kaupat = kaupat;
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
		String tulos = "";
		for(Kauppa tuotteet : this.kaupat) {
			tulos += this.nimi + " [id: " + tuotteet.getId() + " " + tuotteet.getNimi() + " " + tuotteet.getOsoite() + "]" + "\n";
		}
		return tulos;
//		return this.nimi + this.koodi;
	}
}
