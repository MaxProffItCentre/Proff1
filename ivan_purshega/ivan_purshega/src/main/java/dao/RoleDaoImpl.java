package dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import data.Role;
import util.HibernateUtil;

public class RoleDaoImpl implements RoleDao{
    private static Logger log = Logger.getLogger(RoleDaoImpl.class);

	@Override
	public Long create(Role role) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(role);
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
	public Role read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Role role = null;
        try {
            role = (Role)session.get(Product.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return role;
	}

	@Override
	public void update(Role role) {
		  //update(product)
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try {
		  
		   session.beginTransaction();
		   Query query = session.createQuery("update Role set name='"+ "lalala" + "' where id=" + role.getId());
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
	public void delete(Role role) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  try {

		   session.beginTransaction();
		   Query query = session.createQuery("DELETE FROM  Role where id="+role.getId());
		   query.executeUpdate();
		   session.getTransaction().commit();
		   } catch (HibernateException e) {
	         log.error("Transaction failed");
	         session.getTransaction().rollback();
	     } finally {
	         session.close();
	     
	   }
	}

	@Override
	public List<Role> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Role");
        return query.list();
	}

	@Override
	public List<Role> findProductsByBeginString(String begin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query query = session.createQuery("from Role where name like '"+ begin +"%'");
		 return query.list();
		
	}

}
