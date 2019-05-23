package javaCode;
import java.util.*;
import java.io.*;

public class ReviewManager {


	public ReviewManager() {
	}

	public void AddReview(String model, String review) {
		String str = new String();

		str = model + ' ' + review;

		try {
			FileWriter filewriter = new FileWriter("review.txt", true);
			BufferedWriter out = new BufferedWriter(filewriter);
			out.newLine();
			out.append(str);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void PrintReview(String TargetModelName) {

		Scanner fileIn = null;

		try {
			fileIn = new Scanner(new FileInputStream("review.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("review file open error");
			System.exit(0);
		}

		while (fileIn.hasNext()) {
			String name = fileIn.next();
			String review = fileIn.nextLine();

			if (name.equals(TargetModelName)) {
				System.out.println(review);
			}
		}
	}
}
