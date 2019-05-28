package javaCode;

public class Test {

		public static void main(String args[])
		{
			DBTest db = new DBTest();
			db.connectDB();
			//db.loadData();
			db.getPhoneDB("iPhone X(256GB)");
			//db.getPlanDB("KT");
			//db.closeDB();
		}
	
	
	}

