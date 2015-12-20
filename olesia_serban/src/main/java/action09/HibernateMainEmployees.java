package action09;

import dao.EmployeesDaoImpl;
import data.Employees;
import util.HibernateUtil;

public class HibernateMainEmployees {
	public static void main(String[] args) {
		EmployeesDaoImpl dao = new EmployeesDaoImpl();
//		Employees emp = dao.read(4L);
//		emp.setName("LALA");
//		emp.setSalary(20);
//		dao.update(emp);
//		dao.create(emp);
//		dao.delete(emp);
		System.out.println(dao.findAll());
		System.out.println("*****************************************");
		System.out.println(dao.findContractorsByBeginString("К"));
		HibernateUtil.getSessionFactory().close();
		
	}
}
