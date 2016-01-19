package action11;

import java.util.ArrayList;

import dao.UserDao;
import dao.UserDaoImpl;
import util.HibernateUtil;

public class HibernateMainUser {
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl();
		ArrayList<?> list = (ArrayList<?>) dao.findAll();
		list.forEach(u -> System.out.println(u));
		HibernateUtil.getSessionFactory().close();
	}
}
