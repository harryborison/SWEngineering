package javacode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;





public class CustomerControlDB {

	
   ResultSet result = null;
   String query = null;
   Connection connection= null;
   
   SecurityUtil sec = new SecurityUtil();
   
   
   
   public int loginCheck(String name , String pwd)
   {
Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging");
	  
	   DBCon con = new DBCon();
      connection = con.getmyConnection();
      String hashname = sec.encryptSHA256(name);
      String hashpwd  = sec.encryptSHA256(pwd);
      query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
      System.out.println(query);
	 
    

      try {
    	  
         try {
			Statement statement = connection.createStatement();
			
			 result = statement.executeQuery(query);
			 statement.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         if(result == null)
         {
        	 return 0;
         }
         while(result.next())
        	 {
        		 if(result.getString(2).equals(hashpwd))
        		 {
        			 return 1;
        		 }
        	 }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
    	  logger.log(Level.SEVERE, "error, {0}", e.toString());
      }
      
  
      
      return 0;
   }
   
   public int signinCheck(String name)
   {
	   Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging");


	   DBCon con = new DBCon();
         connection = con.getmyConnection();
         String hashname = sec.encryptSHA256(name);
         query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
         result = null;
         try {
            try {
				Statement statement = connection.createStatement();
				result = statement.executeQuery(query);
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(result == null)
            {
            	return 0;
            }
            while(result.next()) // 데이터존재
               {
                 return 1;
             
               }
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e.toString());
         }
         
         
     
         
         return 0;
   }
   
   public String getNameFromID(String id)
   {
	   Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging");
      DBCon con = new DBCon();
       connection = con.getmyConnection();
         String hashname = sec.encryptSHA256(id);
         String resultname = null;
         query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
         result = null;
         try {
            try {
				Statement statement = connection.createStatement();
				result = statement.executeQuery(query);
				statement.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(result == null)
            {
            	return null;
            }
            while(result.next()) // 데이터존재
               {
               resultname = result.getString(3);
               }
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e.toString());
         }
        
         return resultname;
      
   }
}