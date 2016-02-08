package dao;

import java.util.List;

import data.User;

public interface UserDao {
	    int create(User user);
	    User  read(int id);
	    void update(User user);
	    void delete(User user);
	    List<User> findAll();
}
