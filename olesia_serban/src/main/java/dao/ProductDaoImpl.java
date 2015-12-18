package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {
	private static Logger log = Logger.getLogger(ProductDaoImpl.class);

	@Override // or id or boolean or void
	public Long create(Product product) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(product);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null)
				session.close();
		}
		return id;
	}

	@Override
	public Product read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Product product = null;
		try {
			product = (Product) session.get(Product.class, id);
		} catch (HibernateException e) {
			log.error("Transaction failed");
		} finally {
			if (session != null)
				session.close();
		}
		return product;
	}

	@Override
	public void update(Product product) {

		String nameTmp = product.getName();
		Long idTmp = product.getId();
		int codeTmp = product.getBarcode();
		String str = "UPDATE product SET name = '" + nameTmp + "', code = " + codeTmp + " WHERE id = " + idTmp;
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(str);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			log.error("Transaction failed!");
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void delete(Product product) {
		Long idTmp = product.getId();
		Session session = HibernateUtil.getSession();
		String str = "DELETE FROM product WHERE id = " + idTmp;
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(str);
			query.executeUpdate();
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Transaction failed");
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Product> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("FROM Product");

		return query.list();
	}

	@Override
	public List<Product> findProductsByBeginString(String begin) {
		Session session = HibernateUtil.getSession();
		String str = "FROM Product P WHERE P.name LIKE '" + begin + "%'";
		Query query = session.createQuery(str);

		return query.list();
	}

}
