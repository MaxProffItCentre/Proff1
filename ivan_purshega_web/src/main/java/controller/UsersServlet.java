package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.Hibernate;
import data.Message;
import data.User;

public class UsersServlet extends HttpServlet{
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		 
		 String name = authUser("Chev","123").get(0).getName();
		 ArrayList<Message> message = new ArrayList(authUser("Chev","123").get(0).getMessages());
		 String str = message.get(0).getQuestion();
		 request.setAttribute("question", str );
		 request.setAttribute("name", name );
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
	        dispatcher.forward(request, response);
	 }
	 
	 public List<User> authUser(String login, String password) {
		  System.out.println(login);
		  Session ses = Hibernate.getSessionFactory().openSession();
		  Criteria criteria = ses.createCriteria(User.class);
		  criteria.add(Restrictions.eq("login", login));
		  criteria.add(Restrictions.eq("pass", password));
		  System.out.println("CriteriaList - " + criteria.list().size());
		  return criteria.list();
		  
		 }
	 
}
