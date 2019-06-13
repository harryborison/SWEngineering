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
   
   public int signinCheck(String name)
   {
         connection = con.getmyConnection();
         String hashname = sec.encryptSHA256(name);
         String tmp;
         query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
         result = null;
         try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) // 데이터존재
               {
                 return 1;
             
               }
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
     
         
         return 0;
   }
   
   public String getNameFromID(String id)
   {
      
       connection = con.getmyConnection();
         String hashname = sec.encryptSHA256(id);
         String tmp;
         String resultname = null;
         query = "SELECT * from testdb.customerInfo where ID = '"+ hashname +"' ";
         result = null;
         try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
            while(result.next()) // 데이터존재
               {
               resultname = result.getString(3);
               }
            
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         return resultname;
      
   }
}