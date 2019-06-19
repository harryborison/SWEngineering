package javaCode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlanControlDB {
	
	   ResultSet result = null;
	   String query = null;
	   Connection connection= null;
	
	public void deletebyPlanName(String name)
	   {
	      
	      DBCon con = new DBCon();
	      connection  = con.getmyConnection();
	      
	      String str = "DELETE from testdb.planInfo where planName = '"+name+"'";
	      
	         try {
	            Statement statement = connection.createStatement();
	            int res = statement.executeUpdate(str);
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }

	      
	   }
	
	public void insertPlan(Plan plan)
	   {
	      System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	      query = "INSERT INTO testdb.planInfo VALUES ('"+plan.getOperator()+"', '"+plan.getPlanName()+"', '"+plan.getMobile()+"', '"+plan.getPlanPrice()+"',"
	            + "'"+plan.getAmtOfData()+"', '"+plan.getVideoCall()+"', '"+plan.getCall()+"' , '"+plan.getMessage()+"',"
	                  + " '"+plan.getOption()+"' , '"+plan.getData2()+"', '"+plan.getLink()+"')";
	      
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
