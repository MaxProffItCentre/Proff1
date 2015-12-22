package dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import data.User;
import util.HibernateUtil;

public class UserDaoImpl implements UserDao{
    private static Logger log = Logger.getLogger(UserDaoImpl.class);

	@Override
	public Long create(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
	}

	@Override
	public User read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		User user = null;
        try {
            user = (User)session.get(User.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return user;
	}

	@Override
	public void update(User user) {
		  //update(product)
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try {
		  
		   session.beginTransaction();
		   Query query = session.createQuery("update Product set name='"+ "lalala" + "' where id=" + user.getId());
		   query.executeUpdate();
		   session.getTransaction().commit();
		//   session.save(product);
		  } catch (HibernateException e) {
		   log.error("Transaction failed");
		            session.getTransaction().rollback();
		  } finally {
		   if (session != null) session.close();
		  }
		 
	 }
		
	

	@Override
	public void delete(User user) {
		// delete(product)
	}

	@Override
	public List<User> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User");
        return query.list();
	}

	@Override
	public List<User> findProductsByBeginString(String begin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query query = session.createQuery("from User where name like '"+ begin +"%'");
		 return query.list();
		
	}

}