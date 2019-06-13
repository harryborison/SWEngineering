package javaCode;

import java.sql.Connection;
import java.util.*;
public class recomPhone {

	Connection conn= DBCon.getmyConnection();
    ArrayList<Model> phonelist = new ArrayList<Model>();
	public void makemodel_list()
	{

		DBTest db = new DBTest();
		db.connectDB();
		phonelist=db.getPhoneDB();
	}
	public String[] recom(String companyname[], int lowprice, int highprice, String purpose[] )
	{
		int Length = phonelist.size();
		int[] count = new int[Length];
		int[] Rank = new int[3];
		String[] resultPhone = new String[3];
		for(int i=0; i< Length;i++)
		{
			count[i] = count[i] + matchcompany(phonelist.get(i).getCompany(),companyname);
			count[i] = count[i] + matchprice(phonelist.get(i).getPhonePrice(),lowprice , highprice);
			count[i] = count[i] + matchpurpose(purpose, phonelist.get(i));
			
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
			resultPhone[t] = phonelist.get(maxindex).getPhoneName();
			count[maxindex] = -1;

		}
		
		
		return resultPhone;
		
		
	}	
	
	
	public int matchcompany(String phonecompany,String company[])
	{
		for(int i=0;i<(company).length;i++)
		{
			if(phonecompany.equals(company[i]))
			{
				return 3;
			}
		}
		return 0;
	}

	public int matchprice(int price,int low, int high) // 가격에따라 가중치를 return
	{
		
		if(price >=low && price <= high)
		{
			return 10;
		}
		else if(price < low)
		{
			int diff = low - price ;
			return calcdiff(diff);
			
		}
		else if(price > high)
		{
			int diff = price - high;
			return calcdiff(diff);
		}
		return 0;
	}
	
	public int matchpurpose(String purpose[], Model model)
	{
		int sum= 0;
		for(int i=0; i<purpose.length;i++)
		{
			if(purpose[i].equals("game"))
			{
				sum = sum + calcGame(model.getRAM(),model.getSpeed());
			}
			if(purpose[i].equals("battery"))
			{
				sum = sum + calcbattery(model.getBetteryCapacity());
			}
			if(purpose[i].equals("camera"))
			{
				sum = sum + calccamera(model.getFrontCamera(),model.getRearCamera());
			}
			if(purpose[i].equals("screen"))
			{
				sum = sum + calcscreen(model.getScreenSize());
			}
			if(purpose[i].equals("storage"))
			{
				sum = sum + calcstorage(model.getCapacity());
			}
			if(purpose[i].equals("new"))
			{
				sum = sum + calcNew(model.getReleaseYear());
			}
			if(purpose[i].equals("light"))
			{
				sum = sum + calclight(model.getWeight());
			}
		}
		return sum;
	}
	
	public int calcGame(int Phoneram, double Phonespeed )
	{
		int sum = 0;
		if(Phoneram>=10)
		{
			sum = sum + 5;
		}
		else if(Phoneram < 10 && Phoneram> 7)
		{
			sum = sum + 3;
		}
		else if(Phoneram <= 7 && Phoneram > 5)
		{
			sum = sum + 2;
		}
		else if(Phoneram <=5 && Phoneram>=4)
		{
			sum = sum +1;
		}
		
		if(Phonespeed>=6.0)
		{
			sum = sum + 3;
		}
		else if(Phonespeed < 6.0 && Phonespeed >=4.0)
		{
			sum = sum + 2;
		}
		else if(Phonespeed < 4.0 && Phonespeed >=2.0)
		{
			sum = sum +1;
		}
		
		return sum;
	}
	public int calcstorage(int storage)
	{
		if(storage >= 500)
		{
			return 4;
		}
		else if(storage <500 && storage >= 250 )
		{
			return 2;
		}
		else if(storage < 250 && storage >= 100 )
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
		
	}
	
	
	public int calcbattery(int battery)
	{
		if(battery >= 4000)
		{
			return 3;
		}
		else if(battery <4000 && battery>=3500)
		{
			return 2;
		}
		else if(battery <3500 && battery >=3000)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
	
	public int calcNew(int madeyear)
	{
		if(madeyear ==2019)
		{
			return 3;
		}
		else if(madeyear == 2018)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	
	
	public int calccamera(int frontCam, int backCam)
	{
		int sum = 0;
		if(frontCam >= 2000 )
		{
			sum = sum + 3;
		}
		else if(frontCam <2000 && frontCam >= 1000)
		{
			sum = sum + 2;
		}
		else if(frontCam<1000 && frontCam>=700)
		{
			sum = sum + 1;
		}
		
		
		if(backCam>=4000)
		{
			sum = sum + 4;
		}
		else if(backCam<4000 && backCam>=3000)
		{
			sum = sum + 3;
		}
		else if(backCam <3000 && backCam >=2000)
		{
			sum = sum + 2;
		}
		else if(backCam <2000 && backCam >=1500)
		{
			sum = sum + 1;
		}
		
		return sum;
		
		
	}
	
	public int calcscreen( double screensize)
	{
		if(screensize >= 6.0 )
		{
			return 3;
		}
		else if(screensize<6.0 && screensize>= 5.5)
		{
			return 2;
			
		}
		else if(screensize<5.5 && screensize>=5.0)
		{
			return 1;
		}
		else
		{
			return 0;
		}
		
	}
		
		public int calclight(int weight)
		{
			if(weight <=175 )
			{
				return 3;
			}
			else if(weight >175 && weight <=185)
			{
				return 2;
			}
			else if(weight > 185 && weight < 200)
			{
			return 1;
			}
			else
			{
			return 0;
			}
	}
	

	public int calcdiff(int diff)// 가격차이에 따른 가중치를 얼마나 줄 지  계산해주는 메서드
	{
		if(diff>=0 && diff <=100000)
		{
			return 8;
		}
		else if(diff>100000 && diff <=200000)
		{
			return 6;
		}
		else if(diff>200000 && diff <=300000)
		{
			return 4;
		}
		else if(diff>300000 && diff <=400000)
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}