import java.io.*;
import java.util.*;

public class Model {

	private int price, camera_front, storage, ram, camera_back, weight, battery;
	private String name, manufacture, os, led, cpu_name;
	private boolean home;
	private double size, cpu_rate;
	
	ArrayList<Customer> CustomerList = new ArrayList<Customer>();
	ArrayList<Rating> RatingList = new ArrayList<Rating>();
	Admin a = new Admin();
	ReviewManager r = new ReviewManager();
	Rating ra = new Rating();
	
	
	public Model() {

	}

	public Model(String name, String manufacture, String cpu_name, double size, String os, int price, int storage,
			int ram, int camera_front, int camera_back, int weight, int battery, double cpu_rate, String led,
			boolean home) {

		this.name = name;
		this.manufacture = manufacture;
		this.cpu_name = cpu_name;
		this.price = price;
		this.size = size;
		this.os = os;
		this.storage = storage;
		this.ram = ram;
		this.camera_front = camera_front;
		this.camera_back = camera_back;
		this.weight = weight;
		this.battery = battery;
		this.cpu_rate = cpu_rate;
		this.led = led;
		this.home = home;

	}

	public void AddModelList(Model m) {// 파일에 추가 해야한다.

		String str2 = new String();

		str2 = m.getName() + '\t' + m.getManufacture() + '\t' + m.getCpu_name() + '\t' + m.getPrice() + '\t'
				+ m.getSize() + '\t' + m.getOs() + '\t' + m.getStorage() + '\t' + m.getRam() + '\t'
				+ m.getCamera_front() + '\t' + m.getCamera_back() + '\t' + m.getWeight() + '\t' + m.getBattery() + '\t'
				+ m.getCpu_rate() + '\t' + m.getLed();

		if (home) {
			str2 = str2 + '\t' + 'o';
		} else {
			str2 = str2 + '\t' + 'x';
		}

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
		System.out.print("CPU : ");
		System.out.print(cpu_name);
		System.out.print(" 가격 : ");
		System.out.print(price);
		System.out.print(" 크기 : ");
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
		System.out.print(" 홈 화면 유무");
		if (home == true)
			System.out.print('O');
		else
			System.out.print('X');
		
		r.PrintReview(name);
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

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public int getCamera_front() {
		return camera_front;
	}

	public void setCamera_front(int camera_front) {
		this.camera_front = camera_front;
	}

	public double getCpu_rate() {
		return cpu_rate;
	}

	public void setCpu_rate(double cpu_rate) {
		this.cpu_rate = cpu_rate;
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

	public String getCpu_name() {
		return cpu_name;
	}

	public void setCpu_name(String cpu_name) {
		this.cpu_name = cpu_name;
	}

	public boolean isHome() {
		return home;
	}

	public void setHome(boolean home) {
		this.home = home;
	}

}