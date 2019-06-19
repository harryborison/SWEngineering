package javacode;

import java.util.*;
import java.io.*;
import java.sql.*;


public class DBCon {
	public Connection getmyConnection()
	{
		Connection conn= null;
		try {
			// ����̹��� �ε�
			Class.forName("com.mysql.jdbc.Driver"); 

			System.out.println("after forName");
			String name = getName();
			String pw = getPwd();
			// ���� 
			String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";

			conn = DriverManager.getConnection(url,name, pw);

			System.out.println("DB ������ ����Ǿ����ϴ�.");


		} 
		catch(ClassNotFoundException e){
			System.out.println("Driver loading failed!");
		}
		catch(SQLException e){
			System.out.println("error: " + e);
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
