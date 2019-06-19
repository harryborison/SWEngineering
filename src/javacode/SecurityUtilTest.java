package javacode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityUtilTest {

	@Test
	public void testencryptSHA256() {
		SecurityUtil secutil = new SecurityUtil();
		String s1 = secutil.encryptSHA256("abc");
		String s2 = secutil.encryptSHA256("abc");
		assertEquals(s1,s2);
		
		String s3 = secutil.encryptSHA256("def");
		if(s1.equals(s3))
		{
			fail("why is this same ??");
		}
		
		String s4 = new String();
		s4 = null;
		s3 = secutil.encryptSHA256(s4);
		if(s3 !=null)
		{
			fail("why is this same ?? not null!");
		}
		
	}

}
