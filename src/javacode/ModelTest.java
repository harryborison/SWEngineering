package javacode;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {
   Model model = new Model();
   

   
   @Test
   public void testGetPhoneName() {
      
      model.setPhoneName("harry");
      assertEquals(model.getPhoneName(),"harry");
      
   }

   @Test
   public void testSetPhoneName() {

      model.setPhoneName("asdf");
      assertEquals("asdf",model.getPhoneName());
   
   }

   @Test
   public void testGetCompany() {
   
      model.setCompany("mycom");
      assertEquals(model.getCompany(),"mycom");

   
   
   }

   @Test
   public void testSetCompany() {
      
      model.setCompany("mycom");
      assertEquals(model.getCompany(),"mycom");

   
   }

   @Test
   public void testGetPhonePrice() {
      model.setPhonePrice(1234);
      assertEquals(model.getPhonePrice(),1234);

   }

   @Test
   public void testSetPhonePrice() {
      model.setPhonePrice(1234);
      assertEquals(model.getPhonePrice(),1234);

   }

   @Test
   public void testGetScreenSize() {
      model.setScreenSize(1.123);
      assertEquals(model.getScreenSize(),1.123,0);

   
   }

   @Test
   public void testSetScreenSize() {
      model.setScreenSize(1.123);
      assertEquals(model.getScreenSize(),1.123,0);
   }

   @Test
   public void testGetOs() {
      
      model.setOs("sss");
      assertEquals(model.getOs(),"sss");

   }

   @Test
   public void testSetOs() {
      model.setOs("kt");
      assertEquals(model.getOs(),"kt");
   }

   @Test
   public void testGetCapacity() {
      model.setCapacity(50);
      assertEquals(model.getCapacity(),50);

      
      
   }

   @Test
   public void testSetCapacity() {
      model.setCapacity(50);
      assertEquals(model.getCapacity(),50);
   }

   @Test
   public void testGetRAM() {
      
      model.setRAM(3);
      assertEquals(model.getRAM(),3);

      
   }

   @Test
   public void testSetRAM() {
      model.setRAM(3);
      assertEquals(model.getRAM(),3);

   }

   @Test
   public void testGetFrontCamera() {
      
      model.setFrontCamera(50);
      assertEquals(model.getFrontCamera(),50);

   }

   @Test
   public void testSetFrontCamera() {
      model.setFrontCamera(50);
      assertEquals(model.getFrontCamera(),50);
   }

   @Test
   public void testGetRearCamera() {
      
      model.setFrontCamera(1100);
      assertEquals(model.getFrontCamera(),1100);
      
   }

   @Test
   public void testSetRearCamera() {
      model.setFrontCamera(1100);
      assertEquals(model.getFrontCamera(),1100);
   }

   @Test
   public void testGetWeight() {
      model.setWeight(123);
      assertEquals(model.getWeight(),123);
   }

   @Test
   public void testSetWeight() {
      model.setWeight(123);
      assertEquals(model.getWeight(),123);
   }

   @Test
   public void testGetPhoneSize() {
      
      model.setPhoneSize("15.3");
      assertEquals(model.getPhoneSize(),"15.3");
   }

   @Test
   public void testSetPhoneSize() {
      model.setPhoneSize("15.3");
      assertEquals(model.getPhoneSize(),"15.3");
   }

   @Test
   public void testGetBetteryCapacity() {
      
      model.setBetteryCapacity(3500);
      assertEquals(model.getBetteryCapacity(),3500);
      
      
   }

   @Test
   public void testSetBetteryCapacity() {
      model.setBetteryCapacity(3500);
      assertEquals(model.getBetteryCapacity(),3500);
      
   }

   @Test
   public void testGetSpeed() {
      model.setSpeed(1.23);
      assertEquals(model.getSpeed(),1.23,0);
   }

   @Test
   public void testSetSpeed() {
      model.setSpeed(1.23);
      assertEquals(model.getSpeed(),1.23,0);
   }

   @Test
   public void testGetResolution() {

      model.setResolution("1920*330");
      assertEquals(model.getResolution(),"1920*330");
   
   }

   @Test
   public void testSetResolution() {
      model.setResolution("1920*330");
      assertEquals(model.getResolution(),"1920*330");
   }

   @Test
   public void testGetReleaseYear() {

      model.setReleaseYear(2019);
      assertEquals(model.getReleaseYear(),2019);

   
   
   }

   @Test
   public void testSetReleaseYear() {
      model.setReleaseYear(2019);
      assertEquals(model.getReleaseYear(),2019);
   }

   @Test
   public void testGetColor() {
      
      model.setColor("Red");
      assertEquals(model.getColor(),"Red");

      
      
      
   }

   @Test
   public void testSetColor() {
      model.setColor("Red");
      assertEquals(model.getColor(),"Red");
   }

   @Test
   public void testGetLink() {
      
      model.setColor("www.nbaver.com");
      assertEquals(model.getColor(),"www.nbaver.com");

   }

   @Test
   public void testSetLink() {
      model.setColor("www.nbaver.com");
      assertEquals(model.getColor(),"www.nbaver.com");

   }

   @Test
   public void testGetRecCount() {

      model.setRecCount(50);
      assertEquals(model.getRecCount(),50);
   
   
   }

   @Test
   public void testSetRecCount() {
      model.setRecCount(50);
      assertEquals(model.getRecCount(),50);
   
   
   }

   @Test
   public void testGetVideolink() {
      
      model.setVideolink("asdf.naver.com");
      assertEquals(model.getVideolink(),"asdf.naver.com");
   
      
   }

   @Test
   public void testSetVideolink() {
      model.setVideolink("asdf.naver.com");
      assertEquals(model.getVideolink(),"asdf.naver.com");
   }

}