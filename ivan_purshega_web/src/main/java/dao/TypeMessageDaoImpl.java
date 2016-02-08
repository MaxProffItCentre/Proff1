package dao;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.TypeMessage;
import util.Hibernate;

public class TypeMessageDaoImpl {
	  private static Logger log = Logger.getLogger(TypeMessageDaoImpl.class);
	    
	    
	   
	    public int create(TypeMessage typeMessage) {
	    	  Session session = Hibernate.getSessionFactory().openSession();
	    	  int idTypeMessage=0;
	    	        try {
	    	            session.beginTransaction();
	    	            idTypeMessage = (Integer) session.save(typeMessage);
	    	            session.getTransaction().commit();
	    	        } catch (HibernateException e) {
	    	            log.error("Transaction failed");
	    	            session.getTransaction().rollback();
	    	        } finally {
	    	            session.close();
	    	        }
	    	        return idTypeMessage;
	    	 }
		
		
		public TypeMessage  read(int idTypeMessage) {
			Session session = Hibernate.getSessionFactory().openSession();
			TypeMessage typeMessage = null;
	        try {
	        typeMessage = (TypeMessage)session.get(TypeMessage.class, idTypeMessage);
	        } catch (HibernateException e) {
	            log.error("Transaction failed");
	        } finally {
	            session.close();
	        }
	        return typeMessage;
		}
		
		
		public void update(TypeMessage typeMessage) {
			  //update(product)
			  Session session = Hibernate.getSessionFactory().openSession();
			  try {
			   session.beginTransaction();
			   Query query = session.createQuery("update TypeMessage set name='"+ "lalala" + "' where id=" + typeMessage.getIdTypeMessage());
			   query.executeUpdate();
			   session.getTransaction().commit();
			//   session.save(product);
			  } catch (HibernateException e) {
			   log.error("Transaction failed");
			            session.getTransaction().rollback();
			  } finally {
			   if (session != null) session.close();
			  }	 
		 }
			

	
		public void delete(TypeMessage typeMessage) {
			Session session = Hibernate.getSessionFactory().openSession();
			  try {
			   session.beginTransaction();
			   Query query = session.createQuery("DELETE FROM  TypeMessage  where idTypeMessage="+typeMessage.getIdTypeMessage());
			   query.executeUpdate();
			   session.getTransaction().commit();
			   } catch (HibernateException e) {
		         log.error("Transaction failed");
		         session.getTransaction().rollback();
		     } finally {
		         session.close();
		   }
		}
	
		public List<TypeMessage> findAll() {
			Session session = Hibernate.getSessionFactory().openSession();
	        Query query = session.createQuery("from TypeMessage");
	        return query.list();
		}
	
		public List<TypeMessage> findProductsByBeginString(String begin) {
			Session session = Hibernate.getSessionFactory().openSession();
			 Query query = session.createQuery("from TypeMessage where name like '"+ begin +"%'");
			 return query.list();	
		}
	}
