package jpaharkat;

import javax.persistence.*;

import java.util.*;



/*
 Harjoituksissa voi käyttää pohjana esimerkkejä, joita löytyy osoitteesta:
 
 http://www.objectdb.com/java/jpa/query/execute
 
 1. Lisätään JPA-luokkaan SimpleEntity uusi ominaisuus.
 
 String desc;
  
  Muuta ohjelmaa siten, että saat tallennettua tiedot tietokantaan.

2. Haku - haetaan ja tulostetaan kaikki kannassa olevat SimpleEntity-entiteetit
Käytetään metodia createNamedQuery("selectAll")

3. Haku 

Haetaan ja tulostetaan kaikki kannassa olevat kirjaimella K alkavat entiteetit.
Tehdään haku käyttäen TypedQuery -luokkaa

		TypedQuery<String> kysely = manageri.createQuery("kysely", TulosLuokkasi.class);
		List<String> tulokset = kysely.getResultList();


4. Haku 
haetaan ja tulostetaan kaikki kannassa olevat kirjaimen A sisältävät entiteetit


5. Haku - Käytätään parametrisoitua kyselyä, jossa kyselylle voidaan antaa parametri

kysely.setParameter("name", "%l%").getResultList();

		
6. Poista kaikki ne, jotka sisältävät ä-kirjaimen ja  poista myös ne rivit, jotka sisältävät l-kirjaimen.
Tee ensin kysely.

*/

class Main {
	public static void main(String[] args) throws Exception {
		 // Startataan H2 TCP-serverimoodissa
         org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();


		EntityManagerFactory tehdas = Persistence
				.createEntityManagerFactory("jpa_SimpleEntity_harjoitus");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();

		SimpleEntity p1 = new SimpleEntity();
		p1.setName("Kello");
		p1.setDesc("rannekello");
		
		SimpleEntity p2 = new SimpleEntity();
		p2.setName("Kenkä");
		p2.setDesc("Lenkkarit");
		
		SimpleEntity p3 = new SimpleEntity();
		p3.setName("Kala");
		p3.setDesc("Hauki");

		SimpleEntity p4 = new SimpleEntity();
		p4.setName("Kukka");
		p4.setDesc("Ruusu");

		manageri.persist(p1);
		manageri.persist(p2);
		manageri.persist(p3);
		manageri.persist(p4);

		transaktio.commit();
		
		// 1. Lisätään JPA-luokkaan uusi ominaisuus. Muuta ohjelmaa siten, että saat
		// tallennettua tiedot tietokantaan.

		// 2. Haku - haetaan ja tulostetaan kaikki kannassa olevat
		// SimpleEntity-entiteetit
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit = manageri.createNamedQuery("selectAll")
				.getResultList();
		System.out.println("Tulostetaan kaikki");
		for (SimpleEntity e : entiteetit) {
			System.out.println("Rivi: " + e.getName());
		}

		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit2 = manageri.createNamedQuery("etsiKirjain")
		.getResultList();
		System.out.println();
		System.out.println("Tulostetaan entiteetit, jotka alkaa k-kirjaimella");
		for (SimpleEntity e : entiteetit2) {
			System.out.println("Rivi: " + e.getName());
		}

		
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit3 = manageri.createNamedQuery("etsiKirjain2")
		.getResultList();
		System.out.println();
		System.out.println("Tulostetaan entiteetit, joissa a kirjain");
		for (SimpleEntity e : entiteetit3) {
			System.out.println("Rivi: " + e.getName());
		}
		
		
		String name2 = "%l%";
		TypedQuery<SimpleEntity> query = manageri.createQuery(
		        "SELECT a FROM SimpleEntity a WHERE a.name LIKE :name", SimpleEntity.class);
		List<SimpleEntity> tuloslist = query.setParameter("name", name2).getResultList();
		System.out.println();
		System.out.println("Haetaan entiteetit, joissa l-kirjain ");
		System.out.println();
		for (SimpleEntity e: tuloslist) {
	            System.out.println("Rivi: " + e.getName() );
			}
		
		
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit4 = manageri.createNamedQuery("etsiKirjain3")
		.getResultList();
		transaktio.begin();
		System.out.println();
		System.out.println("Tulostetaan ja positetaan entiteetit, joissa on ä tai l kirjain");
		for (SimpleEntity e : entiteetit4) {
			System.out.println("Rivi: " + e.getName());
			manageri.remove(e);
		}
		transaktio.commit();
		
		manageri.close();
		tehdas.close();

        // Lopetetaan h2-palvelin
        server.stop();

	}
}