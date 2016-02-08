package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import data.User;
import util.Hibernate;

public class MainServlet  extends HttpServlet {
	    ArrayList <User> users=new ArrayList<User>();
	    
	    
//	    public MainServlet(){
//	    	users.add(new User("vasa","chelios","pass"));
//	    }
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     if(request.getParameter("field1")==null){	
		    	   RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/main.jsp");
			        dispatcher.forward(request, response);
		    	 
		     } else {
		    	 String LoginOfUser=request.getParameter("field1");
		    	 String PassOfUser=request.getParameter("field2");
		    	 System.out.println(request.getParameter("field1"));
		    	 System.out.println(request.getParameter("field2"));
		    	 request.setAttribute("name", users.get(0).getName());
		    	 request.setAttribute("questions", users.get(0).getMessages());
		    	 
		    	 response.sendRedirect("/ivan_purshega_web/users");
//		    		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp"); 
//			        dispatcher.forward(request, response); 
		     } 	
		    }
		
		 public List<User> authUser(String login, String password) {
			  System.out.println(login);
			  Session ses = Hibernate.getSessionFactory().openSession();
			  Criteria criteria = ses.createCriteria(User.class);
			  criteria.add(Restrictions.eq("login", login));
			  criteria.add(Restrictions.eq("pass", password));
			  System.out.println("CriteriaList - " + criteria.list().size());
			  users=(ArrayList<User>) criteria.list();
			  return criteria.list();
			  
			 }
}