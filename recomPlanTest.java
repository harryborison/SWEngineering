package javaCode;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 makepaln_list
 Plan[] recPlan
 o matchtelecom
 o matchtype
 + matchprice
 + matchdiff
 + matchdata
 matchoption
 */
public class recomPlanTest {

	@Test
	public void testMakepaln_list() {
		//DB 사용 불가
	}

	@Test
	public void testRecPlan() {
		//DB 사용 불가
	}

	@Test
	public void testMatchtelecom() {
		recomPlan p = new recomPlan();
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
		recomPlan p = new recomPlan();
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
	
	//planprice >= lowprice && planprice <= highprice
	assertEquals(5,p.matchprice(10000,10000,30000));
	assertEquals(5,p.matchprice(20000,10000,30000));
	assertEquals(5,p.matchprice(30000,10000,30000));

	//0<diff<=5000
	assertEquals(3,p.matchprice(30001,20000,30000));
	assertEquals(3,p.matchprice(35000,20000,30000));
	
	assertEquals(3,p.matchprice(19999,20000,30000));
	assertEquals(3,p.matchprice(15000,20000,30000));
	
	//5000<diff<=10000
	assertEquals(2,p.matchprice(35001,20000,30000));
	assertEquals(2,p.matchprice(40000,20000,30000));
	
	assertEquals(2,p.matchprice(14999,20000,30000));
	assertEquals(2,p.matchprice(10000,20000,30000));
	
	//10000<diff<=20000
	assertEquals(1,p.matchprice(40001,20000,30000));
	assertEquals(1,p.matchprice(50000,20000,30000));
	
	assertEquals(1,p.matchprice(9999,20000,30000));
	assertEquals(1,p.matchprice(0,20000,30000));
	
	//else
	assertEquals(0,p.matchprice(60001,30000,40000));
	assertEquals(0,p.matchprice(9999,30000,40000));
	
	}

	@Test
	public void testMatchdiff() {
		
		//0<diff<=5000
		assertEquals(3,p.matchdiff(1));
		assertEquals(3,p.matchdiff(5000));
		
		//5000<diff<=10000
		assertEquals(2,p.matchdiff(5001));
		assertEquals(2,p.matchdiff(10000));
		
		//10000<diff<=20000
		assertEquals(1,p.matchdiff(10001));
		assertEquals(1,p.matchdiff(20000));
		
		//else
		assertEquals(0,p.matchdiff(20001));
	
	}

	@Test
	public void testMatchdata() {
	
		//무제한
		assertEquals(5,p.matchdata(500000,500000));
		
		//0<=dif<500
		assertEquals(5,p.matchdata(9501,10000));
		assertEquals(5,p.matchdata(10000,10000));
		assertEquals(5,p.matchdata(10499,10000));
		
		//500<=dif<1000
		assertEquals(4,p.matchdata(9001,10000));
		assertEquals(4,p.matchdata(9500,10000));
		assertEquals(4,p.matchdata(10500,10000));
		assertEquals(4,p.matchdata(10999,10000));
		
		//1000<=dif<1500
		assertEquals(3,p.matchdata(8501,10000));
		assertEquals(3,p.matchdata(9000,10000));
		assertEquals(3,p.matchdata(11000,10000));
		assertEquals(3,p.matchdata(11499,10000));
		
		//1500<=dif<2000
		assertEquals(2,p.matchdata(8001,10000));
		assertEquals(2,p.matchdata(8500,10000));
		assertEquals(2,p.matchdata(11500,10000));
		assertEquals(2,p.matchdata(11999,10000));
		
		//2000<=dif<2500
		assertEquals(1,p.matchdata(7501,10000));
		assertEquals(1,p.matchdata(8000,10000));
		assertEquals(1,p.matchdata(12000,10000));
		assertEquals(1,p.matchdata(12499,10000));
		
		//else
		assertEquals(0,p.matchdata(7001,10000));
		assertEquals(0,p.matchdata(7500,10000));
		assertEquals(0,p.matchdata(12500,10000));
		assertEquals(0,p.matchdata(12999,10000));
	}
	
	@Test
	public void testMatchoption() {
	
	//DB 사용 불가
	
	}

}
