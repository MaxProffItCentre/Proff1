package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Order_Position;
import data.Product;
import util.HibernateUtil;

public class Order_PositionDaoImpl implements Order_PositionDao {
	 private static Logger log = Logger.getLogger(Order_PositionDaoImpl.class);

		@Override
		public Long create(Order_Position order_Position) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Long id = null;
	        try {
	            session.beginTransaction();
	            id = (Long)session.save(order_Position);
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
		public Order_Position read(Long id) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Order_Position order_Position = null;
	        try {
	        	order_Position = (Order_Position)session.get(Order_Position.class, id);
	        } catch (HibernateException e) {
	            log.error("Transaction failed");
	        } finally {
	            session.close();
	        }
	        return order_Position;
		}

		@Override
		public void update(Order_Position order_Position) {
			  //update(product)
			  Session session = HibernateUtil.getSessionFactory().openSession();
			  try {
			  
			   session.beginTransaction();
			   Query query = session.createQuery("update Order_Position set name='"+ "lalala" + "' where id=" + order_Position.getId());
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
		public void delete(Order_Position order_Position) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			  try {

			   session.beginTransaction();
			   Query query = session.createQuery("DELETE FROM  Order_Position where id="+order_Position.getId());
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
		public List<Order_Position> findAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery("from Order_Position");
	        return query.list();
		}
}
