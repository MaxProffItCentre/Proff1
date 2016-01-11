package services;

import java.util.List;

import data.User;

public interface UserService {
	void addNewProduct(User user);

	void updateProduct(User user);

	void deleteProduct(User user);

	List<User> getAllProducts();
}
