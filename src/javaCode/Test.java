<<<<<<< HEAD:src/Test.java
import java.util.*;
import java.io.*;

public class Test {

	public static void main(String[] args) {
		int k = 0;

		Admin admin;
		Scanner adminfile = null;

		try {
			adminfile = new Scanner(new FileInputStream("admin.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File open error");
			System.exit(0);
		}

		String admin_id, admin_pw;
		admin_id = adminfile.next();
		admin_pw = adminfile.next();

		admin = new Admin(admin_id, admin_pw);

		ArrayList<Model> ModelList = new ArrayList<Model>();
		String line;
		Scanner ModelIn = null;
		int i;
		try {
			ModelIn = new Scanner(new FileInputStream("model.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File open error");
			System.exit(0);
		}

		while (ModelIn.hasNext()) {
			line = ModelIn.nextLine();
			String[] split = line.split("\t");
			Model m = new Model(split[0], split[1], Integer.parseInt(split[2]),Double.parseDouble(split[3]), split[4], Integer.parseInt(split[5]), Integer.parseInt(split[6]),
					Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), split[10] , Integer.parseInt(split[11]),split[12],split[13],
					Integer.parseInt(split[14]),split[15],split[16],Integer.parseInt(split[17]));
			
			ModelList.add(m);
		}
		ModelIn.close();

		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		int suc = 0;
		Scanner customerfile = null;
		try {
			customerfile = new Scanner(new FileInputStream("custom.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (customerfile.hasNext()) {
			line = customerfile.nextLine();
			String[] split = line.split(" ");
			String temp = null;
			Customer customer = new Customer(split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
			customerlist.add(customer);			
		}

		customerfile.close();

		ArrayList<Plan> PlanList = new ArrayList<Plan>();
		Scanner planfile = null;
		try {
			planfile = new Scanner(new FileInputStream("plan.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (planfile.hasNext()) {
			String temp = null;
			line = planfile.nextLine();
			String[] split = line.split("\t");
			Plan p = new Plan(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]),
					Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7], split[8],
					split[9], split[10], Integer.parseInt(split[11]));
			PlanList.add(p);
		}
		planfile.close();

		System.out.println("---------- 어서오세요 휴대폰, 요금제 추천 시스템 호갱방지입니다  원하는 메뉴를 입력해 주세요 ----------");

		int j = 0;

		for (; j == 0;) {
			System.out.println(
					"로그인을 원하시면   \"로그인 \" 을  회원가입을 원하시면     \"회원가입\" 요금제 검색을 원하면 \"요금제검색\" 모델 검색을 원하면 \"모델검색\"  을   입력해주세요 띄어쓰기에 주의해주세요");
			String str;
			Scanner a = new Scanner(System.in);
			str = a.nextLine();

			if (str.equals("회원가입")) // customer 를 생성하는것
			{
				System.out.println("회원가입 메뉴에 접속하셨습니다");
				System.out.print("ID 를 입력하세요  : ");
				String str2;
				str2 = a.nextLine();
				for (i = 0; i < customerlist.size(); i++) {

					if (str2.equals(customerlist.get(i).getID())) {
						System.out.println("중복된 아이디가 있습니다 . 다른 id를 입력해주세요");
						i = customerlist.size();
						break;
					} else if (i == customerlist.size() - 1) {

						System.out.println("사용 가능한 id입니다 .");
						Customer newcustomer = new Customer();
						newcustomer.setID(str2);

						System.out.println("비밀번호를 입력해주세요.");
						str2 = a.nextLine();
						newcustomer.setpassword(str2);

						System.out.println("이름을 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setname(str2);

						System.out.println("나이를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setage(str2);

						System.out.println("전화번호를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setphone_number(str2);

						System.out.println("이메일 주소를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setemail_address(str2);

						System.out.println("성별을 입력해 주세요 . 남자면 '남' 여자면 '여'를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setsex(str2);

						System.out.println("사용중인 제품에 대한 리뷰를 작성해주셔야 회원가입이 완료됩니다.");
						System.out.println("사용중인 제품명을 입력해 주세요(없는 경우 '없음' 입력).");
						String using = a.next();
						if (using.equals("없음")) {
						} else {
							System.out.println("리뷰를 입력해 주세요.");
							String newreview = a.nextLine();
							ReviewManager reviewManager = new ReviewManager();
							reviewManager.AddReview(using, newreview);
						}

						customerlist.add(newcustomer);
						str2 = newcustomer.getname() + ' ' + newcustomer.getID() + ' ' + newcustomer.getpassword() + ' '
								+ newcustomer.getsex() + ' ' + newcustomer.getage() + ' '
								+ newcustomer.getemail_address() + ' ' + newcustomer.getphone_number();

						try {
							FileWriter filewriter = new FileWriter("custom.txt", true);

							BufferedWriter out = new BufferedWriter(filewriter);
							out.newLine();

							out.append(str2);
							out.close();
							System.out.println("회원가입 완료되었습니다 ");
							break;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			} else if (str.equals("로그인")) // 고객리스트와 비교해서 회원정보가 있으면 로그인성공!
			{
				System.out.println("로그인 메뉴에 접속하셨습니다");
				System.out.println("아이디를 입력해 주세요 ");
				String inputID = new String();
				String inputPW = new String();
				Scanner keyboard = new Scanner(System.in);
				inputID = keyboard.nextLine(); // 아이디입력받음 ->중복검사후 비밀번호와 비교!

				for (k = 0; k < customerlist.size(); k++) {
					if (inputID.equals(customerlist.get(k).getID())) {
						suc = 1;
						System.out.println("비밀번호를 입력하세요");
						inputPW = keyboard.next();
						if (inputPW.equals(customerlist.get(k).getpassword())) {
							suc = 2; // 로그인 성공
							break;
						}
					}
				}
				if (inputID.equals(admin_id)) {
					System.out.println("비밀번호를 입력하세요");
					inputPW = keyboard.next();
				}

				if (suc == 0) {
					if (admin.Login(inputID, inputPW)) {
						System.out.println("관리자로 로그인 하셨습니다. 관리자 메뉴로 이동합니다.");
						suc = 3;
						break;
					} else {
						System.out.println("ID 없음 , 로그인에 실패했습니다 . ");

					}
				} else if (suc == 1) {
					System.out.println("password 없음 , 로그인에 실패했습니다.");

				} else if (suc == 2) {
					System.out.println("로그인 성공 .");
					break;
				}

			} else if (str.equals("요금제검색")) {
				System.out.println("요금제 검색 메뉴에 접속하셨습니다");
				j = 3;
				break;
			} else if (str.equals("모델검색")) {
				System.out.println("모델검색 메뉴에 접속하셨습니다");
				j = 2;
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택하셨습니다 다시 입력해주세요 . 띄어쓰기에 주의해 주세요");

			}
		}

		if (suc == 2) {
			System.out.println("원하는 메뉴를 선택해주세요 . 1.휴대폰 추천 받기 , 2.요금제 추천 받기 , 3.제품 조회 , 4.회원정보 수정 , 5.회원 탈퇴");
			Scanner in = new Scanner(System.in);
			int menu;

			menu = in.nextInt();
			if (menu == 1) { // 휴대폰 추천받기
				Scanner keyboard = new Scanner(System.in);

				System.out.println("휴대폰 추천받기 메뉴 입니다.");
				System.out.println("원하는 제조사를 선택하세요.");
				System.out.println("1.애플  2.삼성  3.LG 4.기타 ");
				String wantmanufacture;
				wantmanufacture = keyboard.nextLine();
				String[] manu_split = wantmanufacture.split(" ");

				System.out.println("원하는 가격대를 입력해 주세요");
				System.out.println(
						"1. 0~10만원  2. 10~20만원  3. 30~40만원  5. 40~50만원  6. 50~60만원  7. 60~70만원  8. 70~80만원  9. 80~90만원  10. 90~100만원  11. 100~110만원  12. 110~120만원  13. 120~130만원  14. 130~140만원  15. 140~150만원  16. 150만원 이상");

				String wantprice;
				wantprice = keyboard.nextLine();
				String[] price_split = wantprice.split(" ");

				System.out.println("희망 사용 목적 및 원하는 기능을 입력해 주세요");
				System.out.println("1. 홈버튼 필요  2. 고사양 게임  3. 대용량 배터리  4. 고성능 카메라  5. 큰 화면  6. 대용량 메모리  7. 고화질 동영상");

				String wantfunction;
				wantfunction = keyboard.nextLine();
				String[] function_split = wantfunction.split(" ");

				customerlist.get(k).recommand_Models(manu_split, price_split, function_split, customerlist.get(k),
						ModelList);

			} else if (menu == 2) {
				Scanner keyboard = new Scanner(System.in);
				System.out.println("요금제 추천받기 메뉴 입니다.");
				System.out.println("원하는 통신사를 선택하세요.");
				System.out.println("1.SKT  2.KT  3.U+ ");
				String wantmanufacture;
				wantmanufacture = keyboard.nextLine();
				String[] manu_split = wantmanufacture.split(" ");

				System.out.println("데이터 사용량을 선택하세요");
				System.out.println(
						"1. 0~1GB  2. 1~2GB  3. 2~3GB  4. 3~4GB  5. 4~5GB  6. 5~6GB  7. 6~7GB  8. 7~8GB  9. 8~9GB  10. 9~10GB  11. 10GB이상");
				String wantdata;
				wantdata = keyboard.nextLine();
				String[] data_split = wantdata.split(" ");

				System.out.println("전화 사용량을 선택하세요");
				System.out.println(
						"1. 0~50분  2. 50~100분  3. 100~150분  4. 150~200분  5. 200~250분  6. 250~300분  7. 300~350분  8. 350~400분  9. 400~450분  10. 450~500분  11. 500분이상");
				String wantcalling;
				wantcalling = keyboard.nextLine();
				String[] calling_split = wantcalling.split(" ");

				System.out.println("문자 사용량을 선택하세요");
				System.out.println(
						"1. 0~50통  2. 50~100통  3. 100~150통  4. 150~200통  5. 200~250통  6. 250~300통  7. 300~350통  8. 350~400통  9. 400~450통  10. 450~500통  11. 500통이상");
				String wantmessage;
				wantmessage = keyboard.nextLine();
				String[] message_split = wantmessage.split(" ");

				customerlist.get(k).recommand_Plans(manu_split, data_split, calling_split, message_split,customerlist.get(k), PlanList);

			} // 요금제 추천 받기

			else if (menu == 3) {
				String select;
				System.out.println("1.모델 조회, 2.요금제 조회");
				select = in.next();
				if (select.equals("모델조회") || select.equals("모델 조회") || select.equals("1")) {
					view_model(ModelList);
				} else if (select.equals("요금제조회") || select.equals("요금제 조회") || select.equals("2")) {
					view_plan(PlanList);
				}
			} // 제품 조회

			else if (menu == 4) {// 회원정보 수정

				System.out.println("수정하고 싶은 정보를 선택해주세요");
				System.out.println("1.이름, 2.PASSWORD, 3.성별, 4.나이, 5.메일주소, 6.연락처");
				int menu2 = in.nextInt();

				if (menu2 == 1) {
					System.out.println("이름 수정을 선택하였습니다. 바꾸실 이름을 입력해 주세요");
				} // 이름 수정
				else if (menu2 == 2) {
					System.out.println("비밀번호 수정을 선택하였습니다. 바꾸실 비밀번호를 입력해 주세요");
				} // 비번 수정
				else if (menu2 == 3) {
					System.out.println("성별 수정을 선택하였습니다. 바꾸실 성별을 입력해 주세요");
				} // 성별 수정
				else if (menu2 == 4) {
					System.out.println("나이 수정을 선택하였습니다. 바꾸실 나이를 입력해 주세요");
				} // 나이 수정
				else if (menu2 == 5) {
					System.out.println("메일주소 수정을 선택하였습니다. 바꾸실 메일주소를 입력해 주세요");
				} // 주소 수정
				else if (menu2 == 6) {
					System.out.println("연락처 수정을 선택하였습니다. 바꾸실 연락처를 입력해 주세요");
				} // 연락처 수정
				String newstring = in.next();
				Customer temp;
				temp = customerlist.get(k);
				temp.modify(customerlist, newstring, k, menu2);
				System.out.println("수정완료");

			} else if (menu == 5) {// 회원탈퇴
				Scanner keyboard = new Scanner(System.in);
				System.out.println("회원 탈퇴를 원하시면 비밀번호를 한번 더 입력해 주십시오.");
				String pw;
				Customer Removing;
				Removing = customerlist.get(k);
				pw = keyboard.next();
				if (pw.equals(Removing.getpassword())) {
					Removing.remove_member(customerlist, k);
					System.out.println("탈퇴완료");
				}
			} else {
				System.out.println("비밀번호가 틀렸습니다. 프로그램을 종료합니다.");
				System.exit(1);
			}
		} else if (suc == 3) {// 관리자
			String admin_menu;

			System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
			System.out.println("1.모델추가, 2.요금제추가, 3.모델삭제, 4.요금제삭제");

			Scanner keyboard = new Scanner(System.in);

			admin_menu = keyboard.next();

			if (admin_menu.equals("1")) {
				// 모델 추가
				int price, camera_front, storage, ram, camera_back, weight, battery;
				String name, manufacture, os, led, cpu_name;
				boolean home;
				double size, cpu_rate;

				System.out.println("모델 추가 메뉴입니다.");
				System.out.println("추가하려는 모델의 정보를 입력합니다.");
				System.out.println("가격 : ");
				price = keyboard.nextInt();

				System.out.println("전면 카메라 화소 : ");
				camera_front = keyboard.nextInt();

				System.out.println("cpu rate : ");
				cpu_rate = keyboard.nextDouble();

				System.out.println("저장소 용량 : ");
				storage = keyboard.nextInt();

				System.out.println("램 사양: ");
				ram = keyboard.nextInt();

				System.out.println("후면 카메라 화소 : ");
				camera_back = keyboard.nextInt();

				System.out.println("무게 : ");
				weight = keyboard.nextInt();

				System.out.println("배터리 : ");
				battery = keyboard.nextInt();
				keyboard.nextLine();

				System.out.println("모델 이름 : ");
				name = keyboard.nextLine();

				System.out.println("제조사 : ");
				manufacture = keyboard.nextLine();

				System.out.println("os : ");
				os = keyboard.nextLine();

				System.out.println("led : ");
				led = keyboard.nextLine();

				System.out.println("cpu name : ");
				cpu_name = keyboard.nextLine();

				System.out.println("홈버튼 유뮤(있으면 1, 없으면 0): ");
				String temp;
				temp = keyboard.next();
				if (temp.equals("1")) {
					home = true;
				} else {
					home = false;
				}

				System.out.println("사이즈 : ");
				size = keyboard.nextDouble();
/*
				Model NewModel = new Model(name, manufacture, cpu_name, size, os, price, storage, ram, camera_front,
						camera_back, weight, battery, cpu_rate, led, home);

				if (admin.AddModel(NewModel, ModelList)) {
					System.out.println("추가완료");
				} else {
					System.out.println("이미 존재하는 모델입니다");
					System.exit(0);
				}
*/
			} else if (admin_menu.equals("2")) {// 요금제 추가
				System.out.println("요금제 추가 메뉴입니다.");
				System.out.println("추가하려는 모델의 정보를 입력합니다.");
				int price, max_age, message;
				String name;
				double data;
				int calling;
				String detail_message, detail_calling, detail_data, detail_etc1, detail_etc2;
				String telecom;

				System.out.println("통신사 : ");
				telecom = keyboard.next();
				keyboard.nextLine();

				System.out.println("이름 : ");
				name = keyboard.nextLine();

				System.out.println("제한 나이(없으면  0) : ");
				max_age = keyboard.nextInt();

				System.out.println("전화량 : ");
				calling = keyboard.nextInt();

				System.out.println("가격 : ");
				price = keyboard.nextInt();

				System.out.println("데이터 량 : ");
				data = keyboard.nextDouble();
				keyboard.nextLine();

				System.out.println("데이터 세부정보 : ");
				detail_data = keyboard.nextLine();

				System.out.println("전화 세부정보 : ");
				detail_calling = keyboard.nextLine();

				System.out.println("문자량 : ");
				message = keyboard.nextInt();
				keyboard.nextLine();

				System.out.println("문자 세부정보 : ");
				detail_message = keyboard.nextLine();

				System.out.println("특이사항1 (없으면 X): ");
				detail_etc1 = keyboard.nextLine();

				System.out.println("특이사항2 (없으면 X) : ");
				detail_etc2 = keyboard.nextLine();

				Plan NewPlan = new Plan(name, max_age, data, calling, price, detail_data, detail_calling,
						detail_message, telecom, detail_etc1, detail_etc2, message);

				if (admin.AddPlan(NewPlan, PlanList)) {
					System.out.println("추가완료");
				} else {
					System.out.println("이미 존재하는 요금제 입니다");
					System.exit(0);
				}

			} else if (admin_menu.equals("3")) { // 모델 삭제
				System.out.println("모델 삭제 메뉴입니다. 삭제할 모델의 이름을 입력해주세요");
				String target;
				keyboard.nextLine();
				target = keyboard.nextLine();
				if (admin.RemoveModel(target, ModelList)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패 : 없는 모델 입니다.");
					System.exit(0);
				}
			} else if (admin_menu.equals("4")) { // 요금제 삭제
				System.out.println("요금제 삭제 메뉴입니다. 삭제할 요금제의 이름을 입력해주세요");
				String target_name;
				keyboard.nextLine();
				target_name = keyboard.nextLine();
				System.out.println("삭제할 요금제의 통신사를 입력해 주세요");
				String target_telecom;
				target_telecom = keyboard.nextLine();

				if (admin.RemovePlan(target_telecom, target_name, PlanList)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패 : 없는 요금제 입니다.");
					System.exit(0);
				}
			}
		}

		if (j == 2) // 모델 검색
		{
			view_model(ModelList);
		} else if (j == 3) // 요금제 검색

		{
			view_plan(PlanList);

		}
	}

	private static void view_model(ArrayList<Model> ModelList) {
		int min = 0, max = 0;// 받아와야함.
		String select;
		String manufacture;
		Customer c = new Customer();
		Scanner in = new Scanner(System.in);

		System.out.println("1.전체출력   2.조건검색");
		select = in.next();

		if (select.equals("전체출력") || select.equals("1"))
			print_model_all(ModelList);
		else {
			manufacture = print_model_manufacture();
			min = min_model_pricelist();
			max = max_model_pricelist();
			c.search_model(manufacture, min, max); // 제조사이름, min 가격, max가격
		} // 넣으면 출력하는 함수
	}

	private static void view_plan(ArrayList<Plan> PlanList) {
		int call_min, call_max, price_min, price_max;
		double data_min, data_max;
		String plan_input, telecom;
		System.out.println("1.전체조회 2.조건 검색");
		Customer c = new Customer();
		Scanner in = new Scanner(System.in);
		plan_input = in.next();
		if (plan_input.equals("전체조회") || plan_input.equals("전체 조회") || plan_input.equals("1"))
			print_plan_all(PlanList);
		else if (plan_input.equals("조건검색") || plan_input.equals("조건 검색") || plan_input.equals("2")) {

			telecom = print_telecom();
			data_min = min_plan_data();
			data_max = max_plan_data();
			call_min = min_plan_call();
			call_max = max_plan_call();
			price_min = min_plan_price();
			price_max = max_plan_price();
			c.search_plan(telecom, data_min, data_max, call_min, call_max, price_min, price_max);
		}
	}

	private static void print_model_all(ArrayList<Model> modellist) {

		int i;
		for (i = 0; i < modellist.size(); i++) {
			modellist.get(i).detail();
		}

	}

	private static String print_telecom() {
		System.out.println("조회하실 통신사를 입력하세요.");
		System.out.println("1.SKT   2.KT   3.U+");
		Scanner in = new Scanner(System.in);
		String input;
		input = in.next();
		if (input.equals("1"))
			input = "SKT";
		if (input.equals("2"))
			input = "KT";
		if (input.equals("3"))
			input = "U+";

		return input;
	}

	private static int min_plan_price() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 가격을 입력하세요. (원)");
		min = in.nextInt();
		return min;
	}

	private static int max_plan_price() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 가격을 입력하세요. (원)");
		input = in.next();
		if (input.equals("무한대"))
			return 99999;
		max = Integer.parseInt(input);
		return max;
	}

	private static int max_plan_call() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 전화량을 입력하세요. (분) or 무한대");
		input = in.next();
		if (input.equals("무한대"))
			return 99999;
		max = Integer.parseInt(input);
		return max;
	}

	private static int min_plan_call() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 전화량을 입력하세요. (분)");
		min = in.nextInt();
		return min;
	}

	private static double max_plan_data() {
		double max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 데이터을 입력하세요. (단위 : GB) or 무한대");
		input = in.next();
		if (input.equals("무한대"))
			return 999;
		max = Integer.parseInt(input);
		return max;
	}

	private static double min_plan_data() {
		double min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 데이터을 입력하세요. (GB)");
		min = in.nextDouble();
		return min;
	}

	private static String print_model_manufacture() {
		System.out.println("조회하실 제조사를 입력하세요.");
		System.out.println("1.삼성   2.Apple   3.LG   4.기타");
		Scanner in = new Scanner(System.in);
		String input;
		input = in.next();
		return input;
	}

	private static int min_model_pricelist() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 가격을 입력하세요.");
		min = in.nextInt();
		return min;
	}

	private static int max_model_pricelist() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 가격을 입력하세요. (단위:원 or 무한대)");
		input = in.next();
		if (input.equals("무한대"))
			return 999;
		max = Integer.parseInt(input);
		return max;
	}

	private static void print_plan_all(ArrayList<Plan> planlist) {

		int i;
		for (i = 0; i < planlist.size(); i++) {
			planlist.get(i).detail();
		}

	}
=======
package javaCode;
import java.util.*;
import java.io.*;

public class Test {

	public static void main(String[] args) {
		int k = 0;

		Admin admin;
		Scanner adminfile = null;

		try {
			adminfile = new Scanner(new FileInputStream("admin.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File open error");
			System.exit(0);
		}

		String admin_id, admin_pw;
		admin_id = adminfile.next();
		admin_pw = adminfile.next();

		admin = new Admin(admin_id, admin_pw);

		ArrayList<Model> ModelList = new ArrayList<Model>();
		String line;
		Scanner ModelIn = null;
		int i;
		try {
			ModelIn = new Scanner(new FileInputStream("model.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File open error");
			System.exit(0);
		}

		while (ModelIn.hasNext()) {
			line = ModelIn.nextLine();
			String[] split = line.split("\t");
			Model m = new Model(split[0], split[1], split[2],Double.parseDouble(split[4]), split[5], Integer.parseInt(split[3]), Integer.parseInt(split[6]),
					Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), Integer.parseInt(split[10]), Integer.parseInt(split[11]),Double.parseDouble(split[12]),split[13],
					false);
			if (split[14].equals("x"))
				m.setHome(false);
			else
				m.setHome(true);
			ModelList.add(m);
		}
		ModelIn.close();

		ArrayList<Customer> customerlist = new ArrayList<Customer>();
		int suc = 0;
		Scanner customerfile = null;
		try {
			customerfile = new Scanner(new FileInputStream("custom.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (customerfile.hasNext()) {
			line = customerfile.nextLine();
			String[] split = line.split(" ");
			String temp = null;
			Customer customer = new Customer(split[0], split[1], split[2], split[3], split[4], split[5], split[6]);
			customerlist.add(customer);			
		}

		customerfile.close();

		ArrayList<Plan> PlanList = new ArrayList<Plan>();
		Scanner planfile = null;
		try {
			planfile = new Scanner(new FileInputStream("plan.txt"));

		} catch (FileNotFoundException e) {
			System.out.println("File open error");
		}

		while (planfile.hasNext()) {
			String temp = null;
			line = planfile.nextLine();
			String[] split = line.split("\t");
			Plan p = new Plan(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]),
					Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5], split[6], split[7], split[8],
					split[9], split[10], Integer.parseInt(split[11]));
			PlanList.add(p);
		}
		planfile.close();

		System.out.println("---------- 어서오세요 휴대폰, 요금제 추천 시스템 호갱방지입니다  원하는 메뉴를 입력해 주세요 ----------");

		int j = 0;

		for (; j == 0;) {
			System.out.println(
					"로그인을 원하시면   \"로그인 \" 을  회원가입을 원하시면     \"회원가입\" 요금제 검색을 원하면 \"요금제검색\" 모델 검색을 원하면 \"모델검색\"  을   입력해주세요 띄어쓰기에 주의해주세요");
			String str;
			Scanner a = new Scanner(System.in);
			str = a.nextLine();

			if (str.equals("회원가입")) // customer 를 생성하는것
			{
				System.out.println("회원가입 메뉴에 접속하셨습니다");
				System.out.print("ID 를 입력하세요  : ");
				String str2;
				str2 = a.nextLine();
				for (i = 0; i < customerlist.size(); i++) {

					if (str2.equals(customerlist.get(i).getID())) {
						System.out.println("중복된 아이디가 있습니다 . 다른 id를 입력해주세요");
						i = customerlist.size();
						break;
					} else if (i == customerlist.size() - 1) {

						System.out.println("사용 가능한 id입니다 .");
						Customer newcustomer = new Customer();
						newcustomer.setID(str2);

						System.out.println("비밀번호를 입력해주세요.");
						str2 = a.nextLine();
						newcustomer.setpassword(str2);

						System.out.println("이름을 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setname(str2);

						System.out.println("나이를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setage(str2);

						System.out.println("전화번호를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setphone_number(str2);

						System.out.println("이메일 주소를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setemail_address(str2);

						System.out.println("성별을 입력해 주세요 . 남자면 '남' 여자면 '여'를 입력해 주세요");
						str2 = a.nextLine();
						newcustomer.setsex(str2);

						System.out.println("사용중인 제품에 대한 리뷰를 작성해주셔야 회원가입이 완료됩니다.");
						System.out.println("사용중인 제품명을 입력해 주세요(없는 경우 '없음' 입력).");
						String using = a.next();
						if (using.equals("없음")) {
						} else {
							System.out.println("리뷰를 입력해 주세요.");
							String newreview = a.nextLine();
							ReviewManager reviewManager = new ReviewManager();
							reviewManager.AddReview(using, newreview);
						}

						customerlist.add(newcustomer);
						str2 = newcustomer.getname() + ' ' + newcustomer.getID() + ' ' + newcustomer.getpassword() + ' '
								+ newcustomer.getsex() + ' ' + newcustomer.getage() + ' '
								+ newcustomer.getemail_address() + ' ' + newcustomer.getphone_number();

						try {
							FileWriter filewriter = new FileWriter("custom.txt", true);

							BufferedWriter out = new BufferedWriter(filewriter);
							out.newLine();

							out.append(str2);
							out.close();
							System.out.println("회원가입 완료되었습니다 ");
							break;
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}

			} else if (str.equals("로그인")) // 고객리스트와 비교해서 회원정보가 있으면 로그인성공!
			{
				System.out.println("로그인 메뉴에 접속하셨습니다");
				System.out.println("아이디를 입력해 주세요 ");
				String inputID = new String();
				String inputPW = new String();
				Scanner keyboard = new Scanner(System.in);
				inputID = keyboard.nextLine(); // 아이디입력받음 ->중복검사후 비밀번호와 비교!

				for (k = 0; k < customerlist.size(); k++) {
					if (inputID.equals(customerlist.get(k).getID())) {
						suc = 1;
						System.out.println("비밀번호를 입력하세요");
						inputPW = keyboard.next();
						if (inputPW.equals(customerlist.get(k).getpassword())) {
							suc = 2; // 로그인 성공
							break;
						}
					}
				}
				if (inputID.equals(admin_id)) {
					System.out.println("비밀번호를 입력하세요");
					inputPW = keyboard.next();
				}

				if (suc == 0) {
					if (admin.Login(inputID, inputPW)) {
						System.out.println("관리자로 로그인 하셨습니다. 관리자 메뉴로 이동합니다.");
						suc = 3;
						break;
					} else {
						System.out.println("ID 없음 , 로그인에 실패했습니다 . ");

					}
				} else if (suc == 1) {
					System.out.println("password 없음 , 로그인에 실패했습니다.");

				} else if (suc == 2) {
					System.out.println("로그인 성공 .");
					break;
				}

			} else if (str.equals("요금제검색")) {
				System.out.println("요금제 검색 메뉴에 접속하셨습니다");
				j = 3;
				break;
			} else if (str.equals("모델검색")) {
				System.out.println("모델검색 메뉴에 접속하셨습니다");
				j = 2;
				break;
			} else {
				System.out.println("잘못된 메뉴를 선택하셨습니다 다시 입력해주세요 . 띄어쓰기에 주의해 주세요");

			}
		}

		if (suc == 2) {
			System.out.println("원하는 메뉴를 선택해주세요 . 1.휴대폰 추천 받기 , 2.요금제 추천 받기 , 3.제품 조회 , 4.회원정보 수정 , 5.회원 탈퇴");
			Scanner in = new Scanner(System.in);
			int menu;

			menu = in.nextInt();
			if (menu == 1) { // 휴대폰 추천받기
				Scanner keyboard = new Scanner(System.in);

				System.out.println("휴대폰 추천받기 메뉴 입니다.");
				System.out.println("원하는 제조사를 선택하세요.");
				System.out.println("1.애플  2.삼성  3.LG 4.기타 ");
				String wantmanufacture;
				wantmanufacture = keyboard.nextLine();
				String[] manu_split = wantmanufacture.split(" ");

				System.out.println("원하는 가격대를 입력해 주세요");
				System.out.println(
						"1. 0~10만원  2. 10~20만원  3. 30~40만원  5. 40~50만원  6. 50~60만원  7. 60~70만원  8. 70~80만원  9. 80~90만원  10. 90~100만원  11. 100~110만원  12. 110~120만원  13. 120~130만원  14. 130~140만원  15. 140~150만원  16. 150만원 이상");

				String wantprice;
				wantprice = keyboard.nextLine();
				String[] price_split = wantprice.split(" ");

				System.out.println("희망 사용 목적 및 원하는 기능을 입력해 주세요");
				System.out.println("1. 홈버튼 필요  2. 고사양 게임  3. 대용량 배터리  4. 고성능 카메라  5. 큰 화면  6. 대용량 메모리  7. 고화질 동영상");

				String wantfunction;
				wantfunction = keyboard.nextLine();
				String[] function_split = wantfunction.split(" ");

				customerlist.get(k).recommand_Models(manu_split, price_split, function_split, customerlist.get(k),
						ModelList);

			} else if (menu == 2) {
				Scanner keyboard = new Scanner(System.in);
				System.out.println("요금제 추천받기 메뉴 입니다.");
				System.out.println("원하는 통신사를 선택하세요.");
				System.out.println("1.SKT  2.KT  3.U+ ");
				String wantmanufacture;
				wantmanufacture = keyboard.nextLine();
				String[] manu_split = wantmanufacture.split(" ");

				System.out.println("데이터 사용량을 선택하세요");
				System.out.println(
						"1. 0~1GB  2. 1~2GB  3. 2~3GB  4. 3~4GB  5. 4~5GB  6. 5~6GB  7. 6~7GB  8. 7~8GB  9. 8~9GB  10. 9~10GB  11. 10GB이상");
				String wantdata;
				wantdata = keyboard.nextLine();
				String[] data_split = wantdata.split(" ");

				System.out.println("전화 사용량을 선택하세요");
				System.out.println(
						"1. 0~50분  2. 50~100분  3. 100~150분  4. 150~200분  5. 200~250분  6. 250~300분  7. 300~350분  8. 350~400분  9. 400~450분  10. 450~500분  11. 500분이상");
				String wantcalling;
				wantcalling = keyboard.nextLine();
				String[] calling_split = wantcalling.split(" ");

				System.out.println("문자 사용량을 선택하세요");
				System.out.println(
						"1. 0~50통  2. 50~100통  3. 100~150통  4. 150~200통  5. 200~250통  6. 250~300통  7. 300~350통  8. 350~400통  9. 400~450통  10. 450~500통  11. 500통이상");
				String wantmessage;
				wantmessage = keyboard.nextLine();
				String[] message_split = wantmessage.split(" ");

				customerlist.get(k).recommand_Plans(manu_split, data_split, calling_split, message_split,customerlist.get(k), PlanList);

			} // 요금제 추천 받기

			else if (menu == 3) {
				String select;
				System.out.println("1.모델 조회, 2.요금제 조회");
				select = in.next();
				if (select.equals("모델조회") || select.equals("모델 조회") || select.equals("1")) {
					view_model(ModelList);
				} else if (select.equals("요금제조회") || select.equals("요금제 조회") || select.equals("2")) {
					view_plan(PlanList);
				}
			} // 제품 조회

			else if (menu == 4) {// 회원정보 수정

				System.out.println("수정하고 싶은 정보를 선택해주세요");
				System.out.println("1.이름, 2.PASSWORD, 3.성별, 4.나이, 5.메일주소, 6.연락처");
				int menu2 = in.nextInt();

				if (menu2 == 1) {
					System.out.println("이름 수정을 선택하였습니다. 바꾸실 이름을 입력해 주세요");
				} // 이름 수정
				else if (menu2 == 2) {
					System.out.println("비밀번호 수정을 선택하였습니다. 바꾸실 비밀번호를 입력해 주세요");
				} // 비번 수정
				else if (menu2 == 3) {
					System.out.println("성별 수정을 선택하였습니다. 바꾸실 성별을 입력해 주세요");
				} // 성별 수정
				else if (menu2 == 4) {
					System.out.println("나이 수정을 선택하였습니다. 바꾸실 나이를 입력해 주세요");
				} // 나이 수정
				else if (menu2 == 5) {
					System.out.println("메일주소 수정을 선택하였습니다. 바꾸실 메일주소를 입력해 주세요");
				} // 주소 수정
				else if (menu2 == 6) {
					System.out.println("연락처 수정을 선택하였습니다. 바꾸실 연락처를 입력해 주세요");
				} // 연락처 수정
				String newstring = in.next();
				Customer temp;
				temp = customerlist.get(k);
				temp.modify(customerlist, newstring, k, menu2);
				System.out.println("수정완료");

			} else if (menu == 5) {// 회원탈퇴
				Scanner keyboard = new Scanner(System.in);
				System.out.println("회원 탈퇴를 원하시면 비밀번호를 한번 더 입력해 주십시오.");
				String pw;
				Customer Removing;
				Removing = customerlist.get(k);
				pw = keyboard.next();
				if (pw.equals(Removing.getpassword())) {
					Removing.remove_member(customerlist, k);
					System.out.println("탈퇴완료");
				}
			} else {
				System.out.println("비밀번호가 틀렸습니다. 프로그램을 종료합니다.");
				System.exit(1);
			}
		} else if (suc == 3) {// 관리자
			String admin_menu;

			System.out.println("원하시는 메뉴의 번호를 입력해주세요.");
			System.out.println("1.모델추가, 2.요금제추가, 3.모델삭제, 4.요금제삭제");

			Scanner keyboard = new Scanner(System.in);

			admin_menu = keyboard.next();

			if (admin_menu.equals("1")) {
				// 모델 추가
				int price, camera_front, storage, ram, camera_back, weight, battery;
				String name, manufacture, os, led, cpu_name;
				boolean home;
				double size, cpu_rate;

				System.out.println("모델 추가 메뉴입니다.");
				System.out.println("추가하려는 모델의 정보를 입력합니다.");
				System.out.println("가격 : ");
				price = keyboard.nextInt();

				System.out.println("전면 카메라 화소 : ");
				camera_front = keyboard.nextInt();

				System.out.println("cpu rate : ");
				cpu_rate = keyboard.nextDouble();

				System.out.println("저장소 용량 : ");
				storage = keyboard.nextInt();

				System.out.println("램 사양: ");
				ram = keyboard.nextInt();

				System.out.println("후면 카메라 화소 : ");
				camera_back = keyboard.nextInt();

				System.out.println("무게 : ");
				weight = keyboard.nextInt();

				System.out.println("배터리 : ");
				battery = keyboard.nextInt();
				keyboard.nextLine();

				System.out.println("모델 이름 : ");
				name = keyboard.nextLine();

				System.out.println("제조사 : ");
				manufacture = keyboard.nextLine();

				System.out.println("os : ");
				os = keyboard.nextLine();

				System.out.println("led : ");
				led = keyboard.nextLine();

				System.out.println("cpu name : ");
				cpu_name = keyboard.nextLine();

				System.out.println("홈버튼 유뮤(있으면 1, 없으면 0): ");
				String temp;
				temp = keyboard.next();
				if (temp.equals("1")) {
					home = true;
				} else {
					home = false;
				}

				System.out.println("사이즈 : ");
				size = keyboard.nextDouble();

				Model NewModel = new Model(name, manufacture, cpu_name, size, os, price, storage, ram, camera_front,
						camera_back, weight, battery, cpu_rate, led, home);

				if (admin.AddModel(NewModel, ModelList)) {
					System.out.println("추가완료");
				} else {
					System.out.println("이미 존재하는 모델입니다");
					System.exit(0);
				}

			} else if (admin_menu.equals("2")) {// 요금제 추가
				System.out.println("요금제 추가 메뉴입니다.");
				System.out.println("추가하려는 모델의 정보를 입력합니다.");
				int price, max_age, message;
				String name;
				double data;
				int calling;
				String detail_message, detail_calling, detail_data, detail_etc1, detail_etc2;
				String telecom;

				System.out.println("통신사 : ");
				telecom = keyboard.next();
				keyboard.nextLine();

				System.out.println("이름 : ");
				name = keyboard.nextLine();

				System.out.println("제한 나이(없으면  0) : ");
				max_age = keyboard.nextInt();

				System.out.println("전화량 : ");
				calling = keyboard.nextInt();

				System.out.println("가격 : ");
				price = keyboard.nextInt();

				System.out.println("데이터 량 : ");
				data = keyboard.nextDouble();
				keyboard.nextLine();

				System.out.println("데이터 세부정보 : ");
				detail_data = keyboard.nextLine();

				System.out.println("전화 세부정보 : ");
				detail_calling = keyboard.nextLine();

				System.out.println("문자량 : ");
				message = keyboard.nextInt();
				keyboard.nextLine();

				System.out.println("문자 세부정보 : ");
				detail_message = keyboard.nextLine();

				System.out.println("특이사항1 (없으면 X): ");
				detail_etc1 = keyboard.nextLine();

				System.out.println("특이사항2 (없으면 X) : ");
				detail_etc2 = keyboard.nextLine();

				Plan NewPlan = new Plan(name, max_age, data, calling, price, detail_data, detail_calling,
						detail_message, telecom, detail_etc1, detail_etc2, message);

				if (admin.AddPlan(NewPlan, PlanList)) {
					System.out.println("추가완료");
				} else {
					System.out.println("이미 존재하는 요금제 입니다");
					System.exit(0);
				}

			} else if (admin_menu.equals("3")) { // 모델 삭제
				System.out.println("모델 삭제 메뉴입니다. 삭제할 모델의 이름을 입력해주세요");
				String target;
				keyboard.nextLine();
				target = keyboard.nextLine();
				if (admin.RemoveModel(target, ModelList)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패 : 없는 모델 입니다.");
					System.exit(0);
				}
			} else if (admin_menu.equals("4")) { // 요금제 삭제
				System.out.println("요금제 삭제 메뉴입니다. 삭제할 요금제의 이름을 입력해주세요");
				String target_name;
				keyboard.nextLine();
				target_name = keyboard.nextLine();
				System.out.println("삭제할 요금제의 통신사를 입력해 주세요");
				String target_telecom;
				target_telecom = keyboard.nextLine();

				if (admin.RemovePlan(target_telecom, target_name, PlanList)) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("삭제 실패 : 없는 요금제 입니다.");
					System.exit(0);
				}
			}
		}

		if (j == 2) // 모델 검색
		{
			view_model(ModelList);
		} else if (j == 3) // 요금제 검색

		{
			view_plan(PlanList);

		}
	}

	private static void view_model(ArrayList<Model> ModelList) {
		int min = 0, max = 0;// 받아와야함.
		String select;
		String manufacture;
		Customer c = new Customer();
		Scanner in = new Scanner(System.in);

		System.out.println("1.전체출력   2.조건검색");
		select = in.next();

		if (select.equals("전체출력") || select.equals("1"))
			print_model_all(ModelList);
		else {
			manufacture = print_model_manufacture();
			min = min_model_pricelist();
			max = max_model_pricelist();
			c.search_model(manufacture, min, max); // 제조사이름, min 가격, max가격
		} // 넣으면 출력하는 함수
	}

	private static void view_plan(ArrayList<Plan> PlanList) {
		int call_min, call_max, price_min, price_max;
		double data_min, data_max;
		String plan_input, telecom;
		System.out.println("1.전체조회 2.조건 검색");
		Customer c = new Customer();
		Scanner in = new Scanner(System.in);
		plan_input = in.next();
		if (plan_input.equals("전체조회") || plan_input.equals("전체 조회") || plan_input.equals("1"))
			print_plan_all(PlanList);
		else if (plan_input.equals("조건검색") || plan_input.equals("조건 검색") || plan_input.equals("2")) {

			telecom = print_telecom();
			data_min = min_plan_data();
			data_max = max_plan_data();
			call_min = min_plan_call();
			call_max = max_plan_call();
			price_min = min_plan_price();
			price_max = max_plan_price();
			c.search_plan(telecom, data_min, data_max, call_min, call_max, price_min, price_max);
		}
	}

	private static void print_model_all(ArrayList<Model> modellist) {

		int i;
		for (i = 0; i < modellist.size(); i++) {
			modellist.get(i).detail();
		}

	}

	private static String print_telecom() {
		System.out.println("조회하실 통신사를 입력하세요.");
		System.out.println("1.SKT   2.KT   3.U+");
		Scanner in = new Scanner(System.in);
		String input;
		input = in.next();
		if (input.equals("1"))
			input = "SKT";
		if (input.equals("2"))
			input = "KT";
		if (input.equals("3"))
			input = "U+";

		return input;
	}

	private static int min_plan_price() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 가격을 입력하세요. (원)");
		min = in.nextInt();
		return min;
	}

	private static int max_plan_price() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 가격을 입력하세요. (원)");
		input = in.next();
		if (input.equals("무한대"))
			return 99999;
		max = Integer.parseInt(input);
		return max;
	}

	private static int max_plan_call() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 전화량을 입력하세요. (분) or 무한대");
		input = in.next();
		if (input.equals("무한대"))
			return 99999;
		max = Integer.parseInt(input);
		return max;
	}

	private static int min_plan_call() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 전화량을 입력하세요. (분)");
		min = in.nextInt();
		return min;
	}

	private static double max_plan_data() {
		double max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 데이터을 입력하세요. (단위 : GB) or 무한대");
		input = in.next();
		if (input.equals("무한대"))
			return 999;
		max = Integer.parseInt(input);
		return max;
	}

	private static double min_plan_data() {
		double min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 데이터을 입력하세요. (GB)");
		min = in.nextDouble();
		return min;
	}

	private static String print_model_manufacture() {
		System.out.println("조회하실 제조사를 입력하세요.");
		System.out.println("1.삼성   2.Apple   3.LG   4.기타");
		Scanner in = new Scanner(System.in);
		String input;
		input = in.next();
		return input;
	}

	private static int min_model_pricelist() {
		int min;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최소 가격을 입력하세요.");
		min = in.nextInt();
		return min;
	}

	private static int max_model_pricelist() {
		int max;
		String input;
		Scanner in = new Scanner(System.in);
		System.out.println("조회하실 최대 가격을 입력하세요. (단위:원 or 무한대)");
		input = in.next();
		if (input.equals("무한대"))
			return 999;
		max = Integer.parseInt(input);
		return max;
	}

	private static void print_plan_all(ArrayList<Plan> planlist) {

		int i;
		for (i = 0; i < planlist.size(); i++) {
			planlist.get(i).detail();
		}

	}
>>>>>>> origin/hsy:src/javaCode/Test.java
}