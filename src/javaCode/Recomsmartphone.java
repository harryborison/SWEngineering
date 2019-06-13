package javaCode;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.*;
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
		//request.setCharacterEncoding("EUC-KR");
		request.setCharacterEncoding("utf-8");


		String[] company = request.getParameterValues("company");
		String minPrice = request.getParameter("minPrice");
		String maxPrice = request.getParameter("maxPrice");
		String[] purpose = request.getParameterValues("purpose");
		Model[] result = new Model[3];

		int minP = Integer.parseInt(minPrice) * 10000;
		int maxP = Integer.parseInt(maxPrice) * 10000;
		DBTest db = new DBTest();
		db.connectDB();
		recomPhone rep = new recomPhone();
		rep.makemodel_list();
		result = rep.recom(company, minP, maxP, purpose);

		System.out.println(result[0].getPhoneName());
		System.out.println(result[1].getPhoneName());
		System.out.println(result[2].getPhoneName());

		request.setAttribute("phone1", result[0]); //객체를 request객체에 담음 (data가 문자열이 아니어도 가능)
		request.setAttribute("phone2", result[1]);
		request.setAttribute("phone3", result[2]);
		RequestDispatcher dispatcher = request.getRequestDispatcher("recommendedphone.jsp");

		dispatcher.forward(request, response);
	}
}
