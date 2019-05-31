package javaCode;

public class Test {

		public static void main(String args[])
		{
			DBTest db = new DBTest();
			db.connectDB();
			//db.loadData();
			db.getPlanDB("KT");
			//db.getPlanDB("KT");
			//db.closeDB();
		}
	
	
	}

