package DBTest;

public class Test {

	public static void main(String[] args) {
		DBTest db = new DBTest();
		db.connectDB();
		db.loadData();
		db.getPhoneDB("iPhone XsM(512GB)");
		db.getPlanDB("KT");
		db.closeDB();
	
	}

}
