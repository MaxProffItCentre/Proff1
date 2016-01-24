package action09;

import java.util.List;

import dao.UserDaoImpl;
import data.User;
import util.HibernateUtil;

public class HibernateMainUsers {
	public static void main(String[] args) {
		UserDaoImpl UsersImpl = new UserDaoImpl();
		
		//List<Employee> employees = EmployeesImpl.findEmployeesBySalary((long)600, (long)1000);
		List<User> users = UsersImpl.findAll();
		users.forEach(user->{
			if (user.getEmployee()!=null)System.out.println(user.getName()+"   "+user.getEmployee(user.getEmployeeId()).getName());
		else System.out.println(user.getName()+"   "+0);});
		HibernateUtil.getSessionFactory().close();
	}
}
