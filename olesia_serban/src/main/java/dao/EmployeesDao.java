package dao;

import java.util.List;

import data.Employees;



public interface EmployeesDao {
	Long create(Employees employee);

	Employees read(Long id);

	void update(Employees employee);

	void delete(Employees employee);

	List<Employees> findAll();

	List<Employees> findContractorsByBeginString(String begin);
}
