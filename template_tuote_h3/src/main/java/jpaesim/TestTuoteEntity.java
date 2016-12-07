package jpaesim;

import java.util.List;

import javax.persistence.*;



public class TestTuoteEntity {

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
	        
	        
	        manageri.persist(t1);
	        manageri.persist(t2);
	        manageri.persist(t3);
	        
	        transaktio.commit();
	        
	        @SuppressWarnings("unchecked")
	        List<Tuote> entiteetit = manageri.createNamedQuery("selectAll").getResultList();
	        for (Tuote e : entiteetit) {
	            System.out.println("Rivi: " + e.getNimi() );
	        }
	        
	        manageri.close();
	        tehdas.close();
        // Lopetetaan h2-palvelin
        server.stop();
	}

}
