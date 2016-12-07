package kysymys;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity JPA toteututs.
 * 
 */


@Entity
@Table(name = "Quiz")
@NamedQueries({ @NamedQuery(name = "haeKaikki", query = "SELECT q from Quiz q"),
	@NamedQuery(name = "etsiNimella", query = "SELECT q from Quiz q where q.kysymys like :nimi") 
})
public class Quiz implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	String kysymys;
	String answer1;
	String answer2;
	String answer3;
	String correct;

	public Quiz() {
		super();
		this.answer1 = "";
		this.answer2 = "";
		this.answer3 = "";
	}

	public Quiz(String m, String a, String b, String c, String cor) {
		this.kysymys = m;
		this.answer1 = a;
		this.answer2 = b;
		this.answer3 = c;
		this.correct = cor;
	}

	
	
	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
		this.kysymys = kysymys;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	
	
	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "Question: " + this.kysymys + "\n" +
	this.getAnswer1() + "\n" + this.getAnswer2() + "\n" + this.getAnswer3() + "\n" 
	+ "Oikea vastaus on " + this.getCorrect() + "\n";	
	}

}