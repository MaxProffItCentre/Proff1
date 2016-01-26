package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet{
	
	
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 ArrayList<User> users = new ArrayList();
		 for(int i = 0; i < 3; i++){
				users.add(new User("Name"+i, "login"+i, "pass"));
		 }
		 
		 request.setAttribute("usersList", users);
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
	        dispatcher.forward(request, response);
	 }
}
