package javaCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class recomPhoneTest {

	@Test
	public void testMakemodel_list() {
		
		recomPhone rec = new recomPhone();
		rec.makemodel_list();
		int len;
		int result;
		len=rec.phonelist.size();
		if(len>0)
		{
			result = 1;
		}
		else
		{
			result = 0;
		}
		assertEquals(result,1);
		for(int i=0; i< len ; i++)
		{
			assertNotNull(rec.phonelist.get(i));
		}
	
	
	}

	@Test
	public void testRecom() {
	
		
		
		
		
	}

	@Test
	public void testMatchcompany() {
		
		recomPhone rec = new recomPhone();
		String[] company = new String[3];
		String[] company2 = new String[1];
		company[0] = "SAMSUNG";
		company[1] = "LG";
		company[2] = "»þ¿À¹Ì";
		company2[0] = "LG";
        assertEquals(3,  rec.matchcompany("SAMSUNG",company));
        assertEquals(3,  rec.matchcompany("LG",company));
        assertEquals(3,  rec.matchcompany("»þ¿À¹Ì",company));
        assertEquals(0,  rec.matchcompany("NULL",company));
        assertEquals(0,  rec.matchcompany("samsung",company));
        assertEquals(0,  rec.matchcompany("lg",company));
        assertEquals(3,  rec.matchcompany("LG",company2));
        assertEquals(0,  rec.matchcompany("NULL",company2));
	}

	@Test
	public void testMatchprice() {
		recomPhone rec = new recomPhone();
		assertEquals(10 ,rec.matchprice(100000,10000,200000));
		assertEquals(10 ,rec.matchprice(200000,10000,200000));
		assertEquals(8 ,rec.matchprice(100000,150000,200000));
		assertEquals(8 ,rec.matchprice(100000,200000,250000));
		assertEquals(8 ,rec.matchprice(100000,10000,50000));
		assertEquals(8 ,rec.matchprice(200000,10000,100000));
		assertEquals(6 ,rec.matchprice(250000,400000,600000));
		assertEquals(6 ,rec.matchprice(400000,100000,200000));
		assertEquals(4 ,rec.matchprice(300000,600000,700000));
		assertEquals(4 ,rec.matchprice(1000000,300000,750000));
		assertEquals(2 ,rec.matchprice(500000,850000,900000));
		assertEquals(2 ,rec.matchprice(1000000,1350000,1750000));
		assertEquals(0 ,rec.matchprice(100000,850000,900000));
		assertEquals(0 ,rec.matchprice(100000,1350000,1750000));
		
	}

	@Test
	public void testMatchpurpose() {

	
	
	
	
	
	
	
	}

	@Test
	public void testCalcGame() {
	
		recomPhone rec = new recomPhone();
		assertEquals(8 ,rec.calcGame(11,7));
		assertEquals(8 ,rec.calcGame(10,6));
		assertEquals(6 ,rec.calcGame(8,6));
		assertEquals(6 ,rec.calcGame(8,6.1));
		assertEquals(5 ,rec.calcGame(8,4));
		assertEquals(5 ,rec.calcGame(6,6.5));
		assertEquals(5 ,rec.calcGame(6,8));
		assertEquals(0 ,rec.calcGame(3,1.999));
		assertEquals(0 ,rec.calcGame(0,0));
		assertEquals(1 ,rec.calcGame(0,2));
		assertEquals(2 ,rec.calcGame(0,4));
		assertEquals(3 ,rec.calcGame(0,6));
		
		
		
	
	
	}

	@Test
	public void testCalcstorage() {
		recomPhone rec = new recomPhone();
		assertEquals(4 ,rec.calcstorage(500));
		assertEquals(4 ,rec.calcstorage(10000));
		assertEquals(2 ,rec.calcstorage(499));
		assertEquals(2 ,rec.calcstorage(250));
		assertEquals(1 ,rec.calcstorage(100));
		assertEquals(1 ,rec.calcstorage(249));
		assertEquals(0 ,rec.calcstorage(0));
		assertEquals(0 ,rec.calcstorage(99));
		
		
		
		
	}

	@Test
	public void testCalcbattery() {
		recomPhone rec = new recomPhone();
		assertEquals(3 ,rec.calcbattery(4000));
		assertEquals(3 ,rec.calcbattery(5000));
		assertEquals(2 ,rec.calcbattery(3500));
		assertEquals(2 ,rec.calcbattery(3800));
		assertEquals(1 ,rec.calcbattery(3000));
		assertEquals(1 ,rec.calcbattery(3499));
		assertEquals(0 ,rec.calcbattery(0));
		assertEquals(0 ,rec.calcbattery(2500));
		
		
		
		
	}

	@Test
	public void testCalcNew() {
		recomPhone rec = new recomPhone();
		assertEquals(3 ,rec.calcNew(2019));
		assertEquals(1 ,rec.calcNew(2018));
		assertEquals(0 ,rec.calcNew(2017));
		assertEquals(0 ,rec.calcNew(2020));
			
	}

	@Test
	public void testCalccamera() {
		
		recomPhone rec = new recomPhone();
		assertEquals(7,rec.calccamera(2000,4000));
		assertEquals(6,rec.calccamera(1000,4000));
		assertEquals(5,rec.calccamera(700,4000));
		assertEquals(5,rec.calccamera(1000,3000));
		assertEquals(3,rec.calccamera(1000,1999));
		assertEquals(3,rec.calccamera(1500,1500));
		assertEquals(1,rec.calccamera(700,0));
		assertEquals(1,rec.calccamera(999,0));
		assertEquals(1,rec.calccamera(650,1500));
		assertEquals(1,rec.calccamera(0,1500));
		
		assertEquals(0,rec.calccamera(699,1499));
		assertEquals(0,rec.calccamera(0,0));
		
		
		
	
	}

	@Test
	public void testCalcscreen() {
		recomPhone rec = new recomPhone();
		
		assertEquals(3 ,rec.calcscreen(6));
		assertEquals(3 ,rec.calcscreen(6.5));
		assertEquals(2 ,rec.calcscreen(5.5));
		assertEquals(2 ,rec.calcscreen(5.8));
		assertEquals(1 ,rec.calcscreen(5.0));
		assertEquals(1 ,rec.calcscreen(5.49));
		assertEquals(1 ,rec.calcscreen(5.0));
		
		assertEquals(0 ,rec.calcscreen(4.99));
		assertEquals(0 ,rec.calcscreen(0));
		
		
		
		
		
		
		
	}

	@Test
	public void testCalclight() {
		recomPhone rec = new recomPhone();
		
		assertEquals(3 ,rec.calclight(150));	
		assertEquals(3 ,rec.calclight(175));
		assertEquals(2 ,rec.calclight(176));
		assertEquals(2 ,rec.calclight(185));
		assertEquals(1 ,rec.calclight(186));
		assertEquals(1 ,rec.calclight(199));
		assertEquals(0 ,rec.calclight(200));
		assertEquals(0 ,rec.calclight(205));
		
		
		
		
	}

	@Test
	public void testCalcdiff() {
	
		recomPhone rec = new recomPhone();
		assertEquals(8 ,rec.calcdiff(100000));	
		assertEquals(8 ,rec.calcdiff(0));
		assertEquals(8 ,rec.calcdiff(1000));
		
	
		assertEquals(6 ,rec.calcdiff(100001));	
		assertEquals(6 ,rec.calcdiff(150000));
		assertEquals(6 ,rec.calcdiff(200000));
		
		
		assertEquals(4 ,rec.calcdiff(200001));	
		assertEquals(4 ,rec.calcdiff(300000));
		assertEquals(4 ,rec.calcdiff(250000));
		
		assertEquals(2 ,rec.calcdiff(300001));	
		assertEquals(2 ,rec.calcdiff(350000));
		assertEquals(2 ,rec.calcdiff(400000));
		
		assertEquals(0 ,rec.calcdiff(400001));	
		
	
	
	
	
	
	
	
	
	
	}

}
