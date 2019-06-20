package javacode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Logger;
import java.util.logging.Level;
public class PlanControlDB {
	
	   ResultSet result = null;
	   String query = null;
	   Connection connection= null;
	   Statement statement;
	public void deletebyPlanName(String name)
	   {
		 Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
		   
	       logger.log(Level.INFO, "Start Logging");

	      DBCon con = new DBCon();
	      connection  = con.getmyConnection();
	      
	      String str = "DELETE from testdb.planInfo where planName = '"+name+"'";
	      
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
	
	public void insertPlan(Plan plan)
	   {
		 Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
		   
	       logger.log(Level.INFO, "Start Logging");

	      
	      query = "INSERT INTO testdb.planInfo VALUES ('"+plan.getOperator()+"', '"+plan.getPlanName()+"', '"+plan.getMobile()+"', '"+plan.getPlanPrice()+"',"
	            + "'"+plan.getAmtOfData()+"', '"+plan.getVideoCall()+"', '"+plan.getCall()+"' , '"+plan.getMessage()+"',"
	                  + " '"+plan.getOption()+"' , '"+plan.getData2()+"', '"+plan.getLink()+"')";
	      
	      DBCon con = new DBCon();
	      connection  = con.getmyConnection();
	      
	      try {
	         statement = connection.createStatement();
	         statement.executeUpdate(query);
	         
	      } catch (Exception e) 
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
}
