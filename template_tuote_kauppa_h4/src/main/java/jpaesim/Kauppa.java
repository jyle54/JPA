package jpaesim;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Kauppa
 *
 */
@javax.persistence.Entity
@Table(name = "KAUPPA")
@NamedQueries({
@NamedQuery(name = "selectKaupat", query = "SELECT k from Kauppa k"),
@NamedQuery(name = "selecttuotteet", query = "SELECT t from Tuote t")
//@NamedQuery(name = "etsiNimella", query = "SELECT b from Book b where b.name like 'Java EE%'")
})
public class Kauppa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	@JoinColumn(name = "tuote", referencedColumnName = "tuote_id")
	private String nimi;
	private String osoite;

	
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

	public String toString() {
		return this.nimi + this.osoite;
	}

}
