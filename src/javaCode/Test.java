package javaCode;

public class Test {

	public static void main(String args[])
	{
		DBTest db = new DBTest();
		db.connectDB();
		db.deleteCustomerDB();
		db.CreateCustomerDB();
		String[] cusInfo = new String[7];
		cusInfo[0] = "id";
		cusInfo[1] = "password";
		cusInfo[2] = "name";
		cusInfo[3] = "age";
		cusInfo[4] = "123123";
		cusInfo[5] = "asdfasf123";
		cusInfo[6] = "asdf";
		db.setCustomerDB(cusInfo);
	}


}

