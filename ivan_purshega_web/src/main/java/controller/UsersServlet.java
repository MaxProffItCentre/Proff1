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
		
		 String str="avtomobil";
		
		 
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
	        dispatcher.forward(request, response);
	 }
}
