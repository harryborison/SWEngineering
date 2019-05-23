import java.util.*;
import java.io.*;

public class Rating {
	
	ArrayList<Model> ModelList = new ArrayList<Model>();
	ArrayList<Plan> PlanList = new ArrayList<Plan>();
	Customer c = new Customer();
	
	public Rating() {
		
		
	}
	

	public void ModelRating(String[] manu, String[] price, String[] function, Customer user,ArrayList<Model> ModelList) {
		this.ModelList = ModelList;
		ArrayList<Double> score = new ArrayList<Double>();
		for (int i = 0; i < ModelList.size(); i++) {
			Model temp;
			score.add(i, 0.0);
			double temp_score;
			temp = ModelList.get(i);

			for (int j = 0; j < manu.length; j++) {
				if (manu[j].equals("1") && temp.getManufacture().equals("APPLE")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				} else if (manu[j].equals("2") && temp.getManufacture().equals("삼성")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				} else if (manu[j].equals("3") && temp.getManufacture().equals("LG")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				} else if (manu[j].equals("4") && temp.getManufacture().equals("샤오미")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 10.0);
				}
			}

			//////////////////////////////////////////////////////////////////////////////////

			for (int j = 0; j < price.length; j++) {
				if (price[j].equals("1") && temp.getPrice() > 0 && temp.getPrice() < 100000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("2") && temp.getPrice() >= 100000 && temp.getPrice() < 200000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("3") && temp.getPrice() >= 200000 && temp.getPrice() < 300000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("4") && temp.getPrice() >= 300000 && temp.getPrice() < 400000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("5") && temp.getPrice() >= 400000 && temp.getPrice() < 500000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("6") && temp.getPrice() >= 500000 && temp.getPrice() < 600000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("7") && temp.getPrice() >= 600000 && temp.getPrice() < 700000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("8") && temp.getPrice() >= 700000 && temp.getPrice() < 800000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("9") && temp.getPrice() >= 800000 && temp.getPrice() < 900000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("10") && temp.getPrice() >= 900000 && temp.getPrice() < 1000000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("11") && temp.getPrice() >= 1000000 && temp.getPrice() < 1100000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("12") && temp.getPrice() >= 1100000 && temp.getPrice() < 1200000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("13") && temp.getPrice() >= 1200000 && temp.getPrice() < 1300000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("14") && temp.getPrice() >= 1300000 && temp.getPrice() < 1400000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("15") && temp.getPrice() >= 1400000 && temp.getPrice() < 1500000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				} else if (price[j].equals("16") && temp.getPrice() >= 1500000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1);
				}

			}

			/////////////////////////////////////////////////////////////////////////////
			// 1. 홈버튼 필요 3. 고사양 게임 4. 대용량 배터리 5. 고성능 카메라 6. 큰 화면 7. 대용량 메모리 8.
			///////////////////////////////////////////////////////////////////////////// 고화질
			///////////////////////////////////////////////////////////////////////////// 동영상
			for (int j = 0; j < function.length; j++) {

				if (function[j].equals("1") && temp.isHome()) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.1);
				} else if (function[j].equals("2") && temp.getCpu_rate() > 2.15) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 3.4);
				} else if (function[j].equals("3") && temp.getBattery() >= 3000) {
					temp_score = score.get(i);
					score.remove(i);
					if (temp.getRam() > 3.1)
						score.add(i, temp_score + 2.25);
					else
						score.add(i, temp_score + 1.14);
				} else if (function[j].equals("4") && temp.getCamera_back() > 1350) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 3.1);
				} else if (function[j].equals("5") && temp.getSize() >= 15) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.11);
				} else if (function[j].equals("6") && temp.getStorage() >= 64) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.4);
				} else if (function[j].equals("7") && temp.getBattery() >= 3000) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 1.2);
				}
			}
		}

		double max = score.get(0);
		int[] max_index = new int[5];
		int temp_index = 0;

		for (int i = 0; i < 5; i++) {
			max = score.get(0);
			temp_index = 0;

			for (int j = 1; j < score.size(); j++) {
				if (score.get(j) > max) {
					temp_index = j;
					max = score.get(j);
				}
			}

			max_index[i] = temp_index;

			score.add(temp_index, 0.0);

		}

		System.out.println("5가지를 추천합니다");
		for (int i = 0; i < 5; i++) {
			this.ModelList.add(ModelList.get(max_index[i]));
			ModelList.get(max_index[i]).simple_print();
		}

		user.setModelList(this.ModelList);
		
		System.out.println("추천받은 모델의 세부사항을 보고싶으시다면 '보기'를, 원하지 않으시면 '종료'를 입력해 주세요.");
		String isdetail;
		Scanner keyboard = new Scanner(System.in);
		isdetail = keyboard.next();

		while (!isdetail.equals("종료")) {

			if (isdetail.equals("보기")) {
				for (int i = 0; i < 5; i++) {
					ModelList.get(max_index[i]).detail();
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				isdetail = keyboard.next();
			}

		}
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	

	public void PlanRating(String[] manu, String[] data, String[] call, String[] msg, Customer user,
			ArrayList<Plan> PlanList) {
		Plan p = new Plan();
		ArrayList<Double> score = new ArrayList<Double>();
		for (int i = 0; i < PlanList.size(); i++) {
			Plan temp;
			score.add(i, 0.0);
			double temp_score;
			temp = PlanList.get(i);
			for (int j = 0; j < manu.length; j++) {
				if (manu[j].equals("1") && temp.getTelecom().equals("SKT")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				} else if (manu[j].equals("2") && temp.getTelecom().equals("KT")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				} else if (manu[j].equals("3") && temp.getTelecom().equals("U+")) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 20.0);
				}
			}

			for (int j = 0; j < data.length; j++) {
				if (data[j].equals("1") && temp.getData() >= 0 && temp.getData() < 1) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				} else if (data[j].equals("2") && temp.getData() >= 1 && temp.getData() < 2) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				} else if (data[j].equals("3") && temp.getData() >= 2 && temp.getData() < 3) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				} else if (data[j].equals("4") && temp.getData() >= 3 && temp.getData() < 4) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("5") && temp.getData() >= 4 && temp.getData() < 5) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("6") && temp.getData() >= 5 && temp.getData() < 6) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("7") && temp.getData() >= 6 && temp.getData() < 7) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("8") && temp.getData() >= 7 && temp.getData() < 8) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("9") && temp.getData() >= 8 && temp.getData() < 9) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("10") && temp.getData() >= 9 && temp.getData() < 10) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

				else if (data[j].equals("11") && temp.getData() >= 10) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 4.3);
				}

			}

			for (int j = 0; j < call.length; j++) {
				if (call[j].equals("1") && temp.getCalling() >= 0 && temp.getCalling() < 50) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("2") && temp.getCalling() >= 50 && temp.getCalling() < 100) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("3") && temp.getCalling() >= 100 && temp.getCalling() < 150) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("4") && temp.getCalling() >= 150 && temp.getCalling() < 200) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				}

				else if (call[j].equals("5") && temp.getCalling() >= 200 && temp.getCalling() < 250) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("6") && temp.getCalling() >= 250 && temp.getCalling() < 300) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("7") && temp.getCalling() >= 300 && temp.getCalling() < 350) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("8") && temp.getCalling() >= 350 && temp.getCalling() < 400) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("9") && temp.getCalling() >= 400 && temp.getCalling() < 450) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("10") && temp.getCalling() >= 450 && temp.getCalling() < 500) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (call[j].equals("11") && temp.getCalling() >= 500) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				}
			}

			for (int j = 0; j < msg.length; j++) {
				if (msg[j].equals("1") && temp.getMessage() >= 0 && temp.getMessage() < 50) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("2") && temp.getMessage() >= 50 && temp.getMessage() < 100) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("3") && temp.getMessage() >= 100 && temp.getMessage() < 150) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("4") && temp.getMessage() >= 150 && temp.getMessage() < 200) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				}

				else if (msg[j].equals("5") && temp.getMessage() >= 200 && temp.getMessage() < 250) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("6") && temp.getMessage() >= 250 && temp.getMessage() < 300) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("7") && temp.getMessage() >= 300 && temp.getMessage() < 350) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("8") && temp.getMessage() >= 350 && temp.getMessage() < 400) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("9") && temp.getMessage() >= 400 && temp.getMessage() < 450) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("10") && temp.getMessage() >= 450 && temp.getMessage() < 500) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				} else if (msg[j].equals("11") && temp.getMessage() >= 500) {
					temp_score = score.get(i);
					score.remove(i);
					score.add(i, temp_score + 2.3);
				}
			}
		}

		for (int j = 0; j < PlanList.size(); j++) {
			if (PlanList.get(j).getMax_age() > 0 && Integer.parseInt(user.getage()) > PlanList.get(j).getMax_age()) {
				score.add(j, 0.0);
			}
		}

		double max = score.get(0);
		int[] max_index = new int[3];
		int temp_index = 0;

		for (int i = 0; i < 3; i++) {
			max = score.get(0);
			temp_index = 0;

			for (int j = 1; j < score.size(); j++) {
				if (score.get(j) > max) {
					temp_index = j;
					max = score.get(j);
				}
			}

			max_index[i] = temp_index;

			score.add(temp_index, 0.0);

		}

		System.out.println("3가지를 추천합니다");
		for (int i = 0; i < 3; i++) {

			this.PlanList.add(PlanList.get(max_index[i]));
			PlanList.get(max_index[i]).simple_print();
		}

		System.out.println("추천받은 요금제의 세부사항을 보고싶으시다면 '보기'를, 원하지 않으시면 '종료'를 입력해 주세요.");
		String isdetail;
		Scanner keyboard = new Scanner(System.in);
		isdetail = keyboard.next();

		while (!isdetail.equals("종료")) {

			if (isdetail.equals("보기")) {
				for (int i = 0; i < 3; i++) {
					PlanList.get(max_index[i]).detail();
				}
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				isdetail = keyboard.next();
			}

		}
	}

}
