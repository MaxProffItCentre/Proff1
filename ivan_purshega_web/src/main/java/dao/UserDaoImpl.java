package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.User;
import util.Hibernate;


	public class UserDaoImpl implements UserDao{
	    private static Logger log = Logger.getLogger(UserDaoImpl.class);
	    
	    
	   
		public Long create(User user) {
			Session session = Hibernate.getSessionFactory().openSession();
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
		
		
		public User read(Long id) {
			Session session = Hibernate.getSessionFactory().openSession();
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

		
		public void update(User user) {
			  //update(product)
			  Session session = Hibernate.getSessionFactory().openSession();
			  try {
			  
			   session.beginTransaction();
			   Query query = session.createQuery("update User set name='"+ "lalala" + "' where id=" + user.getId());
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
			
		

	
		public void delete(User user) {
			Session session = Hibernate.getSessionFactory().openSession();
			  try {

			   session.beginTransaction();
			   Query query = session.createQuery("DELETE FROM  User where id="+user.getId());
			   query.executeUpdate();
			   session.getTransaction().commit();
			   } catch (HibernateException e) {
		         log.error("Transaction failed");
		         session.getTransaction().rollback();
		     } finally {
		         session.close();
		     
		   }
		}

	
		public List<User> findAll() {
			Session session = Hibernate.getSessionFactory().openSession();
	        Query query = session.createQuery("from User");
	        return query.list();
		}

		
		public List<User> findProductsByBeginString(String begin) {
			Session session = Hibernate.getSessionFactory().openSession();
			 Query query = session.createQuery("from User where name like '"+ begin +"%'");
			 return query.list();
			
		}

		

	}