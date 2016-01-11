package dao;

import java.util.List;

import data.Employee;




public interface EmployeesDao {
	Long create(Employee employee);

	Employee read(Long id);

	void update(Employee employee);

	void delete(Employee employee);

	List<Employee> findAll();

	List<Employee> findContractorsByBeginString(String begin);
}
