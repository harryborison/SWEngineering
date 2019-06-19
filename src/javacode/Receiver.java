package javacode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Receiver
 */
@WebServlet("/Receiver")
public class Receiver extends HttpServlet implements Observer{
	private static final long serialVersionUID = 1L;
    private Publisher publisher;
    public Receiver(Publisher publisher) {
        super();
        this.publisher = publisher;
        publisher.add(this);
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
		doGet(request, response);
	}
	
	@Override
	public void update(String p1, String p2, String p3)
	{
		display();
	}
	
	public void display()
	{
		// ranking.jsp·Î 
	}
	
}
