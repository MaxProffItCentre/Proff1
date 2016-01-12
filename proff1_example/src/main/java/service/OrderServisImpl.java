package service;

import java.util.List;
import dao.OrderDao;
import data.Order;

public class OrderServisImpl implements OrderService {
	private OrderDao orderDao = null;

	public OrderServisImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void addNewOrder(Order order) {
		orderDao.create(order);
	}



	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Order order) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Order> getAllOrders() {
		return orderDao.findAll();
	}

}
