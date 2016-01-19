package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import data.OrderPositions;
import util.HibernateUtil;

public class OrderPositionsDaoImpl implements OrderPositionsDao {
	private static Logger log = Logger.getLogger(OrderPositionsDaoImpl.class);

	@Override
	public List<OrderPositions> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			// Query query = session.createQuery("from product");
			Query query = session.createQuery("from OrderPositions");
			return query.list();
		} finally {
			session.close();
		}
	}
	@Override
	public Long create(OrderPositions obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPositions read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderPositions obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderPositions obj) {
		// TODO Auto-generated method stub
		
	}
}
