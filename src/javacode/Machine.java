package javacode;

import java.util.ArrayList;

public class Machine implements Publisher{
	private ArrayList<Observer> observers;
	private String phone1, phone2, phone3;
	
	@Override 
	public void add(Observer observer) 
	{ 
		observers.add(observer); 
	} 
	@Override 
	public void delete(Observer observer) 
	{ 
		int index = observers.indexOf(observer); 
		observers.remove(index); 
	} 
	@Override 
	public void notifyObserver() 
	{ 
		for(Observer observer : observers) 
		{ 
			observer.update(phone1, phone2, phone3); 
		} 
	}

	public void addPhoneCount(String p1, String p2, String p3)
	{
		this.phone1 = p1;
		this.phone2 = p2;
		this.phone3 = p3;
		
		// 여기서 디비에 count 값 ++ 하기
		
		
		
		notifyObserver();
	}
	
	public String getContents()
	{
		return phone1 + phone2 + phone3;
	}
}
