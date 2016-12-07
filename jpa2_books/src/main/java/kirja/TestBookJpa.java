package kirja;

import java.util.List;

import javax.persistence.*;



 public class TestBookJpa {

	 public static void main(String[] args) throws Exception {
	 // Startataan H2 TCP-serverimoodissa
	         org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();
 
	        EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_books");
	        EntityManager manageri = tehdas.createEntityManager();

	        EntityTransaction transaktio = manageri.getTransaction();

	        transaktio.begin();

	        Book b1 = new Book();
	        b1.setName("Java: A Beginner's Guide");
	        b1.setAuthor("Herbert Schildt");
	        b1.setEdition("6th Edition");
	        b1.setPublisher("McGraw-Hill Education");
	        b1.setPages(728);
	        b1.setLanguage("English");
	        b1.setAsin("978-0071809252");
	        
	        Book b2 = new Book();
	        b2.setName("Elements of Programming Interviews in Java");
	        b2.setAuthor("Adnan Aziz");
	        b2.setEdition("2nd edition");
	        b2.setPublisher("CreateSpace Independent Publishing Platform");
	        b2.setPages(542);
	        b2.setLanguage("English");
	        b2.setAsin("978-1517435806");
	        
	        Book b3 = new Book();
	        b3.setName("Functional Java: A Guide to Lambdas and Functional Programming in Java 8");
	        b3.setAuthor("Nick Maiorano");
	        b3.setEdition("1st edition");
			b3.setPublisher("ThoughtFlow Solutions inc.");
			b3.setPages(208);
			b3.setLanguage("English");
			b3.setAsin("B00JZ7GD46");
	        
	        Book b4 = new Book();
	        b4.setName("Java 8 in Action: Lambdas, Streams, and functional-style programming");
	        b4.setAuthor("Raoul-Gabriel Urma");
	        b4.setEdition("1st edition");
			b4.setPublisher("Manning Publications");
			b4.setPages(424);
			b4.setLanguage("English");
			b4.setAsin("978-1617291999");
	        
	        Book b5 = new Book();
	        b5.setName("Getting started with Spring Framework");
	        b5.setAuthor("J Sharma");
	        b5.setEdition("3th Edition");
			b5.setPublisher("Amazon Digital Services LLC");
			b5.setPages(626);
			b5.setLanguage("English");
			b5.setAsin("B01HZXQFUS");
	                
	        Book b6 = new Book();
	        b6.setName("Java EE 7: The Big Picture");
	        b6.setAuthor("Dr. Danny Coward");
	        b6.setEdition("1st edition");
			b6.setPublisher("McGraw-Hill Education");
			b6.setPages(512);
			b6.setLanguage("English");
			b6.setAsin("978-0071837347");
	        
			Book b7 = new Book();
	        b7.setName("Murach's Java Servlets and JSP");
	        b7.setAuthor("Joel Murach");
	        b7.setEdition("3rd edition");
			b7.setPublisher("Mike Murach & Associates");
			b7.setPages(758);
			b7.setLanguage("English");
			b7.setAsin("978-1890774783");
	        
			Book b8 = new Book();
	        b8.setName("Java EE 7 Essentials: Enterprise Developer Handbook");
	        b8.setAuthor("Arun Gupta");
	        b8.setEdition("1st edition");
			b8.setPublisher("O'Reilly Media");
			b8.setPages(362);
			b8.setLanguage("English");
			b8.setAsin("978-1449370176");
	        
			manageri.persist(b1);
	        manageri.persist(b2);
	        manageri.persist(b3);
	        manageri.persist(b4);
	        manageri.persist(b5);
	        manageri.persist(b6);
	        manageri.persist(b7);
	        manageri.persist(b8);
	        
	        transaktio.commit();

	        @SuppressWarnings("unchecked")
			List<Book> entiteetit = manageri.createNamedQuery("selectAll").getResultList();
	        for (Book e : entiteetit) {
	            System.out.println("Rivi: " + e.getName() );
	        }
	        
	        @SuppressWarnings("unchecked")
	        List<Book> books = manageri.createNamedQuery("searchAllBooks").getResultList();
	        System.out.println();
	        for (Book e : books) {
	        System.out.println("Rivi: " + e.getName() );
	        }
	      /*  
	        TypedQuery<String> kysely = manageri.createQuery(
					"SELECT bk.name FROM Book AS bk where bk.name LIKE 'Java 8%'",
					String.class);
			List<String> haetut = kysely.getResultList();
			System.out.println();
			System.out.println("Java 8-alkuiset kirjat ");
			for (String tulos : haetut) {
				System.out.println(tulos);
			}
	    */
			@SuppressWarnings("unchecked")
				List<Book> entiteetit3 = manageri.createNamedQuery("etsiNimella2").getResultList();
			System.out.println();
			System.out.println("Java 8-alkuiset kirjat ");    
			for (Book e : entiteetit3) {
		            System.out.println("Rivi: " + e.getName() );
		        }
		
			
			@SuppressWarnings("unchecked")
			List<Book> entiteetit2 = manageri.createNamedQuery("etsiNimella").getResultList();
	        transaktio.begin();
			System.out.println();
			System.out.println("Java EE-alkuiset kirjat ");
			for (Book e : entiteetit2) {
	            System.out.println("Rivi: " + e.getName() );
				manageri.remove(e);
	        }
			transaktio.commit();
	        
			Book tulos = new Book();
	        String name = "Java: A Beginner's Guide";
			TypedQuery<Book> query = manageri.createQuery(
			        "SELECT c FROM Book c WHERE c.name = :name", Book.class);
			 tulos = query.setParameter("name", name).getSingleResult();
			System.out.println();
			 System.out.println("Haetaan kirjaa nimellä " +name);
			 System.out.println(tulos);
	        
			
			String name2 = "%Java%";
			TypedQuery<Book> query2 = manageri.createQuery(
			        "SELECT c FROM Book c WHERE c.name LIKE :name", Book.class);
			List<Book> tuloslist = query2.setParameter("name", name2).getResultList();
			System.out.println();
			System.out.println("Haetaan kaikki kirjat, joiden nimessä on Java ");
			System.out.println();
			for (Book e: tuloslist) {
		            System.out.println("Rivi: " + e.getName() );
				}
			
			
			
	        manageri.close();
	        tehdas.close();

            // Lopetetaan h2-palvelin
	        server.stop();

	        // TODO: create and persist Book entities

	    }
	 }
	