package controller;

import dao.OrderDaoImpl;
import dao.OrderPositionsDao;
import dao.OrderPositionsDaoImpl;
import service.OrderService;
import service.OrderServisImpl;
import util.HibernateUtil;

public class TestOrders {
	public static void main(String[] args) {
		OrderPositionsDao servis = new OrderPositionsDaoImpl();
		System.out.println();
		servis.findAll().forEach(orderPos->System.out.println(orderPos));
		System.out.println();
		
		
		OrderService orderServis = new OrderServisImpl(new OrderDaoImpl());
		orderServis.getAllOrders().forEach(order->System.out.println(order));
		
		HibernateUtil.getSessionFactory().close();
	}
}
