package javacode;

import java.util.*;
import java.io.*;
import java.sql.*;

public class DBTest {

	ResultSet result = null;
	String query = null;
	Connection connection= null;
	public DBTest(){	
	}

	public void connectDB(){
		String name = getName();
		String pw = getPwd();

		try {
			// 드라이버에 로드
			Class.forName("com.mysql.jdbc.Driver"); 

			System.out.println("after forName");

			// 연결 
			String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";

			connection = DriverManager.getConnection(url, name, pw);

			System.out.println("DB 서버에 연결되었습니다.");


		} 
		catch(ClassNotFoundException e){
			System.out.println("Driver loading failed!");
		}
		catch(SQLException e){
			System.out.println("error: " + e);
		}
	}

	// 데이터베이스, 테이블 없으면 생성 후 데이터 로드 
	public void loadData(){
		try{
			
			Statement statement = connection.createStatement();


			// phoneInfo 테이블 생성
			query = "CREATE TABLE IF NOT EXISTS testdb.phoneInfo(phoneName varchar(45) NOT NULL,company varchar(45) NOT NULL,phonePrice int(11) NOT NULL,screenSize decimal(5,3) NOT NULL,os varchar(45) NOT NULL,capacity int(11) NOT NULL,RAM int(11) NOT NULL,frontCamera int(11) NOT NULL,rearCamera int(11) NOT NULL,weight int(11) NOT NULL,phoneSize varchar(45) NOT NULL,betteryCapacity int(11) NOT NULL,speed float NOT NULL,resolution varchar(45) NOT NULL,releaseYear int(11) NOT NULL,color varchar(70) NOT NULL,link varchar(150) NOT NULL,recCount int(11) NOT NULL DEFAULT 0,link2 varchar(150) NOT NULL,PRIMARY KEY(phoneName))";
			 statement.executeUpdate(query);
			
			// planInfo 테이블 생성
			query = "CREATE TABLE IF NOT EXISTS testdb.planInfo ( operator varchar(20) NOT NULL,planName varchar(45) NOT NULL,mobile varchar(10) NOT NULL,planPrice int(11) NOT NULL,data varchar(50) NOT NULL,videoCall varchar(45) NOT NULL,phoneCall varchar(45) NOT NULL,message varchar(45) NOT NULL,phoneOption varchar(70) NOT NULL, data2 int(11) NOT NULL, link varchar(150) NOT NULL, PRIMARY KEY(planName))";
			statement.executeUpdate(query);
			
			 //데이터 로드
			 query = "LOAD DATA INFILE 'C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\planInfo.csv' INTO TABLE testdb.planInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
			  statement.executeUpdate(query);

			query = "LOAD DATA INFILE 'C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\phoneInfo.csv' INTO TABLE testdb.phoneInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
			statement.executeUpdate(query);
		} 
		catch(SQLException e){
			System.out.println("error: " + e);
		}
	}


	// 휴대폰 정보 받아오기  
	public  ArrayList<Model> getPhoneDB() {
        ArrayList<Model> modellist = new ArrayList<Model>();
        modellist.clear();
        
       try{
          // 쿼리를 실행하기 위한 Statement 객체 생성 
          Statement statement = connection.createStatement();
          // 쿼리문 작성 
          query = "SELECT * from testdb.phoneInfo ";
          // 쿼리문 실행 
          result = statement.executeQuery(query);
            int i=0;
          while(result.next()) {
             Model model = new Model();

             model.setPhoneName(result.getString(1));
             model.setCompany(result.getString(2));
             model.setPhonePrice(Integer.parseInt(result.getString(3)));
             model.setScreenSize(Double.parseDouble(result.getString(4)));
             model.setOs(result.getString(5));
             model.setCapacity(Integer.parseInt(result.getString(6)));
             model.setRAM(Integer.parseInt(result.getString(7)));
             model.setFrontCamera(Integer.parseInt(result.getString(8)));
             model.setRearCamera(Integer.parseInt(result.getString(9)));
             model.setWeight(Integer.parseInt(result.getString(10)));
             model.setPhoneSize(result.getString(11));
             model.setBetteryCapacity(Integer.parseInt(result.getString(12)));
             model.setSpeed(Double.parseDouble(result.getString(13)));
             model.setResolution(result.getString(14));
             model.setReleaseYear(Integer.parseInt(result.getString(15)));
             model.setColor(result.getString(16));
             model.setLink(result.getString(17));
             model.setRecCount(Integer.parseInt(result.getString(18)));
             model.setVideolink(result.getString(19));
             modellist.add(i,model);
          
             i++;
          
          }
       } catch(SQLException e){
             System.out.println("error: " + e);
         }

       
       return modellist;
    
    }    

	// 요금제 정보 받아오기 
	public ArrayList<Plan> getPlanDB() {
        
        ArrayList<Plan> planlist = new ArrayList<Plan>();

       try{
          // 쿼리를 실행하기 위한 Statement 객체 생성 
          Statement statement = connection.createStatement();
          // 쿼리문 작성 
          query = "SELECT * from testdb.planInfo ";
          // 쿼리문 실행 
          result = statement.executeQuery(query);
          // 검색 결과 출력 
          
          
          while(result.next()) {
             Plan plan = new Plan();
             plan.setOperator((result.getString(1)));
             plan.setPlanName(result.getString(2));
             plan.setMobile(result.getString(3)); 
             plan.setPlanPrice(Integer.parseInt(result.getString(4)));
             plan.setAmtOfData(result.getString(5));
             plan.setVideoCall(result.getString(6));
             plan.setCall(result.getString(7));
             plan.setMessage(result.getString(8));
             plan.setOption(result.getString(9));
             plan.setData2(Integer.parseInt(result.getString(10)));
             plan.setLink(result.getString(11));
             planlist.add(plan);      
             
          }
          
       } catch(SQLException e){
             System.out.println("error: " + e);
         }
       return planlist;
    
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
			ppstatement.executeUpdate();		
			
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



	public static String getName()
	{
		return "root";
	}
	public static String getPwd()
	{
		return "1234";
	}

	public void CreateCustomerDB() {
		Statement statement = null;


		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.printf("called");
		int count = 0;
		query = "CREATE TABLE IF NOT EXISTS testdb.customerInfo ("  
				+" ID varchar(300) NOT NULL, "
				+" password varchar(300) NOT NULL, "
				+" name varchar(20) NOT NULL, "
				+" age  varchar(20) NOT NULL, "
				+" phone_number varchar(20) NOT NULL, "
				+" email_address varchar(45) NOT NULL, "
				+" sex varchar(10) NOT NULL, "
				+" PRIMARY KEY(ID))";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}



	// 고객 정보 입력하기
	public void setCustomerDB(String Cusinfo[]) {

		SecurityUtil sec = new SecurityUtil();
		String id = sec.encryptSHA256(Cusinfo[0]);
		String pwd = sec.encryptSHA256(Cusinfo[1]);
		System.out.printf("%s %s",id,pwd);

		try{
			// 쿼리를 실행하기 위한 Statement 객체 생성 
			Statement statement = connection.createStatement();
			// 쿼리문 작성
			query = "INSERT INTO testdb.customerInfo(ID, password, name, age, phone_number, email_address, sex)VALUES"
					+ "('"+id+"','"+pwd+"','"+Cusinfo[2]+"','"+Cusinfo[3]+"','"+Cusinfo[4]+"','"+Cusinfo[5]+"','"+Cusinfo[6]+"')";
			// 쿼리문 실행 
			statement.executeUpdate(query);   
		}catch(SQLException e){
			System.out.println("error: " + e);
		}            
	}

	public void getCustomerDB() {
		try{
			// 쿼리를 실행하기 위한 Statement 객체 생성 
			Statement statement = connection.createStatement();
			// 쿼리문 작성
			query = "SELECT * from customerInfo ";
			// 쿼리문 실행 
			result = statement.executeQuery(query);
			while(result.next())
				System.out.printf("%s %s %s %s",result.getString(1),result.getString(4),result.getString(3),result.getString(2));
		}catch(SQLException e){
			System.out.println("error: " + e);
		}            
	}
	public void deleteCustomerDB() {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} 
		catch (SQLException e) {	
			e.printStackTrace();
		}
		query = "DROP TABLE testdb.customerInfo";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
}