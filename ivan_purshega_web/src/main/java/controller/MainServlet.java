package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet  extends HttpServlet {
	    ArrayList <User> users=new ArrayList<User>();
	    
	    
	    public MainServlet(){
	    	users.add(new User("vasa","chelios","pass"));
	    }
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     if(request.getParameter("field1")==null){	
		    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
			        dispatcher.forward(request, response);
		    	 
		     } else {
		    	 System.out.println(request.getParameter("field1"));
		    	 request.setAttribute("name", users.get(0).getName());
		    	 response.sendRedirect("/ivan_purshega_web/users");
//		    		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp"); 
//			        dispatcher.forward(request, response); 
		     } 	
		    }
}