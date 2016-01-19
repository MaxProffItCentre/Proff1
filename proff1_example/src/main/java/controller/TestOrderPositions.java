package controller;

import dao.OrderPositionsDao;
import dao.OrderPositionsDaoImpl;
import util.HibernateUtil;

public class TestOrderPositions {
	public static void main(String[] args) {
		
		OrderPositionsDao servis = new OrderPositionsDaoImpl();
		System.out.println();
		servis.findAll().forEach(orderPos->System.out.println(orderPos));
		System.out.println();
		HibernateUtil.getSessionFactory().close();
	}
}
