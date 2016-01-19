package action09;


	import java.util.List;

import dao.EmployeeDaoImpl;
import data.Employee;

	

	public class HibernateMainEmployee {
		
		public static void main(String[] args) {
			EmployeeDaoImpl EmpoyeetImpl = new EmployeeDaoImpl();
			Employee[] arr = new Employee[]{
					new Employee("Nikolau",1700),
					new Employee("Petrovich",1800),
					};
			for(Employee employee:arr){
				EmpoyeetImpl.create(employee);
			}
			List<Employee> employees = EmpoyeetImpl.findAll();
			employees.forEach(employee->System.out.println(employee.getName()));
			
			
		}
		
	}