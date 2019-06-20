package javacode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * Servlet implementation class Recomsmartphone
 */
@WebServlet("/Recomsmartphone")
public class Recomsmartphone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Recomsmartphone() {
		super();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 Logger logger = Logger.getLogger(CustomerControlDB.class.getName());
		   
	       logger.log(Level.INFO, "Start Logging");
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			

       	 logger.log(Level.SEVERE, "error, {0}", e);

		}

		ModelControlDB mdb = new ModelControlDB();
		
		String[] company = request.getParameterValues("company");
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		String[] purpose = request.getParameterValues("purpose");
		Model result[] = {};
		String str[] = {};
		
		
		int minP=0;
		try {
			minP = Integer.parseInt(minPrice) * 10000;
		} catch (NumberFormatException e) {
			

       	 logger.log(Level.SEVERE, "error, {1}", e);
		}
		int maxP=0;
		try {
			maxP = Integer.parseInt(maxPrice) * 10000;
		} catch (NumberFormatException e) {
			

       	 logger.log(Level.SEVERE, "error, {2}", e);
		}
		
		
		DBTest db = new DBTest();
		db.connectDB();
		RecomPhone rep = new RecomPhone();
		rep.makemodellist();
		result = rep.recom(company, minP, maxP, purpose);
		
		str[0] = result[0].getPhoneName();
		str[1] = result[1].getPhoneName();
		str[2] = result[2].getPhoneName();
		
		mdb.countPlus(str);
		
		

		request.setAttribute("phone1", result[0]); //객체를 request객체에 담음 (data가 문자열이 아니어도 가능)
		request.setAttribute("phone2", result[1]);
		request.setAttribute("phone3", result[2]);
		RequestDispatcher dispatcher = request.getRequestDispatcher("recommendedphone.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			

       	 logger.log(Level.SEVERE, "error, {3}", e);
		}
	}
}
