package action10;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import util.HibernateUtil;

public class SqlExample {
	private static final Logger LOGGER = Logger.getLogger(SqlExample.class);
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createSQLQuery("select name from Product where id > ?").addEntity(Product.class);
		query = query.setLong(0, 2);
		
		List<Product> list = query.list();
		list.forEach(product->System.out.println(product.getId() + " - " +product.getName()));
		if(session!=null){
			session.close();
		}
		//HibernateUtil.getSessionFactory().close();
	}
}
