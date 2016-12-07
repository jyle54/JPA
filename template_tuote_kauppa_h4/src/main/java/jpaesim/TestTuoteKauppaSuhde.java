package jpaesim;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class TestTuoteKauppaSuhde {

	public static void main(String[] args) throws Exception {
     	// Startataan H2 TCP-serverimoodissa
        org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();


		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_tuote");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();
		
		transaktio.begin();

		Tuote t1 = new Tuote();
		t1.setNimi("Pesäpallo");
		t1.setHinta(15.56);
		t1.setKoodi("A321");


		Tuote t2 = new Tuote();
		t2.setNimi("Jalkapallo");
		t2.setHinta(19.99);
		t2.setKoodi("A654");


		Tuote t3 = new Tuote();
		t3.setNimi("Koripallo");
		t3.setHinta(24.99);
		t3.setKoodi("B342");

		Kauppa k1 = new Kauppa();
		k1.setNimi("Palloliike");
		k1.setOsoite("Pallokuja 2, Helsinki");

		Kauppa k2 = new Kauppa();
		k2.setNimi("Välineaitta");
		k2.setOsoite("Kauppatie 45, Jyväskylä");

		Kauppa k3 = new Kauppa();
		k3.setNimi("Verkkosportti");
		k3.setOsoite("Kuplahallintie 15, Toijala");

		
		List<Kauppa> kauppa1 = new ArrayList<Kauppa>();
		kauppa1.add(k1);
		kauppa1.add(k2);
		
		t1.setKaupat(kauppa1);
		
		List<Kauppa> kauppa2 = new ArrayList<Kauppa>();
		kauppa2.add(k2);
		kauppa2.add(k3);
		
		t3.setKaupat(kauppa2);
		
		manageri.persist(t1);
		manageri.persist(t2);
		manageri.persist(t3);
		
		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k3);
		
		transaktio.commit();
		
		  @SuppressWarnings("unchecked")
	        List<Kauppa> entiteetit = manageri.createNamedQuery("selectKaupat").getResultList();
		   System.out.println("Tulostetaan kaupat: ");  
		  for (Kauppa e : entiteetit) {
	            System.out.println("Rivi: " + e.getNimi() );
	        }
		
		  System.out.println();
		  System.out.println("Tuote 1 on kaupoissa: ");
	     System.out.println(t1);   
	    
	     System.out.println("Tuote 3 on kaupoissa: ");
	     System.out.println(t3);   
	     
	     
	        @SuppressWarnings("unchecked")
	        List<Tuote> entiteetit2 = manageri.createNamedQuery("selecttuotteet").getResultList();
	        System.out.println("Tulostetaan missä kaupoissa tuotteet on: ");
	        for (Tuote e : entiteetit2) {
	            System.out.println(e );
	        }
	      
		manageri.close();
		tehdas.close();
		// Lopetetaan h2-palvelin
        server.stop();
	}
}
