package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Order;
import util.HibernateUtil;

public class OrdersDaoImp implements GenericDao<Order>{
	 private static Logger log = Logger.getLogger(OrdersDaoImp.class);
	@Override
	public Long create(Order product) {Session session = HibernateUtil.getSessionFactory().openSession();
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
	public Order read(Long id) {Session session = HibernateUtil.getSessionFactory().openSession();
	Order product = null;
    try {
        product = (Order)session.get(Order.class, id);
    } catch (HibernateException e) {
        log.error("Transaction failed");
    } finally {
        session.close();
    }
    return product;
	}

	@Override
	public void update(Order product) {
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
	public boolean delete(Order product) {Session session = HibernateUtil.getSessionFactory().openSession();
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
	public List<Order> findAll() {Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("from Order");
    return query.list();
	}

	
	
}
