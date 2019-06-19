package javacode;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecomPlanTest {

	@Test
	public void testMakepaln_list() {
	
	}

	@Test
	public void testRecPlan() {
	
	}

	@Test
	public void testMatchtelecom() {
		RecomPlan p = new RecomPlan();
		String[] wanttel = new String[3];
		String[] wanttel2 = new String[1];
		wanttel[0]= "NULL";
		wanttel[0] = "SK";
		wanttel[1] = "KT";
		wanttel[2] = "LG U+";
		
		assertEquals(3,p.matchtelecom("SK", wanttel));
		assertEquals(3,p.matchtelecom("KT", wanttel));
		assertEquals(3,p.matchtelecom("LG U+", wanttel));
		assertEquals(0,p.matchtelecom("SKT", wanttel));
		assertEquals(0,p.matchtelecom("LGU+", wanttel));
		assertEquals(0,p.matchtelecom("LG U+", wanttel2));
		assertEquals(0,p.matchtelecom("SK", wanttel2));
		assertEquals(0,p.matchtelecom("KT", wanttel2));
		
		
	}

	@Test
	public void testMatchtype() {
		RecomPlan p = new RecomPlan();
		String[] wanttype = new String[2];
		wanttype[0] = "5G";
		wanttype[1] = "LTE";

		String[] wanttype2 = new String[1];
		wanttype2[0] = "5G";
		


		String[] wanttype3 = new String[1];
		wanttype3[0] = "NULL";

		
		
		assertEquals(3,p.matchtype("5G",wanttype));
		assertEquals(3,p.matchtype("LTE",wanttype));
		assertEquals(0,p.matchtype("LTE",wanttype2));
		assertEquals(3,p.matchtype("5G",wanttype2));
		
		assertEquals(0,p.matchtype("5G",wanttype3));
		assertEquals(0,p.matchtype("5G",wanttype3));
		
		
		
		
		
		
	
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
