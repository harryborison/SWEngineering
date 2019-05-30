package javaCode;

import java.util.*;
import java.io.*;
import java.sql.*;


public class DBCon {
	 public static Connection getmyConnection()
	 {
		Connection conn= null;
		try {
			// 드라이버에 로드
			Class.forName("com.mysql.jdbc.Driver"); 

			System.out.println("after forName");
			
			// 연결 
			String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";
			
			conn = DriverManager.getConnection(url, "root", "1234");

			System.out.println("DB 서버에 연결되었습니다.");
		
	
		} 
		catch(ClassNotFoundException e){
            System.out.println("Driver loading failed!");
        }
        catch(SQLException e){
            System.out.println("error: " + e);
        }
		 return conn;

	 }
}
