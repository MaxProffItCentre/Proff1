package controller;

import dao.UserDao;
import dao.UserDaoImpl;
import service.UserService;
import service.UserServisImpl;
import util.HibernateUtil;

public class TestUsers {
	public static void main(String[] args) {
		
		UserService userServis = new UserServisImpl(new UserDaoImpl());
		System.out.println();
		System.out.println("getUsersWithEmployee size="+userServis.getUsersWithEmployee().size());
		userServis.getUsersWithEmployee().forEach(us->System.out.println(us));

		System.out.println();
		System.out.println("getAllUsers size="+userServis.getAllUsers().size());
		userServis.getAllUsers().forEach(us->System.out.println(us));
		
		/*
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.read(5L));
		*/
		HibernateUtil.getSessionFactory().close();
	}
}
