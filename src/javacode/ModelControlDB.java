
package javacode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Logger;
import java.util.logging.Level;
public class ModelControlDB {
   

   ResultSet result = null;
   String query = null;
   Connection connection= null;
   Statement statement = null;
   

   public void makeDB()
   {
      
   }
   public void deleteDB()
   {   
	   Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging"); 
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      query = "DROP TABLE testdb.modelInfo";

      try {
         statement = connection.createStatement();
         statement.executeQuery(query);
      } catch (SQLException e) 
      {
         // TODO Auto-generated catch block
    	  logger.log(Level.SEVERE, "error, {0}", e);
      }   
     
      try {
		statement.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		logger.log(Level.SEVERE, "error, {0}", e);
	}
      
   }
   public void countPlus(String[] phoneName)
   {
Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging"); 
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str = "UPDATE testdb.phoneInfo set recCount = recCount +1 where phoneName = '"+phoneName[i]+"'";
         try {
            statement = connection.createStatement();
            statement.executeUpdate(str);
         } catch (Exception e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
        
	        try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.SEVERE, "error, {0}", e);
			}
      
      }
   }
   
   public void deletebyPhoneName(String name)
   {
Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging"); 
      DBCon con = new DBCon();
      connection  = con.getmyConnection();
      
      String str = "DELETE  from testdb.phoneInfo where phoneName = '"+name+"'";
      
         try {
            statement = connection.createStatement();
           statement.executeUpdate(str);
         } catch (Exception e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
        
	        try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.log(Level.SEVERE, "error, {0}", e);
			}
      
   }
   
   public String[] seeRank()
   {
Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging"); 
      int j=0;
      DBCon con = new DBCon();
      String[] finaleresult = new String[3];
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str =  "SELECT phoneName from testdb.phoneInfo order by recCount desc limit 3";
         try {
            statement = connection.createStatement();
            result = statement.executeQuery(str);
         } catch (SQLException e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
         try {
            while(result.next())
            {
               if(j>=3)
               {
                  break;
               }
               finaleresult[j++] = result.getString(1);
               
               
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
         try {
			result.close();
			    statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "error, {0}", e);
		}
      }
      return finaleresult;
      
   }
   
   public int[] seeRankcnt()
   {
 Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging");

      int j=0;
      DBCon con = new DBCon();
      int[] finaleresult = new int[3];
      connection  = con.getmyConnection();
      for(int i=0; i<3 ;i++)
      {
         String str =  "SELECT recCount from testdb.phoneInfo order by recCount desc limit 3";
         try {
            statement = connection.createStatement();
            result = statement.executeQuery(str);
         } catch (Exception e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
         try {
            while(result.next())
            {
               if(j>=3)
               {
                  break;
               }
               finaleresult[j++] = result.getInt(1);
              
            }
         } catch (Exception e) {
            // TODO Auto-generated catch block
        	 logger.log(Level.SEVERE, "error, {0}", e);
         }
         
         try {
			result.close();
	        statement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.log(Level.SEVERE, "error, {0}", e);
		}
      }
      return finaleresult;
   }
   
   public void insertModel(Model model)
   {
 Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
	   
       logger.log(Level.INFO, "Start Logging");

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
      } catch (Exception e) 
      {
         // TODO Auto-generated catch block
    	  logger.log(Level.SEVERE, "error, {0}", e);
      }   
      
      
      
   }
}