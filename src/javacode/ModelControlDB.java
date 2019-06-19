package javacode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModelControlDB {
   

   ResultSet result = null;
   String query = null;
   Connection connection= null;
   

   public void makeDB()
   {
      
   }
   public void deleteDB()
   {   
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      query = "DROP TABLE testdb.modelInfo";

      try {
         Statement statement = connection.createStatement();
         statement.executeQuery(query);
      } catch (SQLException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }   
      
   }
   public void countPlus(String[] phoneName)
   {
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str = "UPDATE testdb.phoneInfo set recCount = recCount +1 where phoneName = '"+phoneName[i]+"'";
         try {
            Statement statement = connection.createStatement();
            int res = statement.executeUpdate(str);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      
      }
   }
   
   public void deletebyPhoneName(String name)
   {
      
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      
      String str = "DELETE  from testdb.phoneInfo where phoneName = '"+name+"'";
      
         try {
            Statement statement = connection.createStatement();
            int res = statement.executeUpdate(str);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      
   }
   
   public String[] seeRank()
   {
      int j=0;
      DBCon con = new DBCon();
      String[] finaleresult = new String[3];
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str =  "SELECT phoneName from testdb.phoneInfo order by recCount desc limit 3";
         try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(str);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         try {
            while(result.next())
            {
               if(j>=3)
               {
                  break;
               }
               finaleresult[j++] = result.getString(1);
               try {
                  System.out.printf("%s\n",result.getString(1));
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      }
      return finaleresult;
      
   }
   
   public int[] seeRankcnt()
   {
      int j=0;
      DBCon con = new DBCon();
      int[] finaleresult = new int[3];
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str =  "SELECT recCount from testdb.phoneInfo order by recCount desc limit 3";
         try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(str);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         try {
            while(result.next())
            {
               if(j>=3)
               {
                  break;
               }
               finaleresult[j++] = result.getInt(1);
               try {
                  System.out.printf("%s\n",result.getString(1));
               } catch (SQLException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
               }
            }
         } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      
      }
      return finaleresult;
   }
   
   public void insertModel(Model model)
   {
      
      query = "INSERT INTO testdb.phoneInfo VALUES ('"+model.getPhoneName()+"',"
      		+ "'"+model.getCompany()+"', '"+model.getPhonePrice()+"', '"+model.getScreenSize()+"', '"+model.getOs()+"',"
            + "'"+model.getCapacity()+"', '"+model.getRAM()+"', '"+model.getFrontCamera()+"' , '"+model.getRearCamera()+"',"
                  + " '"+model.getWeight()+"' , '"+model.getPhoneSize()+"', '"+model.getBetteryCapacity()+"'"
                        + " '"+model.getSpeed()+"' , '"+model.getResolution()+"', '"+model.getReleaseYear()+"'"
                              + " '"+model.getColor()+"', '"+model.getLink()+"', '"+model.getRecCount()+"','"+model.getVideolink()+"' )";
      System.out.printf("%s",query);
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      
      try {
         Statement statement = connection.createStatement();
         statement.executeUpdate(query);
      } catch (SQLException e) 
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }   
      
      
      
   }
}