package javaCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String[] cusInfo = new String[7];

		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone_number1 = request.getParameter("phone_number1");
		String phone_number2 = request.getParameter("phone_number2");
		String phone_number3 = request.getParameter("phone_number3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String sex = request.getParameter("sex");

		cusInfo[0] = id;
		cusInfo[1] = password;
		cusInfo[2] = name;
		cusInfo[3] = age;
		cusInfo[4] = phone_number1 + phone_number2 + phone_number3;
		cusInfo[5] = email1 + "@" + email2;
		cusInfo[6] = sex;

		for(int i=0; i<cusInfo.length; i++)
			System.out.println(cusInfo[i]);

		DBTest db = new DBTest();
		db.connectDB();
		db.setCustomerDB(cusInfo);
	}
}
