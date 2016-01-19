package dao;

import java.util.List;

import data.Role;



public interface RoleDao {
    Long create(Role role);
    Role read(Long id);
    void update(Role role);
    void delete(Role role);
    List<Role> findAll();
     List<Role> findProductsByBeginString(String begin);
		
	
}
