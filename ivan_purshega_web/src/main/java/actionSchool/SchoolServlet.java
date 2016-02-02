package actionSchool;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class SchoolServlet extends HttpServlet {
		private ArrayList<School> schools=new ArrayList();
		
	 
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		    		schools.add(e)
		    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/school.jsp");
			        dispatcher.forward(request, response);
		    	 
	
		    }
}

