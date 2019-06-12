package javaCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class recomPlanTest {

	@Test
	public void testMakepaln_list() {
	
	}

	@Test
	public void testRecPlan() {
	
	}

	@Test
	public void testMatchtelecom() {
		recomPlan p = new recomPlan();
		String[] wanttel = new String[3];
		wanttel[0] = "SK";
		wanttel[1] = "KT";
		wanttel[2] = "LG U+";
		
		assertEquals(3,p.matchtelecom("SK", wanttel));
		assertEquals(3,p.matchtelecom("KT", wanttel));
		assertEquals(3,p.matchtelecom("LG U+", wanttel));
		assertEquals(0,p.matchtelecom("SKT", wanttel));
		assertEquals(0,p.matchtelecom("LGU+", wanttel));
		
		
	}

	@Test
	public void testMatchtype() {
	
	
	}

	@Test
	public void testMatchprice() {
	
	
	
	}

	@Test
	public void testMatchdiff() {
	
	}

	@Test
	public void testMatchdata() {
	
	
	}

	@Test
	public void testMatchoption() {
	
	
	
	}

}
