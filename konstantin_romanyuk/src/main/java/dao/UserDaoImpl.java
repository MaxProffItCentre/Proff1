package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Contructor;
import data.User;
import util.HibernateUtil;

public class UserDaoImpl {

	private static Logger log = Logger.getLogger(UserDaoImpl.class);

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


public void update(User user) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	  try {session.beginTransaction();
		  session.update(user);
		  session.getTransaction().commit();
	  System.out.println("Update Completed!");
	  } catch (HibernateException e) {
	        log.error("Transaction failed");
	    } finally {
	        session.close();
	    }
    }



public void delete(User user) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	  try {
	  session.beginTransaction();
	  session.delete(user);
	 session.getTransaction().commit();
	  System.out.println("Contructor"+user.getName()+"Deleted Successfully!");
	  } catch (HibernateException e) {
	        log.error("Transaction failed");
	    } finally {
	        session.close();
	    }
  }



public List<User> findAll() {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from User");
    return query.list();
}


/*public List<Contructor> findContructorsByBeginString(String begin) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createSQLQuery("select* from contructors where name like '"+begin+"%'").addEntity(Contructor.class);
    ;
    
	return query.list();
}
public List<Contructor> findContructorsByBeginStringHQL(String begin) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query =  session.createQuery("from Contructor where name like '"+begin+"%'");
    query.setString(0, begin);
    ;
    
	return query.list();
}*/
}


