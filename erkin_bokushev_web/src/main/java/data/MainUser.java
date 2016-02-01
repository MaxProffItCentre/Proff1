package data;

import java.util.List;

import dao.DaoImpl;

public class MainUser { 
public static void main(String[] args) {
	DaoImpl<User> dao = new DaoImpl<User>(User.class);
	List<User> list = dao.findAll();
	
//	list.forEach(action->System.out.println(action.getName()));
}
}
