package javacode;

public class MainFunc {
		public static void main(String[] args)
		{
			DBTest db = new DBTest();
			db.connectDB();
			db.loadData();// 1번 호출후에는 주석처리 해주세요
			db.CreateCustomerDB();
		}
	}