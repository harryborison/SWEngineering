package javacode;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RecomPlanServlet
 */
@WebServlet("/RecomPlanServlet")
public class RecomPlanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecomPlanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			try {
				request.setCharacterEncoding("utf-8");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		String[] company = request.getParameterValues("company");
		String[] type = request.getParameterValues("type");
		String minPrice = request.getParameter("minprice");
		String maxPrice = request.getParameter("maxprice");
		String data = request.getParameter("data");
		String dataAmount;
		int dataA=0;
		double dataB=0;
		if(data.equals("self")) // 직접입력
		{
			dataAmount = request.getParameter("dataAmount");
	
				try {
					dataB = Double.parseDouble(dataAmount);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			dataB = dataB * 1000;
			dataA = (int)dataB;
		}
		else // 무제한
		{
			dataAmount = "500000";
			try {
				dataA = Integer.parseInt(dataAmount);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] option = request.getParameterValues("option");
		
		
		Plan result[] = {};
		DBTest db = new DBTest();
		db.connectDB();
		
		RecomPlan rep = new RecomPlan();
		rep.makepaln_list();
		
		try {
			result = rep.recPlan(company, type, Integer.parseInt(minPrice), Integer.parseInt(maxPrice), dataA, option);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("plan1", result[0]); 
		request.setAttribute("plan2", result[1]);
		request.setAttribute("plan3", result[2]);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("recommendedPlan.jsp");
		
		try {
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
