package dao;

import java.util.List;

import data.User;
import util.HibernateUtil;

public class prosto {
	public static void main(String[] args) {
//		UserDaoImpl user=new UserDaoImpl();
//		System.out.println(user.findAll());
		UserDaoImpl user = new UserDaoImpl();
		  //Session ses = HibernateUtil.getSessionFactory().openSession()
		  List<User> list = user.findAll();
		  //System.out.println(list);
		  list.forEach(oo->System.out.println(oo));
		  HibernateUtil.getSessionFactory().close();
	}
}
