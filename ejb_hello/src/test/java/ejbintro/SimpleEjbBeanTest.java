package ejbintro;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/* 
 EJB papuja voi testata käyttäen embedded EJBContainer APIa EJB 3.1:ssa.
Testiympäristönä OpenEJB (TomEE embedded)

 */

public class SimpleEjbBeanTest {

	private static EJBContainer ejbContainer;

	private HelloBeanLocal hellobean;  // Local interface
	private HelloBean2Remote hellobean2; // Remote interface

	@BeforeClass
	public static void startContainer() {
		ejbContainer = EJBContainer.createEJBContainer();
	}

	@AfterClass
	public static void stopContainer() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}

	@Before
	public void findBean() throws NamingException {

		// JNDI nimiviittaus: ejb_statelessbean_simple on paikka, jossa
		// MySimpleBean sijaitsee
		Object object = ejbContainer.getContext().lookup(
				"java:global/ejb_hello/HelloBean");

		assertTrue(object instanceof HelloBeanLocal);
		hellobean = (HelloBeanLocal) object;


	    Object object2 = ejbContainer.getContext().lookup(
				"java:global/ejb_hello/HelloBean2");

		assertTrue(object2 instanceof HelloBean2Remote);
		hellobean2 = (HelloBean2Remote) object2;

	}

	/**
	 * testataan helloWorld() -metodia ja sen palauttamaan arvoa.
	 */
	@Test
	public void testHello() throws NamingException {
		System.out.println("hello() test");

		String result = hellobean.hello();
		assertEquals("hello from EJB!", result);
	}

	/**
	 * Test of randomly generating string method.
	 */
	@Test
	public void testRandomString() throws NamingException {
		System.out.println("randomStr() test (HelloBeanLocal Local interface)");

		String result = hellobean.randomStr();
		System.out.println("randomStr: " + result);
		assertEquals((Integer)5, (Integer)result.length());
	}

    /**
	 * Test of randomly generating string method.
	 */
	@Test
	public void testRandomString2() throws NamingException {
		System.out.println("randomStr() test (HelloBean2Remote Remote interface)");

		String result = hellobean2.randomStr(20);
		System.out.println("randomStr: " + result);
		assertEquals((Integer)20, (Integer)result.length());
	}


}
