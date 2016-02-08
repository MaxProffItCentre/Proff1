package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import data.Message;
import data.User;
import util.Hibernate;

public class MainMessage {
	public static void main(String[] args) {
		
		List<User> us=authUser("Chev","123");
		
//		Date data = new Date();
//		
//		data.toLocaleString();
//		
//		System.out.println("data = "+data.toLocaleString());
//		data.toString();
	}
		
		 public static List<User> authUser(String login, String password) {
			  System.out.println(login);
			  Session ses = Hibernate.getSessionFactory().openSession();
			  Criteria criteria = ses.createCriteria(User.class);
			  criteria.add(Restrictions.eq("login", login));
			  criteria.add(Restrictions.eq("pass", password));
			  System.out.println("CriteriaList - " + criteria.list().size());
			  return criteria.list();
			  
			 }
//		MessageDaoImpl mesage = new MessageDaoImpl();
		
//		UserDaoImpl users = new UserDaoImpl();
//		List<User> lis =users.findAll();
////		System.out.println(mesage.read(1));
//		for( User s: lis ){
//			users.delete(s);;
//		}
		
		
//		User user2 = new User("vasa2","log2","pas2",0,0,0,0);
//		users.create(user2);
//		User user1 = users.read(2);
//		HashSet <Message>  mes= new HashSet(users.getAllMessage(user1));
//		for(Message s: mes){
//			System.out.println(s);
//		}
		
	}

