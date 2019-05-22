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
		
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("passwordRepeat");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone_number = request.getParameter("phone_number");
		String email_address = request.getParameter("email_address");
		String sex = request.getParameter("sex");
		
		System.out.println(ID);
		System.out.println(password);
		System.out.println(passwordRepeat);
		System.out.println(name);
		System.out.println(age);
		System.out.println(phone_number);
		System.out.println(email_address);
		System.out.println(sex);
		
		
		doGet(request, response);
	}

}
