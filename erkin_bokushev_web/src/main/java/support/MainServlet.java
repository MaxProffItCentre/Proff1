package support;
 
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoImpl;
import data.User;

public class MainServlet extends HttpServlet {
	private DaoImpl<User>daoIml = new DaoImpl<User>(User.class);
//	private ArrayList<User> users = (ArrayList<User>)daoIml.findAll();
	
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			ArrayList<User> users = (ArrayList<User>)daoIml.findAll();
			
			String login = req.getParameter("login");
			String pass = req.getParameter("pass");
			String text ="";
			
			if (req.getParameter("login") != null && req.getParameter("pass") != null) {
				
			for (User user: users) {
				if (user.getLogin().equals(login) && user.getPass().equals(pass)){
					text = "Авторизация прошла успешно!"; 
					if (user.isAdmin()) {
						RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/users.jsp");
						dispatcher.forward(req, resp);
					} else {
						RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/messages.jsp");
						dispatcher.forward(req, resp);
					}
					break;
				} else if (!user.getLogin().equals(login) && user.getPass().equals(pass)) {
					text = "Неверно введен логин!"; break;
				}else if (user.getLogin().equals(login) && !user.getPass().equals(pass)) {
					text = "Неверно введен пароль!"; break;
				} else if (!user.getLogin().equals(login) && !user.getPass().equals(pass)) {
					text = "Введите логин и пароль!"; 
				} 
			}
			}
			req.setAttribute("text", text);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/main.jsp");
			dispatcher.forward(req, resp);
		
		}
}
