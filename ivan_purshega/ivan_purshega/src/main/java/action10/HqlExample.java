package action10;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Product;
import util.HibernateUtil;

public class HqlExample {
 private static final Logger LOGGER = Logger.getLogger(HqlExample.class);

 public static void main(String[] args) {
  Session session = HibernateUtil.getSessionFactory().openSession();
  System.out.println();
  
  Query query1 = session.createQuery("from Product");
  List<Product> products = (List<Product>) query1.list();
  products.forEach(obj->System.out.print(obj.getName()+", "));
  
  System.out.println();
  
  Query query2 = session.createQuery("select barcode from Product");
  List<String> codes = query2.list();
  System.out.println(codes);
  
  if(session!=null){
   session.close();
  }
  HibernateUtil.getSessionFactory().close();
 }
}