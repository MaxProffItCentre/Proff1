package HibernateExample;



import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import data.User;
import util.Hibernate;
//import util.HibernateUtil;



public class ExampleHibernat {
 private static final Logger LOGGER = Logger.getLogger(ExampleHibernat.class);

 public static void main(String[] args) {
  Session session = Hibernate.getSessionFactory().openSession();
  System.out.println();
  
  Query query1 = session.createQuery("from User");
  
 
  
  System.out.println(query1.list());
  
  
//  List<User> users = (List<User>) query1.list();
// users.forEach(obj->System.out.print(obj.getName()+", "));
//  
//  System.out.println(users);
  
//  Query query2 = session.createQuery("select name from User");
//  List<String> codes = query2.list();
//  System.out.println(codes);
  
  if(session!=null){
   session.close();
  }
  Hibernate.getSessionFactory().close();
 }
}
