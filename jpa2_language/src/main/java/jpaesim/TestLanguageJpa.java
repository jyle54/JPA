package jpaesim;

import java.util.List;

import javax.persistence.*;

public class TestLanguageJpa {

	public static void main(String[] args) throws Exception {

		 // Startataan H2 TCP-serverimoodissa
         org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();

		 EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_hello");
	        EntityManager manageri = tehdas.createEntityManager();

	        EntityTransaction transaktio = manageri.getTransaction();	        
	        transaktio.begin();
	        
	        Language l1 = new Language();
	        l1.setName("Englanti");
	        l1.setCode("en");
	        
	        Language l2 = new Language();
	        l2.setName("Ruotsi");
	        l2.setCode("se");

	        Language l3 = new Language();
	        l3.setName("Suomi");
	        l3.setCode("fi");

	        Language l4 = new Language();
	        l4.setName("Norja");
	        l4.setCode("no");

	        manageri.persist(l1);
	        manageri.persist(l2);
	        manageri.persist(l3);
	        manageri.persist(l4);
	       
	       // manageri.persist(l1);
	       // manageri.remove(l1);
	        
	        transaktio.commit();

	        // Testihaku - haetaan ja tulostetaan kaikki kannassa olevat Language-entiteetit
	        @SuppressWarnings("unchecked")
			List<Language> entiteetit = manageri.createNamedQuery("selectAll").getResultList();
	        for (Language e : entiteetit) {
	            System.out.println("Rivi: " + e.getName());
	        }


	        manageri.close();
	        tehdas.close();

            // Lopetetaan h2-palvelin
	        server.stop();

	}

}
