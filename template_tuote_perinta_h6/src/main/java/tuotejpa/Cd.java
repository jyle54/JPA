package tuotejpa;

import java.io.Serializable;

import javax.persistence.*;

import tuotejpa.Tuote;

/**
 * Entity implementation class for Entity: Cd
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name = "etsiKaikkicdt", query = "SELECT c from Cd c"),
@NamedQuery(name = "etsiKaalliitLevyt", query = "SELECT c from Cd c where c.hinta > 15")
})
//@PrimaryKeyJoinColumn(name="TUOTE_ID") 
//@DiscriminatorValue ("Cd")
public class Cd extends Tuote {
	private String artisti;
	// private String album;
    private int pituus;
    private int biiseja;
  //  private double hinta;

	public Cd() {
		super();
	}
	
	public Cd(String a, int p, int b) {
		this.artisti = a;
	//	this.album = al;
		this.pituus = p;
		this.biiseja = b;
//		this.hinta = h;
	}

	/*
	public String getArtisti() {
		return artisti;
	}

	public void setArtisti(String artisti) {
		this.artisti = artisti;
	}
*/
	public int getPituus() {
		return pituus;
	}

	public void setPituus(int pituus) {
		this.pituus = pituus;
	}

	public int getBiiseja() {
		return biiseja;
	}

	public void setBiiseja(int biiseja) {
		this.biiseja = biiseja;
	}


public String toString() {
	return  this.artisti + " " + this.pituus + " " + this.biiseja + " " + this.getHinta() + " " + this.getNimi();
}	
	
}
