package Support;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsersServlet extends HttpServlet  {
	private ArrayList<User> users = (ArrayList<User>)User.getUsers();
	private String [] filtrChecked = {"0", "0", "0", "0", "0"} ;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		    ArrayList<User>usersAnswers = new ArrayList<User>();
			ArrayList<User>usersManages = new ArrayList<User>();
			ArrayList<User>usersDirectors = new ArrayList<User>();
			ArrayList<User>usersAdmins = new ArrayList<User>(); 
			
			String alert = "";
		// Добавление нового пользователя
			if (request.getParameter("name")!=null && request.getParameter("login")!=null && request.getParameter("pass")!=null) {
				if (request.getParameter("name")!="" && request.getParameter("login")!="" && request.getParameter("pass")!=""){
					String name = request.getParameter("name");
					String login = request.getParameter("login");
					String pass = request.getParameter("pass");
					User userAdd = new User(name, login, pass, false, false, false, false);
					if (request.getParameter("Answer")!=null && request.getParameter("Answer").equals("Answer")) userAdd.setCanAnswer(true);
					if (request.getParameter("Manage")!=null && request.getParameter("Manage").equals("Manage")) userAdd.setCanManage(true);
					if (request.getParameter("Director")!=null && request.getParameter("Director").equals("Director")) userAdd.setDirector(true);
					if (request.getParameter("Admin")!=null && request.getParameter("Admin").equals("Admin")) userAdd.setAdmin(true);
					users.add(userAdd);
					alert = "ПОЛЬЗОВАТЕЛЬ ДОБАВЛЕН!";
				}else {
					alert = "Не все поля заполнены!";
				}
			} else {
				//nothing 
				
			}
			
			
		
	    //Изменения роли
	        for (int i=0; i<users.size(); i++) {  
	        	if (request.getParameter("Answer"+i)!=null && request.getParameter("Answer"+i).equals("isCanAnswer")){
	        			users.get(i).setCanAnswer(true);
	        		
	        	} else if (request.getParameter("Manage" + i)!=null && request.getParameter("Manage" + i).equals("isCanManage")){
	        			users.get(i).setCanManage(true);
	  
	        	} else if (request.getParameter("Director" + i)!=null && request.getParameter("Director" + i).equals("isCanDirector")){
        			users.get(i).setDirector(true);
        		
	        	} else if (request.getParameter("Admin" + i)!=null && request.getParameter("Admin" + i).equals("isCanAdmin")){
        			users.get(i).setAdmin(true);
        		
	        	}  else if (request.getParameter("ResetAll" + i)!=null && request.getParameter("ResetAll" + i).equals("ResetAll")){
	        		if (users.get(i).isCanAnswer()) users.get(i).setCanAnswer(false);
	        		if (users.get(i).isCanManage())users.get(i).setCanManage(false);
	        		if (users.get(i).isDirector())users.get(i).setDirector(false);
	        		if(users.get(i).isAdmin())users.get(i).setAdmin(false);
	        	}
	        }
	    

	    
	    //Фильтр по ролям
	    String filtr = request.getParameter("roles");
	    if (filtr != null) {
	    	if (filtr.equals("Answers")) {   //Answers
	    		for (User user: users) {
	    			if (user.isCanAnswer()) usersAnswers.add(user);
	    		}
	    		request.setAttribute("usersAnswers", usersAnswers);	
	    		for (int j = 0; j <filtrChecked.length; j++) {
	    			if (j == 0) {
	    				filtrChecked[j] = "1";
	    			}else {
	    				filtrChecked[j] = "0";
	    			}
	    		}
	    	} else if (filtr.equals("Manages")) {   //Manages
	    		for (User user: users) {
	    			if (user.isCanManage()) usersManages.add(user);
	    		}
	    		request.setAttribute("usersManages", usersManages);	
	    		for (int j = 0; j <filtrChecked.length; j++) { 
	    			if (j == 1) {
	    				filtrChecked[j] = "1";
	    			}else {
	    				filtrChecked[j] = "0";
	    			}
	    		}
	    	} else if (filtr.equals("Directors")) {    //Directors
	    		for (User user: users) {
	    			if (user.isDirector()) usersDirectors.add(user);
	    		}
	    		request.setAttribute("usersDirectors", usersDirectors);	
	    		for (int j = 0; j <filtrChecked.length; j++) {
	    			if (j == 2) {
	    				filtrChecked[j] = "1";
	    			}else {
	    				filtrChecked[j] = "0";
	    			}
	    		}
	    	} else if (filtr.equals("Admins")) {       //Admins
	    		for (User user: users) {
	    			if (user.isAdmin()) usersAdmins.add(user);
	    		}
	    		request.setAttribute("usersAdmins", usersAdmins);	
	    		for (int j = 0; j <filtrChecked.length; j++) {
	    			if (j == 3) {
	    				filtrChecked[j] = "1";
	    			}else {
	    				filtrChecked[j] = "0";
	    			}
	    		}
	    	} else if (filtr.equals("All")) {      //All
	    		for (int j = 0; j <filtrChecked.length; j++) {
	    			if (j == 4) {
	    				filtrChecked[j] = "1";
	    			}else {
	    				filtrChecked[j] = "0";
	    			}
	    		}
	    		request.setAttribute("users", users);
	    	}
	    } 
	    	
		request.setAttribute("alert", alert);
	    
	    request.setAttribute("filtrChecked", filtrChecked);
	    
	    request.setAttribute("users", users);
		 
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/users.jsp");
	        dispatcher.forward(request, response);
	   
	}
}
