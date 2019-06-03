package javaCode;

import java.sql.Connection;
import java.util.ArrayList;

public class recomPlan {
	Connection conn= DBCon.getmyConnection();
    ArrayList<Plan> planlist = new ArrayList<Plan>();
	public void makeplan_list()
	{

		DBTest db = new DBTest();
		db.connectDB();
		planlist=db.getPlanDB();
	}
	
	public Plan[] recPlan(String telecom[], String type[] , int lowprice,int highprice , int data, String option[])
	{
		int Length = planlist.size();
		int[] count = new int[Length];
		Plan[] resultPlan = new Plan[3];
		for(int i=0; i<Length ; i++)
		{
			count[i] = count[i] + matchtelecom(planlist.get(i).operator,telecom);
			count[i] = count[i] + matchtype(planlist.get(i).mobile,type);
			count[i] = count[i] + matchprice(planlist.get(i).planPrice,lowprice,highprice);
			count[i] = count[i] + matchdata(planlist.get(i).data2,data);
			count[i] = count[i] + matchoption(option,planlist.get(i));
		}

		for (int t=0; t<3 ; t++)
		{
			int max = 0;
			int maxindex = 0;
			for(int i=0 ; i<count.length ; i++ )
			{
				if(max < count[i])
				{
					max = count[i];
					maxindex = i;
				}
			}
			resultPlan[t] = planlist.get(maxindex);
			count[maxindex] = -1;

		}
		

		return resultPlan;
		
	}
	
	public int matchtelecom(String tel, String wanttel[])
	{
		for(int i=0;i<(wanttel).length;i++)
		{
			if(tel.equals(wanttel[i]))
			{
				return 3;
			}
		}
		return 0;
	}
	
	public int matchtype(String type , String wanttype[])
	{
		for(int i=0;i<(wanttype).length;i++)
		{
			if(type.equals(wanttype[i]))
			{
				return 3;
			}
		}
		return 0;
	}
	
	public int matchprice(int planprice , int lowprice , int highprice)
	{
		int diff;
		if(planprice >= lowprice && planprice <= highprice)
		{
			return 5;
		}
		else if( planprice < lowprice)
		{
			diff = lowprice - planprice;
			return matchdiff(diff);
			
		}
		else if (planprice > highprice)
		{
			diff = planprice - highprice;
			return matchdiff(diff);

		}
		return 0;
	}
	
	public int matchdiff(int diff)
	{
		if(diff>0 && diff <=5000)
		{
			return 3;
		}
		if(diff>5000 && diff<=10000)
		{
			return 2;
		}
		if(diff>10000 && diff <=20000)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public int matchdata(int data, int wantdata)
	{
		if(wantdata == 500000) // 원하는 데이터가 무제한일 경우
		{
			if(data == wantdata)
			{
				return 5;
			}
			else
			{
				return 0;
			}
		}
		else
		{
			if(data == 500000) // 원하는 데이터는 무제한이 아닌데 비교하는 데이터가 무제한일 경우
			{
				return 0;
			}
			else
			{
				int dif = Math.abs(data - wantdata);
				if(dif > 0 && dif < 500)
				{
					return 5;
				}
				else if(dif >=500 && dif < 1000)
				{
					return 4;
				}
				else if(dif >=1000 && dif < 1500)
				{
					return 3;
				}
				else if(dif >=1500 && dif < 2000)
				{
					return 2;
				}
				else if(dif >=2500 && dif < 3000)
				{
					return 1;
				}
			}
			
			
		}
		return 0;
	}
	public int matchoption(String option[], Plan plan )
	{
		int sum = 0;
		for(int i=0; i< option.length; i++)
		{
			
			if(option[i].equals("soldier"))
			{
				if(plan.option.matches(".*군인.*"))
				{
					sum = sum + 3;
				}
					
			}
			if(option[i].equals("nextmonth"))
			{
				if(plan.option.matches(".*이월.*"))
				{
					sum =sum + 3;
				}
				
			}
			if(option[i].equals("vip"))
			{
				if(plan.option.matches("(?!).*vip.*"))
				{
					sum = sum + 3;
				}
			}
			if(option[i].equals("feature"))
			{
				if(plan.option.matches(".*피쳐.*"))
				{
					sum = sum + 3;
				}
			}
			if(option[i].equals("notsee"))
			{
				if(plan.option.matches(".*시각.*"))
				{
					sum = sum + 3;
				}
			}
			if(option[i].equals("notlisten"))
			{
				if(plan.option.matches(".*청각.*"))
				{
					sum = sum + 3;
				}
			}
			if(option[i].equals("diabled"))
			{
				if(plan.option.matches(".*장애.*"))
				{
					sum = sum + 3;
				}
			}
			
			if(option[i].equals("old"))
			{
				if(plan.option.matches(".*65세.*"))
				{
					sum = sum + 3;
				}
			}
			if(option[i].equals("young"))
			{
				if(plan.option.matches(".*18세.*") || plan.option.matches(".*청소년.*"))
				{
					sum = sum + 6;
				}
			}
			
			
			
			
		}
		return sum;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
