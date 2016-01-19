package service;

import java.util.List;
import dao.UserDao;
import data.User;

public class UserServisImpl implements UserService {
	private UserDao userDao = null;

	public UserServisImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addNewUser(User user) {
		userDao.create(user);
	}



	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public List<User> getUsersWithEmployee() {
		return userDao.findUsersWithEmployees();
	}

}
