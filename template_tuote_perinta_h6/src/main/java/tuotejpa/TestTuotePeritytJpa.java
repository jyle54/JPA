package tuotejpa;

import java.util.List;

import javax.persistence.*;

public class TestTuotePeritytJpa {

	public static void main(String[] args) throws Exception {
		// Startataan H2 TCP-serverimoodissa
        org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();

		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_tuoteperityt");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();

		Kirja k1 = new Kirja();
		k1.setIsbn("A123");
		k1.setNimi("Core Java");
		k1.setHinta(26.99); 
		k1.setTekijat("Cay Horstmann"); 

		Kirja k2 = new Kirja(); 
		k2.setIsbn("A223"); 
		k2.setNimi("JavaScript Ninja"); 
		k2.setTekijat("John Resig"); 
		k2.setHinta(33.50); 

		Kirja k3 = new Kirja(); 
		k3.setIsbn("A313"); 
		k3.setNimi("Thinking Of Java"); 
		k3.setTekijat("Bruce Eckel"); 
		k3.setHinta(9.95); 

		Cd cd1 = new Cd("Iron Maiden", 3048, 8);
		cd1.setHinta(19.95);
		cd1.setNimi("Powerslave");
	//	Cd cd1 = new Cd("Iron Maiden", "Powerslave", 3048, 8, 19.95); 
		Cd cd2 = new Cd("Tom Petty", 2398, 12);
		cd2.setHinta(14.95);
		cd2.setNimi("Full Moon Fever");
		Cd cd3 = new Cd("Paula Koivuniemi", 2850, 12); 
		cd3.setHinta(4.95);
		cd3.setNimi("Luotan Sydämen Ääneen");
		Cd cd4 = new Cd("The Beatles", 2545, 17); 
		cd4.setHinta(29.95);
		cd4.setNimi("Abbey Road");

		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k3);
		
		manageri.persist(cd1);
		manageri.persist(cd2);
		manageri.persist(cd3);
		manageri.persist(cd4);

		transaktio.commit();

		
		
		  @SuppressWarnings("unchecked")
	        List<Kirja> entiteetit = manageri.createNamedQuery("etsiKaikkiKirjat").getResultList();
		   System.out.println("Tulostetaan kirjat: ");  
		  for (Kirja e : entiteetit) {
	            System.out.println(e);
	        }
		
		  @SuppressWarnings("unchecked")
	        List<Cd> entiteetit2 = manageri.createNamedQuery("etsiKaikkicdt").getResultList();
		  System.out.println(); 
		  System.out.println("Tulostetaan cdt: ");  
		  for (Cd e : entiteetit2) {
	            System.out.println(e);
	        }
		
		  @SuppressWarnings("unchecked")
	        List<Tuote> entiteetit3 = manageri.createNamedQuery("etsiKaikkituotteet").getResultList();
		  System.out.println();
		  System.out.println("Tulostetaan tuotteet: ");  
		  for (Tuote e : entiteetit3) {
	            System.out.println(e);
	        }
		
		  @SuppressWarnings("unchecked")
	        List<Cd> entiteetit4 = manageri.createNamedQuery("etsiKaalliitLevyt").getResultList();
		  System.out.println();
		  System.out.println("Tulostetaan kalliit cdt: ");  
		  for (Tuote e : entiteetit4) {
	            System.out.println(e);
	        }
		  
		  @SuppressWarnings("unchecked")
	        List<Tuote> entiteetit5 = manageri.createNamedQuery("etsihalvattuotteet").getResultList();
		  System.out.println();
		  System.out.println("Tulostetaan halvat tuotteet: ");  
		  for (Tuote e : entiteetit5) {
	            System.out.println(e);
	        }
		  
		  
		manageri.close();
		tehdas.close();
        // Lopetetaan h2-palvelin
        server.stop();

	}
}
