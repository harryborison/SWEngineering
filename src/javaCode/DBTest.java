package javaCode;

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
				try {
					// ����̹��� �ε�
					Class.forName("com.mysql.jdbc.Driver"); 
	
					System.out.println("after forName");
					
					// ���� 
					String url = "jdbc:mysql://localhost:3306/recDB?serverTimezone=Asia/Seoul";
					
					connection = DriverManager.getConnection(url, "root", "1234");
	
					System.out.println("DB ������ ����Ǿ����ϴ�.");
				
			
				} 
				catch(ClassNotFoundException e){
		            System.out.println("Driver loading failed!");
		        }
		        catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// �����ͺ��̽�, ���̺� ������ ���� �� ������ �ε� 
			public void loadData(){
				try{
					//					// ������ �����ϱ� ���� Statement ��ü ���� 
//					Statement statement = connection.createStatement();
//				
//					// testdb �����ͺ��̽� ����
//					query = "CREATE DATABASE IF NOT EXISTS testdb";
//					
//					int count = statement.executeUpdate(query);
//		            if( count == 0 ){
//		                System.out.println("testdb �����ͺ��̽� ���� ����");
//		            }
//		            else{
//		                System.out.println("testdb �����ͺ��̽� ���� ����");
//		            }
//		            // testdb �����ͺ��̽� ����
//		            query = "use testdb";
//					
//					count = statement.executeUpdate(query);
//		            if( count == 0 ){
//		                System.out.println("testdb �����ͺ��̽� ���� ����");
//		            }
//		            else{
//		                System.out.println("testdb �����ͺ��̽� ���� ����");
//		            }
//		            count = 0;

					// ������ �����ϱ� ���� Statement ��ü ���� 
					Statement statement = connection.createStatement();
					
		            int count = 0;
		           
		            query = "DELETE TABLE testdb.phoneInfo ";
					count = statement.executeUpdate(query);
					if(count ==0)
					{
						System.out.println("del ����");
					}
					// phoneInfo ���̺� ����
					query = "CREATE TABLE IF NOT EXISTS testdb.phoneInfo(phoneName varchar(45) NOT NULL,company varchar(45) NOT NULL,phonePrice int(11) NOT NULL,screenSize decimal(5,3) NOT NULL,os varchar(45) NOT NULL,capacity int(11) NOT NULL,RAM int(11) NOT NULL,frontCamera int(11) NOT NULL,rearCamera int(11) NOT NULL,weight int(11) NOT NULL,phoneSize varchar(45) NOT NULL,betteryCapacity int(11) NOT NULL,speed float NOT NULL,resolution varchar(45) NOT NULL,releaseYear int(11) NOT NULL,color varchar(70) NOT NULL,link varchar(150) NOT NULL,recCount int(11) NOT NULL DEFAULT 0,link2 varchar(150) NOT NULL,PRIMARY KEY(phoneName))";
							 
					count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("phoneInfo ���̺� ���� ����");
		            }
		            else{
		                System.out.println("phoneInfo ���̺� ���� ����");
		            }
		            count = 0;
		            
		            // planInfo ���̺� ����
					query = "CREATE TABLE IF NOT EXISTS testdb.planInfo ( operator varchar(20) NOT NULL,planName varchar(45) NOT NULL,mobile varchar(10) NOT NULL,planPrice int(11) NOT NULL,data varchar(50) NOT NULL,videoCall varchar(45) NOT NULL,phoneCall varchar(45) NOT NULL,message varchar(45) NOT NULL,phoneOption varchar(70) NOT NULL, data2 int(11) NOT NULL, PRIMARY KEY(planName))";
					count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("planInfo ���̺� ���� ����");
		            }
		            else{
		                System.out.println("planInfo ���̺� ���� ����");
		            }		
		            
		             // customerInfo ���̺� ����
					query = "CREATE TABLE IF NOT EXISTS testdb.customerInfo ("  
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
		                System.out.println("customerInfo ���̺� ���� ����");
		            }
		            else{
		                System.out.println("customerInfo ���̺� ���� ����");
		            } 
		            
		            // ������ �ε�
		           // query = "LOAD DATA INFILE 'C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\planInfo.csv' INTO TABLE planInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
		          //  count = statement.executeUpdate(query);
		          //  if( count == 0 ){
		          //      System.out.println("planInfo.csv ������ �ε� ����");
		          //  }
		         //   else{
		        //        System.out.println("planInfo.csv ������ �ε� ����");
		         //   } 
		            
		            query = "LOAD DATA INFILE 'C:\\\\ProgramData\\\\MySQL\\\\MySQL Server 8.0\\\\Uploads\\\\phoneInfo.csv' INTO TABLE phoneInfo FIELDS TERMINATED BY ',' IGNORE 2 LINES";
		            count = statement.executeUpdate(query);
		            if( count == 0 ){
		                System.out.println("phoneInfo.csv ������ �ε� ����");
		            }
		            else{
		                System.out.println("phoneInfo.csv ������ �ε� ����");
		            }			
				} 
		        catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
	

			// �޴��� ���� �޾ƿ���  
			public  ArrayList<Model> getPhoneDB() {
				 ArrayList<Model> modellist = new ArrayList<Model>();
				 modellist.clear();
				 
				try{
					// ������ �����ϱ� ���� Statement ��ü ���� 
					Statement statement = connection.createStatement();
					// ������ �ۼ� 
					query = "SELECT * from phoneInfo ";
					// ������ ���� 
					result = statement.executeQuery(query);
			        int i=0;
					while(result.next()) {
						Model model = new Model();

						model.phoneName = result.getString(1);

						model.company = result.getString(2);
						model.phonePrice = Integer.parseInt(result.getString(3));
						model.screenSize = Double.parseDouble(result.getString(4));
						model.os = result.getString(5);
						model.capacity = Integer.parseInt(result.getString(6));
						model.RAM = Integer.parseInt(result.getString(7));
						model.frontCamera = Integer.parseInt(result.getString(8));
						model.rearCamera = Integer.parseInt(result.getString(9));
						model.weight = Integer.parseInt(result.getString(10));
						model.phoneSize = result.getString(11);
						model.betteryCapacity = Integer.parseInt(result.getString(12));
						model.speed = Double.parseDouble(result.getString(13));
						model.resolution = result.getString(14);
						model.releaseYear = Integer.parseInt(result.getString(15));
						model.color = result.getString(16);
						model.link = result.getString(17);
						model.recCount = Integer.parseInt(result.getString(18));
						model.videolink = result.getString(19);
						modellist.add(i,model);
					
						i++;
						/*
						System.out.println("�𵨸�: " + phoneName 
								+ "\n������: " + company 
								+ "\n����: " + phonePrice + "��"
								+ "\nȭ��ũ��: " + screenSize + "inch" 
								+ "\n�ü��: " + os 
								+ "\n�뷮: " + capacity + "GB" 
								+ "\n��: " + RAM + "GB"
								+ "\n����ī�޶�: " + frontCamera + "�� ȭ��"
								+ "\n�ĸ�ī�޶�: " + rearCamera + "�� ȭ��" 
								+ "\n����: " + weight + "g" 
								+ "\nũ��: " + phoneSize + "mm" 
								+ "\n���͸� �뷮: " + betteryCapacity + "mAh" 
								+ "\n�ӵ�: " + speed + "Ghz" 
								+ "\nȭ���ػ�: " + resolution 
								+ "\n��ó⵵: " + releaseYear + "��" 
								+ "\n����: " + color 
								+ "\n��ũ: " + link 
								+ "\n��õ��: " + recCount + "ȸ\n\n");*/
					}
				} catch(SQLException e){
		            System.out.println("error: " + e);
		        }

				
				return modellist;
			
			} 	
			
			// ����� ���� �޾ƿ��� 
			public void getPlanDB(String info) {
				try{
					// ������ �����ϱ� ���� Statement ��ü ���� 
					Statement statement = connection.createStatement();
					// ������ �ۼ� 
					query = "SELECT * from planInfo WHERE operator = '" + info + "'";
					// ������ ���� 
					result = statement.executeQuery(query);
					// �˻� ��� ��� 
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
						
						System.out.println("����� �̸�: " + planName 
								+ "\n��Ż�: " + operator 
								+ "\n���: " + mobile
								+ "\n����(��): " + planPrice + "��" 
								+ "\n������: " + amtOfData 
								+ "\n������ȭ: " + videoCall
								+ "\n��ȭ: " + call
								+ "\n�޼���: " + message 
								+ "\nƯ�̻���: " + option + "\n\n");
					}
				} catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			
			}
			
			// �޴��� ���� �Է��ϱ� 
			public void setPhoneDB(String[] input) {
				try{
					
					// ������ �ۼ� 
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
					ppstatement.setString(18, input[17]); // ������ ���� ���� �ʿ� ***
					
					
					// ������ ���� 
					int count = ppstatement.executeUpdate();		
					if( count == 0 ){
	                System.out.println("������ �Է� ����");
		            }
		            else{
		                System.out.println("������ �Է� ����");
		            }
		        }
		        catch( SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// ����� ���� �Է��ϱ� 
			public void setPlanDB(String[] input) {
				try{
					// ������ �����ϱ� ���� Statement ��ü ���� 
					Statement statement = connection.createStatement();
					// ������ �ۼ�
					query = "INSERT INTO plansql(operator, planName, mobile, planPrice, data, videoCall, call, message, option)VALUES ('KT', 'ȭ���ÿ����', 'LTE', '45000', '������', '������', '������', '������', '���л� ���' )";
					// ������ ���� 
					result = statement.executeQuery(query);
				}catch(SQLException e){
		            System.out.println("error: " + e);
		        }
			}
			
			// ���� ���� �Է��ϱ�
			public void setCustomerDB(String[] input) {
				try{
					// ������ �����ϱ� ���� Statement ��ü ���� 
					Statement statement = connection.createStatement();
					// ������ �ۼ�
					query = "INSERT INTO customerInfo(ID, password, name, age, phone_number, email_address, sex)VALUES ('" + input[0] + "', '" + input[1] + "', '" + input[2] + "', '" + input[3] + "', '" + input[4] + "', '" + input[5] + "', '" + input[6] + "')";
					// ������ ���� 
					result = statement.executeQuery(query);	
				}catch(SQLException e){
		            System.out.println("error: " + e);
		        }				
			}
			
						
				
			// DB ���� �����ϱ� 	
			public void closeDB() {
			
			try{
	                if( connection != null && !connection.isClosed()){
	                    connection.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	            System.out.println("DB ������ ����Ǿ����ϴ�.");
			}
			
			
			
			
			
			
			
			
			
			

}