package action09;

import java.util.List;

import dao.EmployeesDaoImpl;
import data.Employee;
import util.HibernateUtil;

public class HibernateMainEmployees {
	public static void main(String[] args) {
		EmployeesDaoImpl EmployeesImpl = new EmployeesDaoImpl();
		
		//List<Employee> employees = EmployeesImpl.findEmployeesBySalary((long)600, (long)1000);
		List<Employee> employees = EmployeesImpl.findAll();
		employees.forEach(employee->{if (employee.getUser()!=null)System.out.println(employee.getName()+"   "+employee.getUser().getName());
		else System.out.println(employee.getName()+" 0  ");});
		HibernateUtil.getSessionFactory().close();
	}

}
