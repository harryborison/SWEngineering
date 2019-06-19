package javacode;

import java.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecurityUtil {
	public String encryptSHA256(String str){
		Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
		   
	       logger.log(Level.INFO, "Start Logging");
		
		String sha = "";
		try{
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			sh.update(str.getBytes());
			byte[] byteData = sh.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			sha = sb.toString();
		}catch(NoSuchAlgorithmException e){
			logger.log(Level.SEVERE, "error, {0}", e.toString());
			sha = null;
		}
		return sha;
	}
}
