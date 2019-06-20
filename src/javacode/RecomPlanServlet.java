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
         try {
            request.setCharacterEncoding("utf-8");
         } catch (Exception e1) {
            
             logger.log(Level.INFO, "Start Logging");

                  logger.log(Level.SEVERE, "error, {0}", e1);
         }
      
      
      String[] company = request.getParameterValues("company");
      String[] type = request.getParameterValues("type");
      String minPrice = request.getParameter("minprice");
      String maxPrice = request.getParameter("maxprice");
      String data = request.getParameter("data");
      String dataAmount;
      int dataA=0;
      double dataB=0;
      if(data.equals("self")) // 流立涝仿
      {
         dataAmount = request.getParameter("dataAmount");
   
            try {
               dataB = Double.parseDouble(dataAmount);
            } catch (NumberFormatException e) {
               // TODO Auto-generated catch block
               logger.log(Level.INFO, "Start Logging");

                  logger.log(Level.SEVERE, "error, {0}", e);
            }
         
         dataB = dataB * 1000;
         dataA = (int)dataB;
      }
      else // 公力茄
      {
         dataAmount = "500000";
         try {
            dataA = Integer.parseInt(dataAmount);
         } catch (NumberFormatException e) {
            
            logger.log(Level.INFO, "Start Logging");

               logger.log(Level.SEVERE, "error, {0}", e);         }
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
         
         logger.log(Level.INFO, "Start Logging");

            logger.log(Level.SEVERE, "error, {0}", e);      }
      
      request.setAttribute("plan1", result[0]); 
      request.setAttribute("plan2", result[1]);
      request.setAttribute("plan3", result[2]);
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("recommendedPlan.jsp");
      
      try {
         dispatcher.forward(request, response);
      } catch (Exception e) {
         
         logger.log(Level.INFO, "Start Logging");

            logger.log(Level.SEVERE, "error, {0}", e);      }
   }

}