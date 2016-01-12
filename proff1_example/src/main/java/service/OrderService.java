package service;

import java.util.List;
import data.Order;

public interface OrderService {	
	void addNewOrder(Order order);
	void updateOrder(Order order);
	void deleteOrder(Order order);
	List<Order> getAllOrders(); 
}
