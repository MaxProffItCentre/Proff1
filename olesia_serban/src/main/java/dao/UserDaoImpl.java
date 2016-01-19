package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public Long create(User user) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public User read(Long id) {
		Session session = HibernateUtil.getSession();
		User user = null;
		try {
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

		return user;
	}

	@Override
	public void update(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public void delete(User user) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM User");

		return query.list();

	}

	@Override
	public List<User> findUsersByBeginString(String begin) {
		Session session = HibernateUtil.getSession();
		String str = "FROM User U WHERE U.name LIKE '" + begin + "%'";
		Query query = session.createQuery(str);

		return query.list();
	}

	

}
