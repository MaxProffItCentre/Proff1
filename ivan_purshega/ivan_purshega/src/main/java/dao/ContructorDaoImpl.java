package dao;


	import java.util.List;


	import org.apache.log4j.Logger;
	import org.hibernate.HibernateException;
	import org.hibernate.Query;
	import org.hibernate.Session;


import data.contructor;
import util.HibernateUtil;

	public class ContructorDaoImpl implements ContructorDao{
	    private static Logger log = Logger.getLogger(ContructorDaoImpl.class);

		@Override
		public Long create(contructor contruct) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Long id = null;
	        try {
	            session.beginTransaction();
	            id = (Long)session.save(contruct);
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
		public contructor read(Long id) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			contructor contruct = null;
	        try {
	        	contruct = (contructor)session.get(contructor.class, id);
	        } catch (HibernateException e) {
	            log.error("Transaction failed");
	        } finally {
	            session.close();
	        }
	        return contruct;
		}

		@Override
		public void update(contructor contruct) {
			//update(product)
		}

		@Override
		public void delete(contructor contruct) {
			// delete(product)
		}

		@Override
		public List<contructor> findAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createQuery("from contructor");
	        return query.list();
		}

		@Override
		public List<contructor> findContructorByBeginString(String begin) {
			return null;
		}

	}