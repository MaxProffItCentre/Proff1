package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class DaoImpl<T> implements Dao<T> {
	
	private static Logger log = Logger.getLogger(DaoImpl.class);
	
	private Class<T> type;
	
	
	public DaoImpl (Class<T> type) {
		this.type = type;
	}


	public Long create(T t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(t);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
           if(session != null) session.close();
        }
        return id;
	}


	public T read(Long id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		T t = null;
		
        try {
            t = (T)session.get(type, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
        	if (session!=null) session.close();
        }
        return t;
	}


	public void update(T t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		}catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session!=null) session.close();
		}
		
	}


	public void delete(T t) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		}catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session!=null) session.close();
		}
	}


	public List<T> findAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(type);
        return criteria.list();
	}


	public List<T> findByBeginString(String begin) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
