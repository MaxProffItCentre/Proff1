package dao;

import java.util.List;

import data.TypeMessage;
import data.User;

public interface TypeMessageDao {
	    int create(TypeMessage typeMessage);
	    TypeMessage  read(int id);
	    void update(TypeMessage typeMessage);
	    void delete(TypeMessage typeMessage);
	    List<TypeMessage> findAll();
}