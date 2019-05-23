import java.io.*;
import java.util.*;

public class Model {

	private int price, camera_front, storage, ram, camera_back, weight, battery,count, made_date;
	private String name, manufacture, os, led, link, color, resolution,cpu_rate;
	private double size;
	/* size = 몇 인치인지 */
	
	ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	ArrayList<Rating> RatingList = new ArrayList<Rating>();
	Admin a = new Admin();
	ReviewManager r = new ReviewManager();
	Rating ra = new Rating();
	
	
	public Model() {

	}
	public Model( String name,String manufacture, int price, double size, String os,int storage, int ram, int camera_front
			, int camera_back, int weightm ,String led, int battery, String cpu_rate, String resolution,
			int made_date , String color,String link, int count)
	{

		this.price = price;
		this.camera_front = camera_front;
		this.storage = storage;
		this.ram = ram;
		this.camera_back=camera_back;
		this.weight = weight;
		this.battery = battery;
		this.count = count;
		this.made_date = made_date;
		this.name = name;
		this.manufacture = manufacture;
		this.os = os;
		this.led = led;
		this.link = link;
		this.color = color;
		this.resolution = resolution;
		this.size = size;
		this.cpu_rate = cpu_rate;

	}

	public void AddModelList(Model m) {// 파일에 추가 해야한다.

		String str2 = new String();

		str2 = m.getName() + '\t' + m.getManufacture() + '\t' + m.getPrice() + '\t' + m.getSize() + '\t'
				+ m.getOs() + '\t' + m.getStorage() + '\t' + m.getRam() + '\t' + m.getCamera_front() + '\t'
				+ m.getCamera_back() + '\t' + m.getCamera_back() + '\t' + m.getWeight() + '\t' + m.getSize() + '\t'
				+ m.getBattery() + '\t' + m.getCpu_rate()  + '\t'+ m.getResolution()  + '\t'
				+ m.getMade_date()  + '\t'
				+ m.getColor()  + '\t'
				+ m.getLink() +'\t'
				+ m.getCount();

		
		try {
			FileWriter filewriter = new FileWriter("model.txt", true);

			BufferedWriter out = new BufferedWriter(filewriter);
			out.newLine();
			out.append(str2);
			out.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	 public void recommand(String[] manu, String[] price, String[] function, Customer user,
				ArrayList<Model> ModelList) {
		 
		 ra.ModelRating(manu, price, function, user, ModelList);
	 }
	public void detail() {
		ReviewManager r = new ReviewManager();
		System.out.print("<<");
		System.out.print(name);
		System.out.print(">>");
		System.out.print(" 제조사 : ");
		System.out.print(manufacture);
		System.out.print(" 가격 : ");
		System.out.print(price);
		System.out.print(" 크기(인치) : ");
		System.out.print(size);
		System.out.print(" 운영체제 : ");
		System.out.print(os);
		System.out.println();
		System.out.print(" 용량 : ");
		System.out.print(storage);
		System.out.print(" 메모리 : ");
		System.out.print(ram);
		System.out.print(" 전면 카메라 : ");
		System.out.print(camera_front);
		System.out.print(" 후면 카메라 : ");
		System.out.print(camera_back);
		System.out.print(" 무게 : ");
		System.out.print(weight);
		System.out.print(" 배터리 용량 : ");
		System.out.print(battery);
		System.out.print("CPU 속도 : ");
		System.out.print(cpu_rate);
		System.out.print("GHz 화면크기 : ");
		System.out.print(led);
		System.out.print("출시년도 : ");
		System.out.print(made_date);
		System.out.print("색상 : ");
		System.out.print(color);
		System.out.print("해상도 : ");
		System.out.print(resolution);
		System.out.print("링크 : ");
		System.out.print(link);
		System.out.print("추천수 : ");
		System.out.print(count);;
		
		
		System.out.println();
		System.out.println();
	}

	public void simple_print() {
		System.out.print("<<");
		System.out.print(name);
		System.out.print(">>");
		System.out.print(" 제조사 : ");
		System.out.print(manufacture);
		System.out.print(" 가격 : ");
		System.out.print(price);
		System.out.print(" 용량 : ");
		System.out.print(storage);
		System.out.print(" 메모리 : ");
		System.out.print(ram);
		System.out.print(" 후면 카메라 : ");
		System.out.print(camera_back);
		System.out.println();
	}

	// After this line, only getter setter exist.
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCamera_front() {
		return camera_front;
	}
	public void setCamera_front(int camera_front) {
		this.camera_front = camera_front;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getCamera_back() {
		return camera_back;
	}
	public void setCamera_back(int camera_back) {
		this.camera_back = camera_back;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getBattery() {
		return battery;
	}
	public void setBattery(int battery) {
		this.battery = battery;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMade_date() {
		return made_date;
	}
	public void setMade_date(int made_date) {
		this.made_date = made_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getLed() {
		return led;
	}
	public void setLed(String led) {
		this.led = led;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getCpu_rate() {
		return cpu_rate;
	}
	public void setCpu_rate(String cpu_rate) {
		this.cpu_rate = cpu_rate;
	}

}