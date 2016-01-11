package dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import data.Employee;

import util.HibernateUtil;

public class EmployeesDaoImpl implements EmployeesDao {
	private static Logger log = Logger.getLogger(EmployeesDaoImpl.class);

	@Override
	public Long create(Employee employee) {
		Session session = HibernateUtil.getSession();
		Long id = null;
		try {
			session.beginTransaction();
			id = (Long) session.save(employee);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Transaction failed!");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public Employee read(Long id) {
		Session session = HibernateUtil.getSession();
		Employee emp = null;
		try {

			emp = (Employee) session.get(Employee.class, id);

		} catch (HibernateException e) {
			log.error("Transaction Failed!");
		} finally {
			if (session.isOpen()) {
				session.close();
			}

		}
		return emp;
	}

	@Override
	public void update(Employee employee) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Transaction failed!");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void delete(Employee employee) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			log.error("Transaction failed!");
			session.getTransaction().rollback();
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Employees");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findContractorsByBeginString(String begin) {
		Session session = HibernateUtil.getSession();
		Query query = session.createQuery("FROM Employees E WHERE E.name LIKE '" + begin + "%'");
		return query.list();
	}

}
