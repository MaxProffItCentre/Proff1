package dao;



import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Orders;
import util.HibernateUtil;

public class OrdersDaoImpl implements OrdersDao{
    private static Logger log = Logger.getLogger(OrdersDaoImpl.class);

	@Override
	public Long create(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(order);
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
	public Orders read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Orders order = null;
        try {
            order = (Orders)session.get(Orders.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return order;
	}

	@Override
	public void update(Orders order) {
		  //update(product)
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try {
		  
		   session.beginTransaction();
		   Query query = session.createQuery("update Orders set name='"+ "lalala" + "' where id=" + order.getId());
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
	public void delete(Orders order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		  try {

		   session.beginTransaction();
		   Query query = session.createQuery("DELETE FROM  Product where id="+order.getId());
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
	public List<Orders> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Orders");
        return query.list();
	}

	@Override
	public List<Orders> findProductsByBeginString(String begin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		 Query query = session.createQuery("from Orders where name like '"+ begin +"%'");
		 return query.list();
		
	}

}