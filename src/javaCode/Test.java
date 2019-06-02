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
			//db.getPhoneDB("iPhone X(256GB)");
			//db.getPlanDB("KT");
			//db.closeDB();
			Plan[] p = new Plan[3];
			recomPlan rep = new recomPlan();
			rep.makepaln_list();
			String[] tel = new String[2];
			tel[0]="SKT";
			tel[1]="KT";
			String[] ty = new String[1];
			ty[0]="5G";
			int lowprice = 50000;
			int highprice = 70000;
			int data = 5000;
			String[] option = new String[2];
			option[0]="시각장애인";
			option[1]="군인";
			p=rep.recPlan(tel,ty,lowprice,highprice,data,option);
			System.out.printf("%s\n%s\n%s\n", p[0].planName,p[1].planName,p[2].planName);
		}
	
	
	}

