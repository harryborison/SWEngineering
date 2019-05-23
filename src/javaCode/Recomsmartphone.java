package javaCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("UTF-8");
		
		String[] company = request.getParameterValues("company");
		String minPrice = request.getParameter("minprice");
		String maxPrice = request.getParameter("maxprice");
		String[] purpose = request.getParameterValues("purpose");
		
		System.out.println("company : " + company[0]);
		System.out.println("price : " + minPrice + " ~ " + maxPrice);
		System.out.println("purpose : " + purpose[0]);
		doGet(request, response);
	}

}
