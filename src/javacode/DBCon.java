package javacode;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.sql.*;


public class DBCon {
	public Connection getmyConnection()
	{
		Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
		   
	       logger.log(Level.INFO, "Start Logging");

		
		Connection conn= null;
		try {
			// ����̹��� �ε�
			Class.forName("com.mysql.jdbc.Driver"); 

			//System.out.println("after forName");
			String name = getName();
			String pw = getPwd();
			// ���� 
			String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";

			conn = DriverManager.getConnection(url,name, pw);

			//System.out.println("DB ������ ����Ǿ����ϴ�.");


		} 
		catch(ClassNotFoundException e){
			logger.log(Level.SEVERE, "error, {0}", e.toString());
		}
		catch(SQLException e){
			logger.log(Level.SEVERE, "error, {0}", e.toString());
		}
		return conn;

	}
	public static String getName()
	{
		return "root";
	}
	public static String getPwd()
	{
		return "1234";
	}
}
