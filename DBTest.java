import java.util.*;
import java.io.*;
import java.sql.*;

public class DBTest {

	
			private Connection con = null;
			private Statement statement = null;
			public ResultSet result = null;
			public String sql = null;
			
			public DBTest(){
				
				try {
				// 드라이버에 로드
				Class.forName("com.mysql.jdbc.Driver"); 

				System.out.println("after forName");
				
				// 연결 
				String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";

				con = DriverManager.getConnection(url, "root", "1234");

				System.out.println("DB 서버에 연결되었습니다.");
				
				// 쿼리를 실행하기 위한 Statement 객체 생성 
				statement = con.createStatement();
			
				// 엑셀 테이터 LOAD query : "LOAD DATA INFILE '/Applications/data/planInfo.csv' INTO TABLE planInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES;"
				
			} 
			catch(ClassNotFoundException e){
	            System.out.println("Driver loading fail!");
	        }
	        catch(SQLException e){
	            System.out.println("error: " + e);
	        }
				
		}
				

			// 휴대폰 정보 받아오기  
			public void getPhoneDB(String data) {
				// 쿼리문 작성 
				sql = "SELECT * from phoneInfo WHERE phoneName = '" + data + "'";
				// 쿼리문 실행 
				result = statement.executeQuery(sql);	
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
				closeDB();
			
			} 	
			
			// 요금제 정보 받아오기 
			public void getPlanDB(String data) {
				// 쿼리문 작성 
				String sql = "SELECT * from planInfo WHERE operator = '" + data + "'";
				// 쿼리문 실행 
				result = statement.executeQuery(sql);
				// 검색 결과 출력 
				while(result.next()) {
					String operator = result.getString(1);
					String planName = result.getString(2);
					String mobile = result.getString(3);
					int planPrice = Integer.parseInt(result.getString(4));
					String data = result.getString(4);
					String videoCall = result.getString(5);
					String call = result.getString(6);
					String message = result.getString(7);
					String option = result.getString(8);
					
					System.out.println("요금제 이름: " + planName 
							+ "\n통신사: " + operator 
							+ "\n기기: " + mobile
							+ "\n가격(원): " + planPrice + "원" 
							+ "\n데이터: " + data 
							+ "\n영상통화: " + videoCall
							+ "\n전화: " + call
							+ "\n메세지: " + message 
							+ "\n특이사항: " + option + "\n\n");
				}
				closeDB();
			
			}
			
			// 휴대폰 정보 입력하기 
			public void setPhoneDB() {
				// 쿼리문 작성 
				sql = "INSERT INTO phoneInfo(phoneName, company, phonePrice, screenSize, os, capacity, RAM, frontCamera, rearCamera, weight, phoneSize, betteryCapacity, speed, resolution, releaseYear, color, link) 
							VALUES ('iphone', 'apple', '20000', '4.8', 'os', '512', '4', '700', '1200', '208', '112233', '3000', '2.5', 'resolution', '2018', 'gold', 'www.naver.com')";
				// 쿼리문 실행 
				result = statement.executeQuery(sql);	
				
				closeDB();		
			}
			
			// 요금제 정보 입력하기 
			public void setPlanDB() {
				// 쿼리문 작성
				sql = "INSERT INTO plansql(operator, planName, mobile, planPrice, data, videoCall, call, message, option) 
							VALUES ('KT', '화이팅요금제', 'LTE', '45000', '무제한', '무제한', '무제한', '무제한', '대학생 대상' )";
				// 쿼리문 실행 
				result = statement.executeQuery(sql);
				
				closeDB();
			}
			
			// 고객 정보 입력하기
			public void setCustomerDB(String[] input) {
				// 쿼리문 작성
				sql = "INSERT INTO customerInfo(ID, password, name, age, phone_number, email_address, sex)
						VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', '" + 
						input[4] + "', '" + input[5] + "', '" + input[6] + "')";
				// 쿼리문 실행 
				result = statement.executeQuery(sql);	
				
				closeDB();					
			}
			
						
				
			// DB 연결 종료하기 	
			public void closeDB() {
			
			try{
	                if( con != null && !con.isClosed()){
	                    con.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	            System.out.println("DB 연결이 종료되었습니다.");
			}

}
