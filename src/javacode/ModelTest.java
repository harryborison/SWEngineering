
package javacode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelTest {
	Model model = new Model();
	

	
	@Test
	public void testGetPhoneName() {
		
		model.setPhoneName("harry");
		assertEquals("harry",model.getPhoneName());
		
	}

	@Test
	public void testSetPhoneName() {

		model.setPhoneName("asdf");
		assertEquals("asdf",model.getPhoneName());
	
	}

	@Test
	public void testGetCompany() {
	
		model.setCompany("mycom");
		assertEquals("mycom",model.getCompany());

	
	
	}

	@Test
	public void testSetCompany() {
		
		model.setCompany("mycom");
		assertEquals("mycom",model.getCompany());

	
	}

	@Test
	public void testGetPhonePrice() {
		model.setPhonePrice(1234);
		assertEquals(1234,model.getPhonePrice());

	}

	@Test
	public void testSetPhonePrice() {
		model.setPhonePrice(1234);
		assertEquals(1234,model.getPhonePrice());

	}

	@Test
	public void testGetScreenSize() {
		model.setScreenSize(1.123);
		assertEquals(1.123,model.getScreenSize(),0);

	
	}

	@Test
	public void testSetScreenSize() {
		model.setScreenSize(1.123);
		assertEquals(1.123,model.getScreenSize(),0);
	}

	@Test
	public void testGetOs() {
		
		model.setOs("sss");
		assertEquals("sss",model.getOs());

	}

	@Test
	public void testSetOs() {
		model.setOs("kt");
		assertEquals("kt",model.getOs());
	}

	@Test
	public void testGetCapacity() {
		model.setCapacity(50);
		assertEquals(50,model.getCapacity());

		
		
	}

	@Test
	public void testSetCapacity() {
		model.setCapacity(50);
		assertEquals(50,model.getCapacity());
	}

	@Test
	public void testGetRAM() {
		
		model.setRAM(3);
		assertEquals(3,model.getRAM());

		
	}

	@Test
	public void testSetRAM() {
		model.setRAM(3);
		assertEquals(3,model.getRAM());

	}

	@Test
	public void testGetFrontCamera() {
		
		model.setFrontCamera(50);
		assertEquals(50,model.getFrontCamera());

	}

	@Test
	public void testSetFrontCamera() {
		model.setFrontCamera(50);
		assertEquals(50,model.getFrontCamera());
	}

	@Test
	public void testGetRearCamera() {
		
		model.setFrontCamera(1100);
		assertEquals(1100,model.getFrontCamera());
		
	}

	@Test
	public void testSetRearCamera() {
		model.setFrontCamera(1100);
		assertEquals(1100,model.getFrontCamera());
	}

	@Test
	public void testGetWeight() {
		model.setWeight(123);
		assertEquals(123,model.getWeight());
	}

	@Test
	public void testSetWeight() {
		model.setWeight(123);
		assertEquals(123,model.getWeight());
	}

	@Test
	public void testGetPhoneSize() {
		
		model.setPhoneSize("15.3");
		assertEquals("15.3",model.getPhoneSize());
	}

	@Test
	public void testSetPhoneSize() {
		model.setPhoneSize("15.3");
		assertEquals("15.3",model.getPhoneSize());
	}

	@Test
	public void testGetBetteryCapacity() {
		
		model.setBetteryCapacity(3500);
		assertEquals(3500,model.getBetteryCapacity());
		
		
	}

	@Test
	public void testSetBetteryCapacity() {
		model.setBetteryCapacity(3500);
		assertEquals(3500,model.getBetteryCapacity());
		
	}

	@Test
	public void testGetSpeed() {
		model.setSpeed(1.23);
		assertEquals(1.23,model.getSpeed(),0);
	}

	@Test
	public void testSetSpeed() {
		model.setSpeed(1.23);
		assertEquals(1.23,model.getSpeed(),0);
	}

	@Test
	public void testGetResolution() {

		model.setResolution("1920*330");
		assertEquals("1920*330",model.getResolution());
	
	}

	@Test
	public void testSetResolution() {
		model.setResolution("1920*330");
		assertEquals("1920*330",model.getResolution());
	}

	@Test
	public void testGetReleaseYear() {

		model.setReleaseYear(2019);
		assertEquals(2019,model.getReleaseYear());

	
	
	}

	@Test
	public void testSetReleaseYear() {
		model.setReleaseYear(2019);
		assertEquals(2019,model.getReleaseYear());
	}

	@Test
	public void testGetColor() {
		
		model.setColor("Red");
		assertEquals("Red",model.getColor());

		
		
		
	}

	@Test
	public void testSetColor() {
		model.setColor("Red");
		assertEquals("Red",model.getColor());
	}

	@Test
	public void testGetLink() {
		
		model.setColor("www.nbaver.com");
		assertEquals("www.nbaver.com",model.getColor());

	}

	@Test
	public void testSetLink() {
		model.setColor("www.nbaver.com");
		assertEquals("www.nbaver.com",model.getColor());

	}

	@Test
	public void testGetRecCount() {

		model.setRecCount(50);
		assertEquals(50,model.getRecCount());
	
	
	}

	@Test
	public void testSetRecCount() {
		model.setRecCount(50);
		assertEquals(50,model.getRecCount());
	
	
	}

	@Test
	public void testGetVideolink() {
		
		model.setVideolink("asdf.naver.com");
		assertEquals("asdf.naver.com",model.getVideolink());
	
		
	}

	@Test
	public void testSetVideolink() {
		model.setVideolink("asdf.naver.com");
		assertEquals("asdf.naver.com",model.getVideolink());
	}

}
