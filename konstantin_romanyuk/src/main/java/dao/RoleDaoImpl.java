package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Role;
import util.HibernateUtil;

public class RoleDaoImpl implements GenericDao<Role>{
	 private static Logger log = Logger.getLogger(RoleDaoImpl.class);
	@Override
	public Long create(Role product) {Session session = HibernateUtil.getSessionFactory().openSession();
	Long id = null;
   try {
       session.beginTransaction();
       id = (Long)session.save(product);
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
	public Role read(Long id) {Session session = HibernateUtil.getSessionFactory().openSession();
	Role product = null;
   try {
       product = (Role)session.get(Role.class, id);
   } catch (HibernateException e) {
       log.error("Transaction failed");
   } finally {
       session.close();
   }
   return product;
	}

	@Override
	public void update(Role product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
           session.beginTransaction();
           session.update(product);
           session.getTransaction().commit();
           System.out.println("Update Completed!");
       } catch (HibernateException e) {
           log.error("Transaction failed");
       } finally {
           session.close();
       }
	}

	@Override
	public boolean delete(Role product) {Session session = HibernateUtil.getSessionFactory().openSession();
	try {
       session.beginTransaction();
       session.delete(product);
       session.getTransaction().commit();
       System.out.println("Delete Completed!");
       return true;
   } catch (HibernateException e) {
   	 session.getTransaction().rollback();
       log.error("Transaction failed");
       return false;
   } finally {
       session.close();
   }
	}

	@Override
	public List<Role> findAll() {Session session = HibernateUtil.getSessionFactory().openSession();
   Query query = session.createQuery("from Role");
   return query.list();
	}

}
