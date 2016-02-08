package dao;

import java.util.List;

import data.Message;
import data.User;

public interface MessageDao {
    Long create(Message messge);
    Message  read(int id);
    void update(Message message);
    void delete(Message message);
    List<Message> findAll();
}