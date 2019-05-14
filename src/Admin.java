import java.io.*;
import java.util.*;

public class Admin {
	String ID;
	String password;
	//string Test;;
	ArrayList<Model> ModelList = new ArrayList<Model>();
	ArrayList<Plan> PlanList = new ArrayList<Plan>();
	
	
	public Admin() {};
	

	public Admin(String id, String pw) {
		ID = id;
		password = pw;
	}

	boolean Login(String id, String pw) {
		boolean result = false;

		if (id.equals(ID) && pw.equals(password)) {
			result = true;
		}
		return result;
	}

	boolean AddModel(Model m, ArrayList<Model> ModelList) {
		boolean result;
		if (!CheckExistModel(m.getName(), ModelList)) {
			m.AddModelList(m);
			result = true;
		}

		else
			result = false;

		return result;
	}

	boolean AddPlan(Plan p, ArrayList<Plan> PlanList) {
		boolean result;
		if (!CheckExistPlan(p.getTelecom(), p.getName(), PlanList)) {
			p.AddPlanList(p);
			result = true;
		} else
			result = false;

		return result;
	}

	boolean CheckExistModel(String name, ArrayList<Model> ModelList) {
		boolean result = false;
		for (int i = 0; i < ModelList.size(); i++) {
			Model temp = ModelList.get(i);
			if (name.equals(temp.getName())) {
				result = true;
			}
		}
		return result;
	}

	boolean CheckExistPlan(String telecom, String name, ArrayList<Plan> PlanList) {
		boolean result = false;
		for (int i = 0; i < PlanList.size(); i++) {
			Plan temp = PlanList.get(i);
			if (telecom.equals(temp.getTelecom()) && name.equals(temp.getName())) {
				result = true;
			}
		}

		return result;
	}

	boolean RemoveModel(String target, ArrayList<Model> ModelList) {
		boolean result;

		if (CheckExistModel(target, ModelList)) {
			result = true;
			for (int i = 0; i < ModelList.size(); i++) {
				if (target.equals(ModelList.get(i).getName())) {
					ModelList.remove(i);
					for (int j = i; j < ModelList.size() - 1; j++) {
						Model temp;
						temp = ModelList.get(j + 1);
						ModelList.remove(j + 1);
						ModelList.add(j, temp);
					}
					break;
				}
			}
			String fileName = "model.txt";
			File inputFile = new File(fileName);
			File outputFile = new File("temp.txt");
			FileInputStream fileInputStream = null;
			BufferedReader bufferedReader = null;
			FileOutputStream fileOutputStream = null;
			BufferedWriter bufferedWriter = null;

			try {
				fileInputStream = new FileInputStream(inputFile);
				fileOutputStream = new FileOutputStream(outputFile);
				bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
				bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

				for (int i = 0; i < ModelList.size(); i++) {
					Model temp = ModelList.get(i);
					String str = new String();

					str = temp.getName() + '\t' + temp.getManufacture() + '\t' + temp.getCpu_name() + '\t'
							+ temp.getPrice() + '\t' + temp.getSize() + '\t' + temp.getOs() + '\t' + temp.getStorage()
							+ '\t' + temp.getRam() + '\t' + temp.getCamera_front() + '\t' + temp.getCamera_back() + '\t'
							+ temp.getWeight() + '\t' + temp.getBattery() + '\t' + temp.getCpu_rate() + '\t'
							+ temp.getLed();

					if (temp.isHome()) {
						str = str + '\t' + 'o';
					} else {
						str = str + '\t' + 'x';
					}

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

		} else {
			result = false;
		}

		return result;
	}

	boolean RemovePlan(String telecom, String target, ArrayList<Plan> PlanList) {
		boolean result;

		if (CheckExistPlan(telecom, target, PlanList)) {
			result = true;
			for (int i = 0; i < PlanList.size(); i++) {
				if (target.equals(PlanList.get(i).getName()) && telecom.equals(PlanList.get(i).getTelecom())) {
					PlanList.remove(i);
					for (int j = i; j < PlanList.size() - 1; j++) {
						Plan temp;
						temp = PlanList.get(j + 1);
						PlanList.remove(j + 1);
						PlanList.add(j, temp);
					}
					break;
				}
			}
			String fileName = "plan.txt";
			File inputFile = new File(fileName);
			File outputFile = new File("temp.txt");
			FileInputStream fileInputStream = null;
			BufferedReader bufferedReader = null;
			FileOutputStream fileOutputStream = null;
			BufferedWriter bufferedWriter = null;

			try {
				fileInputStream = new FileInputStream(inputFile);
				fileOutputStream = new FileOutputStream(outputFile);
				bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
				bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

				for (int i = 0; i < PlanList.size(); i++) {
					Plan temp = PlanList.get(i);
					String str = new String();

					str = temp.getName() + '\t' + temp.getMax_age() + '\t' + temp.getData() + '\t' + temp.getCalling()
							+ '\t' + temp.getPrice() + '\t' + temp.getDetail_data() + '\t' + temp.getDetail_calling() + '\t'
							+ temp.getDetail_message() + '\t' + temp.getTelecom() + '\t' + temp.getDetail_etc1() + '\t'
							+ temp.getDetail_etc2() +'\t'+ temp.getMessage();

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
		} else
			result = false;
		return result;
	}
}
