package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import data.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	private static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public Long create(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public User read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
		try {
			user = (User) session.get(User.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public void update(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}

	}

	@Override
	public void delete(User user) {
		// delete(product)
	}

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from product");
			Query query = session.createQuery("from User");
			return query.list();
		} finally {
			session.close();
		}
	}
	@Override
	public List<User> findUsersWithEmployees(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from User");
			Criteria query = session.createCriteria(User.class).add(Restrictions.isNotNull("employee"));
			return query.list();
		} finally {
			session.close();
		}
	}
}
