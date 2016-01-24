package action10;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import util.HibernateUtil;

public class SqlExample {
 private static final Logger LOGGER = Logger.getLogger(SqlExample.class);

 public static void main(String[] args) {
  Session session = HibernateUtil.getSessionFactory().openSession();
  
  /*
  Query query = session.createSQLQuery("select id,name,code from product").addEntity(Product.class);
  List<Product> list = query.list();
  System.out.println(list);
  list.forEach(obj->System.out.println(obj.getId()));
  */
  
  
  Query query = session.createSQLQuery("select * from Product where code between :a and :b").addEntity(Product.class);
  query.setInteger("a", 16);
  query.setInteger("b", 17);
  List<Product> list = query.list();
  System.out.println(list);
  list.forEach(obj->System.out.println(obj.getName()));
  
  List<String> listStr = session.createSQLQuery("select name from Product").list();
  System.out.println();
  System.out.println(listStr);
  
  if(session!=null){
   session.close();
  }
  HibernateUtil.getSessionFactory().close();
 }
}