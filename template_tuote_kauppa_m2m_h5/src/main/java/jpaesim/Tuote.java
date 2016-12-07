package jpaesim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "TUOTE3")

public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToMany
	private Collection<Kauppa> kaupat;
//	private List<Kauppa> kaupat;
	
	private String nimi;
	private double hinta;
	private String koodi;

public Tuote() {
		this.kaupat = new ArrayList<>();
	}
	
	public Tuote (String n, double h, String t) {
			this.nimi = n;
			this.hinta = h;
			this.koodi = t;
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
	
	

	public Collection<Kauppa> getKaupat() {
		return kaupat;
	}

	public void setKaupat(Collection<Kauppa> kaupat) {
		this.kaupat = kaupat;
	}

	public String toString() {
		String tulos = "";
		for(Kauppa tuotteet : this.kaupat) {
			tulos += this.nimi + " [id: " + tuotteet.getId() + " " + tuotteet.getNimi() + " " + tuotteet.getOsoite() + "]" + "\n";
		}
		return tulos;
		// return this.nimi + this.hinta + this.koodi; 
	}
	
	
}
