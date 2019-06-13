package javaCode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerControlDB {


   ResultSet result = null;
   String query = null;
   Connection connection= null;
   DBCon con = new DBCon();
   SecurityUtil sec = new SecurityUtil();
   
   public int checkId(String name)
   {
      
      
      return 1;
   }
   
   public int loginCheck(String name , String pwd)
   {
      connection = con.getmyConnection();
      String hashname = sec.encryptSHA256(name);
      String hashpwd  = sec.encryptSHA256(pwd);
      String tmp;
      query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
      System.out.println(query);
      
      try {
         Statement statement = connection.createStatement();
         result = statement.executeQuery(query);
         while(result.next())
        	 {
        		 if(result.getString(2).equals(hashpwd))
        		 {
        			 return 1;
        		 }
        	 }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
  
      
      return 0;
   }
   
   
}