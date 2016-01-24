package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Contructor;
import util.HibernateUtil;

public class ContructorDaoImpl {
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);

public Long create(Contructor contructor) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Long id = null;
    try {
        session.beginTransaction();
        id = (Long)session.save(contructor);
        session.getTransaction().commit();
    } catch (HibernateException e) {
        log.error("Transaction failed");
        session.getTransaction().rollback();
    } finally {
        session.close();
    }
    return id;
}

public Contructor read(Long id) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Contructor contructor = null;
    try {
    	contructor = (Contructor)session.get(Contructor.class, id);
    } catch (HibernateException e) {
        log.error("Transaction failed");
    } finally {
        session.close();
    }
    return contructor;
}


public void update(Contructor contructor) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	  try {session.beginTransaction();
		  session.update(contructor);
		  session.getTransaction().commit();
	  System.out.println("Update Completed!");
	  } catch (HibernateException e) {
	        log.error("Transaction failed");
	    } finally {
	        session.close();
	    }
    }



public void delete(Contructor contructor) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	  try {
	  session.beginTransaction();
	  session.delete(contructor);
	 session.getTransaction().commit();
	  System.out.println("Contructor"+contructor.getName()+"Deleted Successfully!");
	  } catch (HibernateException e) {
	        log.error("Transaction failed");
	    } finally {
	        session.close();
	    }
  }



public List<Contructor> findAll() {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Contructor");
    return query.list();
}


public List<Contructor> findContructorsByBeginString(String begin) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createSQLQuery("select* from contructors where name like '"+begin+"%'").addEntity(Contructor.class);
    ;
    
	return query.list();
}
public List<Contructor> findContructorsByBeginStringHQL(String begin) {
	Session session = HibernateUtil.getSessionFactory().openSession();
    Query query =  session.createQuery("from Contructor where name like '"+begin+"%'");
   /* query.setString(0, begin);*/
    ;
    
	return query.list();
}
}