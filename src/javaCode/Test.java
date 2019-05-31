package javaCode;

public class Test {

		public static void main(String args[])
		{
			DBTest db = new DBTest();
			String[] com = new String[2];
			String[] pur = new String[3];
			String[] result = new String[3];
			//db.connectDB();
			//db.loadData();
			db.getPlanDB("KT");
			//db.getPlanDB("KT");
			//db.closeDB();
			recomPhone rep = new recomPhone();
			rep.makemodel_list();
			com[0]="LG";
			com[1]="Samsung";
			pur[0]="new";
			pur[1]="storage";
			pur[2]="screen";
			result = rep.recom(com, 500000, 800000, pur);
			System.out.printf("1: %s\n2: %s\n3: %s\n", result[0],result[1],result[2]);
		}
	
	
	}

