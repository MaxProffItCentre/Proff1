package dao;

import java.util.List;

import data.Contractor;

public interface ContractorDao {
	Long create(Contractor contractor);

	Contractor read(Long id);

	void update(Contractor contractor);

	void delete(Contractor contractor);

	List<Contractor> findAll();

	List<Contractor> findContractorsByBeginString(String begin);
}
