package kysymys;

import javax.persistence.*;

import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
     	 // Startataan H2 TCP-serverimoodissa
         org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();


		EntityManagerFactory tehdas = Persistence
				.createEntityManagerFactory("jpa_kysymys");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();
		
		Quiz quiz1 = new Quiz();
		quiz1.setKysymys("Gospling kehitti Javan?");
		quiz1.setAnswer1("1) oikein");
		quiz1.setAnswer2("2) väärin");
	//	System.out.println(quiz1);
		
		String tulos = quiz1.getAnswer1();
		quiz1.setCorrect(tulos);
	//	System.out.println("Correct answer is " +tulos);

		Quiz quiz2 = new Quiz();
		System.out.println();
		quiz2.setKysymys("Javan yritysversio?");
		quiz2.setAnswer1("Java SE");
		quiz2.setAnswer2("Java EE");
		quiz2.setAnswer3("Java ME");
	//	System.out.println(quiz2);
		
		String tulos2 = quiz2.getAnswer2();
		quiz2.setCorrect(tulos2);
	//	System.out.println("Correct answer is " +tulos2);

		Quiz quiz3 = new Quiz();
		System.out.println();
		quiz3.setKysymys("Androidin pääasiallinen ohjelmointikieli?");
		quiz3.setAnswer1("C-kieli ");
		quiz3.setAnswer2("Java ");
		quiz3.setAnswer3("Perl ");
	//	System.out.println(quiz3);
		
		String tulos3 = quiz3.getAnswer2();
		quiz3.setCorrect(tulos3);
	//	System.out.println("Correct answer is " +tulos3);

		Quiz quiz4 = new Quiz();
		System.out.println();
		quiz4.setKysymys("Suurin suomalainen matkapuhelin valmistaja?");
	//	quiz4.setAnswer1("Nokia");
//		System.out.println(quiz4);
		
		quiz4.setCorrect("Nokia");
		String tulos4 = quiz4.getCorrect();
		quiz4.setCorrect(tulos4);
	//	System.out.println("Correct answer is " +tulos4);

		Quiz quiz5 = new Quiz();
		System.out.println();
		quiz5.setKysymys("Ruotsin pääkaupunki?");
		quiz5.setCorrect("Tukholma");
		
		String tulos5 = quiz5.getCorrect();
		quiz5.setCorrect(tulos5);
		
		Quiz quiz6 = new Quiz();
		System.out.println();
		quiz6.setKysymys("Missä kaupungissa on heureka?");
		quiz6.setCorrect("Vantaa");
//		System.out.println(quiz6);
		
		String tulos6 = quiz6.getCorrect();
		quiz6.setCorrect(tulos6);
		
		Quiz quiz7 = new Quiz();
		System.out.println();
		quiz7.setKysymys("Missä päkaupunkissa on näsineula?");
		quiz7.setCorrect("Tampere");
//		System.out.println(quiz7);
		
		String tulos7 = quiz7.getCorrect();
		quiz7.setCorrect(tulos7);
		
		manageri.persist(quiz1);
		manageri.persist(quiz2);
		manageri.persist(quiz3);

		manageri.persist(quiz4);
		manageri.persist(quiz5);
		manageri.persist(quiz6);
		manageri.persist(quiz7);


		transaktio.commit();
		
		//haetaan ja tulostetaan kaikki kannassa olevat quiz-entiteetit
		@SuppressWarnings("unchecked")
		List<Quiz> entiteetit = manageri.createNamedQuery("haeKaikki")
				.getResultList();
		System.out.println("Tulostetaan quizin entiteetit");
		for (Quiz e : entiteetit) {
			System.out.println(e);
		}

	
		manageri.close();
		tehdas.close();

        // Lopetetaan h2-palvelin
        server.stop();
	}
}