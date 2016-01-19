package dao;


import java.util.List;
import data.Order_Position;

	public interface Order_PositionDao {
	    Long create(Order_Position order_Position);
	    Order_Position read(Long id);
	    void update(Order_Position order_Position);
	    void delete(Order_Position order_Position);
	    List<Order_Position> findAll();
	     
	}