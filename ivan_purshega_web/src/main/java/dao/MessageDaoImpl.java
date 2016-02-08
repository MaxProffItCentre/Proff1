package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import data.Message;
import data.User;
import util.Hibernate;

public class MessageDaoImpl implements MessageDao {
	 private static Logger log = Logger.getLogger(MessageDaoImpl.class);
	 
	 
	public Long create(Message messge) {
		// TODO Auto-generated method stub
		return null;
	}

	public Message read(int id) {
		Session session = Hibernate.getSessionFactory().openSession();
		Message message = null;
        try {
        	message = (Message)session.get(Message.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return message;
	}

	public void update(Message message) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Message message) {
		// TODO Auto-generated method stub
		
	}

	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
