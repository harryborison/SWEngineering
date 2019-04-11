import java.util.*;
import java.io.*;

public class Customer {
	public Customer() {
		
	}

	public Customer(String name, String iD, String password, String sex, String age, String phone_number,
			String email_address) {
		this.name = name;
		this.ID = iD;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.phone_number = phone_number;
		this.email_address = email_address;
	}

	private String name;
	private String ID;
	private String password;
	private String sex;
	private String age;
	private String phone_number;
	private String email_address;
	ArrayList<Model> ModelList = new ArrayList<Model>(5);
	ArrayList<Plan> PlanList = new ArrayList<Plan>(3);
	//Rating rate = new Rating();
	// 전체 출력
	public void search_model() {

		Model m = new Model();
		String line;
		Scanner ModelIn = null;
		try {
			ModelIn = new Scanner(new FileInputStream("model.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (ModelIn.hasNext()) {
			line = ModelIn.nextLine();
			String[] split = line.split("\t");

			m.setName(split[0]);
			m.setManufacture(split[1]);
			m.setCpu_name(split[2]);
			m.setPrice(Integer.parseInt(split[3]));
			m.setSize(Double.parseDouble(split[4]));
			m.setOs(split[5]);
			m.setStorage(Integer.parseInt(split[6]));
			m.setRam(Integer.parseInt(split[7]));
			m.setCamera_front(Integer.parseInt(split[8]));
			m.setCamera_back(Integer.parseInt(split[9]));
			m.setWeight(Integer.parseInt(split[10]));
			m.setBattery(Integer.parseInt(split[11]));
			m.setCpu_rate(Integer.parseInt(split[12]));
			m.setLed(split[13]);
			if (split[14].equals("x"))
				m.setHome(false);
			else
				m.setHome(true);
			m.detail();

		}
		System.out.println("출력이 종료 되었습니다.");
		ModelIn.close();

	}
	
	public void search_plan(String telecom, double data_min, double data_max, int call_min, int call_max, int price_min,
			int price_max) {

		String line;
		Scanner PlanIn = null;
		try {
			PlanIn = new Scanner(new FileInputStream("plan.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (PlanIn.hasNext()) {
			line = PlanIn.nextLine();
			String[] split = line.split("\t");

			if (split[8].equals(telecom) && (Integer.parseInt(split[4]) - price_min >= 0)
					&& (Integer.parseInt(split[4]) - price_max <= 0) && (Integer.parseInt(split[3]) - call_min >= 0)
					&& (Integer.parseInt(split[3]) - call_max <= 0) && (Double.parseDouble(split[2]) - data_min >= 0)
					&& (Double.parseDouble(split[2]) - data_max <= 0)) {

				Plan p = new Plan(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]),
						Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7], split[8],
						split[9], split[10], Integer.parseInt(split[11]));
				p.detail();
				System.out.println();
			}
		}
		System.out.println("출력이 종료 되었습니다.");
	}

	public void search_plan(String name) {

		String line;
		Scanner PlanIn = null;
		try {
			PlanIn = new Scanner(new FileInputStream("plan.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (PlanIn.hasNext()) {
			line = PlanIn.nextLine();
			String[] split = line.split("\t");

			if (split[0].equals(name)){

				Plan p = new Plan(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]),
						Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7], split[8],
						split[9], split[10], Integer.parseInt(split[11]));
				p.detail();
				System.out.println();
			}
		}
		System.out.println("출력이 종료 되었습니다.");
	}
	
	public void search_model(String name) {

		Model m = new Model();
		String line;
		Scanner ModelIn = null;
		try {
			ModelIn = new Scanner(new FileInputStream("model.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (ModelIn.hasNext()) {
			line = ModelIn.nextLine();
			String[] split = line.split("\t");

			if (split[0].equals(name)){
				m.setName(split[0]);
				m.setManufacture(split[1]);
				m.setCpu_name(split[2]);
				m.setPrice(Integer.parseInt(split[3]));
				m.setSize(Double.parseDouble(split[4]));
				m.setOs(split[5]);
				m.setStorage(Integer.parseInt(split[6]));
				m.setRam(Integer.parseInt(split[7]));
				m.setCamera_front(Integer.parseInt(split[8]));
				m.setCamera_back(Integer.parseInt(split[9]));
				m.setWeight(Integer.parseInt(split[10]));
				m.setBattery(Integer.parseInt(split[11]));
				m.setCpu_rate(Integer.parseInt(split[12]));
				m.setLed(split[13]);
				if (split[14].equals("x"))
					m.setHome(false);
				else
					m.setHome(true);
				m.detail();

			}
		}
		ModelIn.close();
	}

	public void search_model(String manufacture, int min, int max) {

		Model m = new Model();
		String line;
		Scanner ModelIn = null;
		try {
			ModelIn = new Scanner(new FileInputStream("model.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (ModelIn.hasNext()) {
			line = ModelIn.nextLine();
			String[] split = line.split("\t");

			if (split[1].equals(manufacture) && (Integer.parseInt(split[3]) - min > 0)
					&& (Integer.parseInt(split[3]) - max < 0)) {
				m.setName(split[0]);
				m.setManufacture(split[1]);
				m.setCpu_name(split[2]);
				m.setPrice(Integer.parseInt(split[3]));
				m.setSize(Double.parseDouble(split[4]));
				m.setOs(split[5]);
				m.setStorage(Integer.parseInt(split[6]));
				m.setRam(Integer.parseInt(split[7]));
				m.setCamera_front(Integer.parseInt(split[8]));
				m.setCamera_back(Integer.parseInt(split[9]));
				m.setWeight(Integer.parseInt(split[10]));
				m.setBattery(Integer.parseInt(split[11]));
				m.setCpu_rate(Integer.parseInt(split[12]));
				m.setLed(split[13]);
				if (split[14].equals("x"))
					m.setHome(false);
				else
					m.setHome(true);
				m.detail();

			}
		}
		System.out.println("출력이 종료 되었습니다.");
		ModelIn.close();
	}

	public void recommand_Plans(String[] telecom, String[] data, String[] call, String[] msg, Customer user,
			ArrayList<Plan> PlanList) {
		this.PlanList = PlanList;
		Plan p = new Plan();
		p.recommand(telecom, data, call, msg, user, this.PlanList);
		
		
	}
	
	public void model_wish_print() {
		
		System.out.println("my model list : ");

		for(int i=0;i<5;i++) {
			System.out.println(i);
			ModelList.get(i).simple_print();
		}
	}
	
	public void plan_wish_print() {
		
		System.out.println("my plan list : ");

		for(int i=0;i<3;i++) {
			System.out.println(i);
			PlanList.get(i).simple_print();
		}
	}

	public void recommand_Models(String[] manu, String[] price, String[] function, Customer user,
			ArrayList<Model> ModelList) {
		this.ModelList = ModelList;
		Model m = new Model();
		m.recommand(manu, price, function, user, this.ModelList);
	}

	// After this line, only getter,setter exist
	public String getemail_address() {
		return email_address;
	}

	public void setemail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getphone_number() {
		return phone_number;
	}

	public void setphone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getage() {
		return age;
	}

	public void setage(String age) {
		this.age = age;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	public String getsex() {
		return sex;
	}

	public void setsex(String sex) {
		this.sex = sex;
	}

	public void modify(ArrayList<Customer> customerlist, String newstring, int target_index, int menu) {
		String fileName = "custom.txt";
		File inputFile = new File(fileName);
		File outputFile = new File("temp.txt");
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		FileOutputStream fileOutputStream = null;
		BufferedWriter bufferedWriter = null;

		Customer temp = this;

		if (menu == 1) {
			temp.setname(newstring);
		} else if (menu == 2) {
			temp.setpassword(newstring);
		} else if (menu == 3) {
			temp.setsex(newstring);
		} else if (menu == 4) {
			temp.setage(newstring);
		} else if (menu == 5) {
			temp.setemail_address(newstring);
		} else if (menu == 6) {
			temp.setphone_number(newstring);
		}

		customerlist.remove(target_index);
		customerlist.add(target_index, temp);
		try {
			fileInputStream = new FileInputStream(inputFile);
			fileOutputStream = new FileOutputStream(outputFile);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

			for (int i = 0; i < customerlist.size(); i++) {
				Customer c = customerlist.get(i);
				String str;
				str = c.getname() + ' ' + c.getID() + ' ' + c.getpassword() + ' ' + c.getsex() + ' ' + c.getage() + ' '
						+ c.getemail_address() + ' ' + c.getphone_number();

				bufferedWriter.append(str);
				bufferedWriter.newLine();
			}

			try {
				bufferedReader.close();
			} catch (IOException ex1) {
				ex1.printStackTrace();
			}

			try {
				bufferedWriter.close();
			} catch (IOException ex2) {
				ex2.printStackTrace();
			}

			inputFile.delete();
			outputFile.renameTo(new File(fileName));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void remove_member(ArrayList<Customer> customerlist, int target_index) {
		String fileName = "custom.txt";
		File inputFile = new File(fileName);
		File outputFile = new File("temp.txt");
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		FileOutputStream fileOutputStream = null;
		BufferedWriter bufferedWriter = null;

		customerlist.remove(target_index);
		for (int i = target_index; i < customerlist.size() - 1; i++) {
			Customer temp;
			temp = customerlist.get(i + 1);
			customerlist.add(i, temp);
			customerlist.remove(i + 1);
		}

		try {
			fileInputStream = new FileInputStream(inputFile);
			fileOutputStream = new FileOutputStream(outputFile);
			bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

			for (int i = 0; i < customerlist.size(); i++) {
				Customer c = customerlist.get(i);
				String str;
				str = c.getname() + ' ' + c.getID() + ' ' + c.getpassword() + ' ' + c.getsex() + ' ' + c.getage() + ' '
						+ c.getemail_address() + ' ' + c.getphone_number();

				bufferedWriter.append(str);
				bufferedWriter.newLine();
			}

			try {
				bufferedReader.close();
			} catch (IOException ex1) {
				ex1.printStackTrace();
			}

			try {
				bufferedWriter.close();
			} catch (IOException ex2) {
				ex2.printStackTrace();
			}

			inputFile.delete();
			outputFile.renameTo(new File(fileName));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Model> getModelList() {
		return ModelList;
	}

	public void setModelList(ArrayList<Model> modelList) {
		ModelList = modelList;
	}

	public ArrayList<Plan> getPlanList() {
		return PlanList;
	}

	public void setPlanList(ArrayList<Plan> planList) {
		PlanList = planList;
	}

}