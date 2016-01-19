package services;

import java.util.List;

import dao.UserDao;
import data.User;

public class UserServiceImpl implements UserService {
	UserDao userDao = null;
	public UserServiceImpl(UserDao userDao){
		this.userDao = userDao;
	}
	@Override
	public void addNewProduct(User user) {
		userDao.create(user);
		
	}

	@Override
	public void updateProduct(User user) {
		userDao.update(user);
		
	}

	@Override
	public void deleteProduct(User user) {
		userDao.delete(user);
		
	}

	@Override
	public List<User> getAllProducts() {
		
		return userDao.findAll();
	}

}
