package dao;

import java.util.List;

import data.User;

public interface UserDao {
    Long create(User product);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    List<User> findUsersWithEmployees();
}
