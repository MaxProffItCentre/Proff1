package service;

import java.util.List;
import data.User;

public interface UserService {	
	void addNewUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
	List<User> getAllUsers();
	List<User> getUsersWithEmployee();
}
