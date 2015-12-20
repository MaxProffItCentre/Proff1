package dao;

import java.util.List;


import data.contructor;

public interface ContructorDao {
    Long create(contructor contruct);
    contructor read(Long id);
    void update(contructor contruct);
    void delete(contructor contruct);
    List<contructor> findAll();
    List<contructor> findContructorByBeginString(String begin);
}
