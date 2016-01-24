package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Employee;
import data.Product;
import util.HibernateUtil;

public class EmployeesDaoImpl implements EmployeesDao {
	 private static Logger log = Logger.getLogger(EmployeesDaoImpl.class);
	

	@Override
	public Long create(Employee employee) {
		Session session=HibernateUtil.getSessionFactory().openSession();
	Long id=null;
		try{
			session.beginTransaction(); 
			id=(long)session.save(employee);
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();}
		return id;
	}

	@Override
	public Employee read(Long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee employee = null;
        try {
           employee = (Employee)session.get(Employee.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
        return employee;
		
	}

	@Override
	public void update(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            System.out.println("Update Completed!");
        } catch (HibernateException e) {
            log.error("Transaction failed");
        } finally {
            session.close();
        }
		
	}

	@Override
	public void delete(Employee employee) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        session.delete(employee);
	        session.getTransaction().commit();
	        System.out.println("Delete Completed!");
	    } catch (HibernateException e) {
	        log.error("Transaction failed");
	    } finally {
	        session.close();
	    }
		
	}

	@Override
	public List<Employee> findEmployeesByBeginString(String begin) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query= session.createQuery("from Employee where name like '"+begin+"%'");
          
		return query.list();
	}

	@Override
	public List<Employee> findAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Employee");
        return query.list();
	}

	@Override
	public List<Employee> findEmployeesBySalary(Long min, Long max) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query= session.createQuery("from Employee where salary between '"+min+"' and '"+max+"'");
           
		return query.list();
		
	}

}
