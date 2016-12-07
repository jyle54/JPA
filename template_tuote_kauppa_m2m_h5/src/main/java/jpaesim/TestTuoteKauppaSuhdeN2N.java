package jpaesim;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class TestTuoteKauppaSuhdeN2N {

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

        List<Tuote> tuotteet = new ArrayList<>();
        tuotteet.add(t1);
        
        List<Tuote> tuotteet2 = new ArrayList<>();
        tuotteet2.add(t1);
        tuotteet2.add(t3);
        
        List<Tuote> tuotteet3 = new ArrayList<>();
        tuotteet3.add(t3);
        
        List<Kauppa> kauppa1 = new ArrayList<>();
        kauppa1.add(k1);
        kauppa1.add(k2);
        
        List<Kauppa> kauppa2 = new ArrayList<>();
        kauppa2.add(k2);
        kauppa2.add(k3);
        
        k1.setTuotteet(tuotteet);
        k2.setTuotteet(tuotteet2);
        k3.setTuotteet(tuotteet3);
        
        t1.setKaupat(kauppa1);
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
        System.out.println(); 
        System.out.println("Tulostetaan kaupoissa oelvat tuotteet: ");  
	  for (Kauppa e : entiteetit) {
            System.out.println(e);
        }
	  
	  @SuppressWarnings("unchecked")
      List<Tuote> entiteetit2 = manageri.createNamedQuery("selecttuotteet").getResultList();
	  System.out.println();
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
