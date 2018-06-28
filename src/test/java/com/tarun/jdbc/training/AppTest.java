package com.tarun.jdbc.training;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Create the test case.
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * Suite.
	 *
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-).
	 */
	public void testSimpleJDBCConnection() {
		App app = new App();
		app.testSimpleJDBCConnection();
		assertTrue(true);
	}
	
	public void testPreparedStatement() {
		App app = new App();
		app.testPreparedStatement();
		assertTrue(true);
	}

}
