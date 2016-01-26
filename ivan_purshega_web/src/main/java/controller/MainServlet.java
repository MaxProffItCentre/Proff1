package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet  extends HttpServlet {
	

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     request.setAttribute("var1","tttttt");
		     if(request.getParameter("field1") != null){
		      String field1 = request.getParameter("field1").toString();
		         request.setAttribute("var2", field1);
		     }
		     //String field1 = request.getAttribute("field1").toString();
		     //request.setAttribute("var1", field1);
		     RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
		        dispatcher.forward(request, response);
		    }
}
