package dao;

import java.util.List;

import data.Orders;



public interface OrdersDao {
    Long create(Orders order);
    Orders read(Long id);
    void update(Orders order);
    void delete(Orders order);
    List<Orders> findAll();
     List<Orders> findProductsByBeginString(String begin);
		
	
}

