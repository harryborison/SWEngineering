package DBTest;

import java.util.*;
import java.io.*;
import java.sql.*;

public class DBTest {

			Connection connection = null;
			ResultSet result = null;
			String query = null;
			
			public DBTest(){	
			}
		
			public void connectDB(){
				try {
					// 드라이버에 로드
					Class.forName("com.mysql.jdbc.Driver"); 
	
					System.out.println("after forName");
					
					// 연결 
					String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";
	
					connection = DriverManager.getConnection(url, "root", "1234");
	
					System.out.println("DB 서버에 연결되었습니다.");
				
			
				} 
				catch(ClassNotFoundException e){
		            System.out.println("Driver loading fail!");
		        }
		        catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// 데이터베이스, 테이블 없으면 생성 후 데이터 로드 
			public void loadData(){
				try{
					//					// 쿼리를 실행하기 위한 Statement 객체 생성 
//					Statement statement = connection.createStatement();
//				
//					// recDB 데이터베이스 생성
//					query = "CREATE DATABASE IF NOT EXISTS recDB";
//					
//					int count = statement.executeUpdate(query);
//		            if( count == 0 ){
//		                System.out.println("recDB 데이터베이스 생성 실패");
//		            }
//		            else{
//		                System.out.println("recDB 데이터베이스 생성 성공");
//		            }
//		            // recDB 데이터베이스 선택
//		            query = "use recDB";
//					
//					count = statement.executeUpdate(query);
//		            if( count == 0 ){
//		                System.out.println("recDB 데이터베이스 선택 실패");
//		            }
//		            else{
//		                System.out.println("recDB 데이터베이스 선택 성공");
//		            }
//		            count = 0;

					// 쿼리를 실행하기 위한 Statement 객체 생성 
					Statement statement = connection.createStatement();
					
		            int count = 0;
		            
						
					// phoneInfo 테이블 생성
					query = "CREATE TABLE IF NOT EXISTS recDB.phoneInfo(phoneName varchar(45) NOT NULL,company varchar(45) NOT NULL,phonePrice int(11) NOT NULL,screenSize decimal(5,3) NOT NULL,os varchar(45) NOT NULL,capacity int(11) NOT NULL,RAM int(11) NOT NULL,frontCamera int(11) NOT NULL,rearCamera int(11) NOT NULL,weight int(11) NOT NULL,phoneSize varchar(45) NOT NULL,betteryCapacity int(11) NOT NULL,speed float NOT NULL,resolution varchar(45) NOT NULL,releaseYear int(11) NOT NULL,color varchar(70) NOT NULL,link varchar(150) NOT NULL,recCount int(11) NOT NULL DEFAULT 0,link2 varchar(150) NOT NULL,PRIMARY KEY(phoneName))";
							 
					count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("phoneInfo 테이블 생성 실패");
		            }
		            else{
		                System.out.println("phoneInfo 테이블 생성 성공");
		            }
		            count = 0;
		            
		            // planInfo 테이블 생성
					query = "CREATE TABLE IF NOT EXISTS recDB.planInfo ( operator varchar(20) NOT NULL,planName varchar(45) NOT NULL,mobile varchar(10) NOT NULL,planPrice int(11) NOT NULL,data varchar(50) NOT NULL,videoCall varchar(45) NOT NULL,phoneCall varchar(45) NOT NULL,message varchar(45) NOT NULL,phoneOption varchar(70) NOT NULL, data2 int(11) NOT NULL, PRIMARY KEY(planName))";
					count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("planInfo 테이블 생성 실패");
		            }
		            else{
		                System.out.println("planInfo 테이블 생성 성공");
		            }		
		            
		             // customerInfo 테이블 생성
					query = "CREATE TABLE IF NOT EXISTS recDB.customerInfo ("  
							+" ID varchar(20) NOT NULL, "
							+" password varchar(45) NOT NULL, "
							+" name varchar(20) NOT NULL, "
							+" age  varchar(20) NOT NULL, "
							+" phone_number varchar(20) NOT NULL, "
							+" email_address varchar(45) NOT NULL, "
							+" sex varchar(10) NOT NULL, "
							+" PRIMARY KEY(ID))";
					count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("customerInfo 테이블 생성 실패");
		            }
		            else{
		                System.out.println("customerInfo 테이블 생성 성공");
		            } 
		            
		            // 데이터 로드
		            query = "LOAD DATA INFILE '/Users/parkyunhwa/eclipse-workspace/DBTest/planInfo.csv' INTO TABLE planInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
		            count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("planInfo.csv 데이터 로드 실패");
		            }
		            else{
		                System.out.println("planInfo.csv 데이터 로드 성공");
		            } 
		            
		            query = "LOAD DATA INFILE '/Users/parkyunhwa/eclipse-workspace/DBTest/phoneInfo.csv' INTO TABLE phoneInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
		            count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("phoneInfo.csv 데이터 로드 실패");
		            }
		            else{
		                System.out.println("phoneInfo.csv 데이터 로드 성공");
		            }			
				} 
		        catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
				

			// 휴대폰 정보 받아오기  
			public void getPhoneDB(String info) {
				try{
					// 쿼리를 실행하기 위한 Statement 객체 생성 
					Statement statement = connection.createStatement();
					// 쿼리문 작성 
					query = "SELECT * from phoneInfo WHERE phoneName = '" + info + "'";
					// 쿼리문 실행 
					result = statement.executeQuery(query);
					// 검색 결과 출력 
					while(result.next()) {
						String phoneName = result.getString(1);
						String company = result.getString(2);
						int phonePrice = Integer.parseInt(result.getString(3));
						double screenSize = Double.parseDouble(result.getString(4));
						String os = result.getString(5);
						int capacity = Integer.parseInt(result.getString(6));
						int RAM = Integer.parseInt(result.getString(7));
						int frontCamera = Integer.parseInt(result.getString(8));
						int rearCamera = Integer.parseInt(result.getString(9));
						int weight = Integer.parseInt(result.getString(10));
						String phoneSize = result.getString(11);
						int betteryCapacity = Integer.parseInt(result.getString(12));
						double speed = Double.parseDouble(result.getString(13));
						String resolution = result.getString(14);
						int releaseYear = Integer.parseInt(result.getString(15));
						String color = result.getString(16);
						String link = result.getString(17);
						int recCount = Integer.parseInt(result.getString(18));
						
						System.out.println("모델명: " + phoneName 
								+ "\n제조사: " + company 
								+ "\n가격: " + phonePrice + "원"
								+ "\n화면크기: " + screenSize + "inch" 
								+ "\n운영체제: " + os 
								+ "\n용량: " + capacity + "GB" 
								+ "\n렘: " + RAM + "GB"
								+ "\n전면카메라: " + frontCamera + "만 화소"
								+ "\n후면카메라: " + rearCamera + "만 화소" 
								+ "\n무게: " + weight + "g" 
								+ "\n크기: " + phoneSize + "mm" 
								+ "\n배터리 용량: " + betteryCapacity + "mAh" 
								+ "\n속도: " + speed + "Ghz" 
								+ "\n화면해상도: " + resolution 
								+ "\n출시년도: " + releaseYear + "년" 
								+ "\n색상: " + color 
								+ "\n링크: " + link 
								+ "\n추천수: " + recCount + "회\n\n");
					}
				} catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			
			} 	
			
			// 요금제 정보 받아오기 
			public void getPlanDB(String info) {
				try{
					// 쿼리를 실행하기 위한 Statement 객체 생성 
					Statement statement = connection.createStatement();
					// 쿼리문 작성 
					query = "SELECT * from planInfo WHERE operator = '" + info + "'";
					// 쿼리문 실행 
					result = statement.executeQuery(query);
					// 검색 결과 출력 
					while(result.next()) {
						String operator = result.getString(1);
						String planName = result.getString(2);
						String mobile = result.getString(3);
						int planPrice = Integer.parseInt(result.getString(4));
						String amtOfData = result.getString(4);
						String videoCall = result.getString(5);
						String call = result.getString(6);
						String message = result.getString(7);
						String option = result.getString(8);
						
						System.out.println("요금제 이름: " + planName 
								+ "\n통신사: " + operator 
								+ "\n기기: " + mobile
								+ "\n가격(원): " + planPrice + "원" 
								+ "\n데이터: " + amtOfData 
								+ "\n영상통화: " + videoCall
								+ "\n전화: " + call
								+ "\n메세지: " + message 
								+ "\n특이사항: " + option + "\n\n");
					}
				} catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			
			}
			
			// 휴대폰 정보 입력하기 
			public void setPhoneDB(String[] input) {
				try{
					
					// 쿼리문 작성 
					query = "INSERT INTO phoneInfo(phoneName, company, phonePrice, screenSize, os, capacity, RAM, frontCamera, rearCamera, weight, phoneSize, betteryCapacity, speed, resolution, releaseYear, color, link,link2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
					PreparedStatement ppstatement = connection.prepareStatement(query);
					
					ppstatement.setString(1, input[0]);
					ppstatement.setString(2, input[1]);
					ppstatement.setString(3, input[2]);
					ppstatement.setString(4, input[3]);
					ppstatement.setString(5, input[4]);
					ppstatement.setString(6, input[5]);
					ppstatement.setString(7, input[6]);
					ppstatement.setString(8, input[7]);
					ppstatement.setString(9, input[8]);
					ppstatement.setString(10, input[9]);
					ppstatement.setString(11, input[10]);
					ppstatement.setString(12, input[11]);
					ppstatement.setString(13, input[12]);
					ppstatement.setString(14, input[13]);
					ppstatement.setString(15, input[14]);
					ppstatement.setString(16, input[15]);
					ppstatement.setString(17, input[16]);
					ppstatement.setString(18, input[17]); // 데이터 형식 수정 필요 ***
					
					
					// 쿼리문 실행 
					int count = ppstatement.executeUpdate();		
					if( count == 0 ){
	                System.out.println("데이터 입력 실패");
		            }
		            else{
		                System.out.println("데이터 입력 성공");
		            }
		        }
		        catch( SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// 요금제 정보 입력하기 
			public void setPlanDB(String[] input) {
				try{
					// 쿼리를 실행하기 위한 Statement 객체 생성 
					Statement statement = connection.createStatement();
					// 쿼리문 작성
					query = "INSERT INTO plansql(operator, planName, mobile, planPrice, data, videoCall, call, message, option)VALUES ('KT', '화이팅요금제', 'LTE', '45000', '무제한', '무제한', '무제한', '무제한', '대학생 대상' )";
					// 쿼리문 실행 
					result = statement.executeQuery(query);
				}catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// 고객 정보 입력하기
			public void setCustomerDB(String[] input) {
				try{
					// 쿼리를 실행하기 위한 Statement 객체 생성 
					Statement statement = connection.createStatement();
					// 쿼리문 작성
					query = "INSERT INTO customerInfo(ID, password, name, age, phone_number, email_address, sex)VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', '" + input[4] + "', '" + input[5] + "', '" + input[6] + "')";
					// 쿼리문 실행 
					result = statement.executeQuery(query);	
				}catch(SQLException e){
		            System.out.println("error: " + e);
		        }				
			}
			
						
				
			// DB 연결 종료하기 	
			public void closeDB() {
			
			try{
	                if( connection != null && !connection.isClosed()){
	                    connection.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	            System.out.println("DB 연결이 종료되었습니다.");
			}

}