package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import data.Contractor;
import util.HibernateUtil;

public class ContractorDaoImpl implements ContractorDao{
	private static Logger log = Logger.getLogger(ContractorDaoImpl.class);
	@Override
	public Long create(Contractor contractor) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long)session.save(contractor);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed!");
			session.getTransaction().rollback();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return id;
	}

	@Override
	public Contractor read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Contractor contractor = null;
		try {
			contractor = (Contractor)session.get(Contractor.class, id);
		} catch (HibernateException e) {
			log.error("Transaction faild!");
		}finally{
			if(session != null){
				session.close();
			}
		}
		return contractor;
	}

	@Override
	public void update(Contractor contractor) {
		
		
	}

	@Override
	public void delete(Contractor contractor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contractor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contractor> findContractorsByBeginString(String begin) {
		// TODO Auto-generated method stub
		return null;
	}

}
