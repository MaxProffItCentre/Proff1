package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Contructor;
import util.HibernateUtil;

public class ContructorDaoImpl implements ContructorDao {
	private static Logger log = Logger.getLogger(ContructorDaoImpl.class);

	@Override
	public Long create(Contructor contructor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(contructor);
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
	public Contructor read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Contructor contructor = null;
		try {
			contructor = (Contructor) session.get(Contructor.class, id);
		} catch (HibernateException ex) {
			log.error("Transaction faield");
		} finally {
			session.close();
		}

		return contructor;
	}

	@Override
	public void update(Contructor contructor) {
		if (contructor != null) {
			Session ses = null;
			try {
				ses = HibernateUtil.getSessionFactory().openSession();
				ses.beginTransaction();
				ses.update(contructor);
				ses.getTransaction().commit();
			} catch (HibernateException ex) {
				log.error("Dont update transaction: " + ex);
				ses.getTransaction().rollback();
			} finally {

			}
		}

	}
	
	public void updateSQL(Contructor contructor) {
		if (contructor != null) {
			Session ses = null;
			try {
				ses = HibernateUtil.getSessionFactory().openSession();
				ses.beginTransaction();
				Query sql = ses.createSQLQuery("update contructors set name = '" + contructor.getName() 
					+ "' where id=" + contructor.getId());
				sql.executeUpdate();
				ses.getTransaction().commit();
			} catch (HibernateException ex) {
				log.error("Dont update transaction: " + ex);
				ses.getTransaction().rollback();
			} finally {

			}
		}

	}

	@Override
	public void delete(Contructor contructor) {
		Session ses = null;
		if (contructor != null) {
			try {
				ses = HibernateUtil.getSessionFactory().openSession();
				ses.beginTransaction();
				ses.delete(contructor);
				ses.getTransaction().commit();
			} catch (HibernateException ex) {
				log.error("Error: ", ex);
				ses.getTransaction().rollback();
			}
		}

	}

	@Override
	public List<Contructor> findAll() {
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Query sql = ses.createQuery("from Contructor");
		return sql.list();
	}

	@Override
	public List<Contructor> findContructorByBeginString(String begin) {
		Session ses = HibernateUtil.getSessionFactory().openSession();
		Query sql = ses.createQuery("from Contructor where name LIKE '" + begin + "%'");
		// sql.setParameter(1, begin);
		return sql.list();
	}

}
