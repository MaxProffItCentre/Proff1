package action09;

import java.util.List;

import dao.ProductDaoImpl;
import data.Product;
import util.HibernateUtil;

public class HibernateMainProduct {
	public static void main(String[] args) {
		ProductDaoImpl ProductImpl = new ProductDaoImpl();
		Product[] arr = new Product[]{
				new Product("Table",17),
				new Product("Computer",18),
				new Product("Mouse",19),
				new Product("Keyboard",20),
				};
		for(Product product:arr){
			ProductImpl.create(product);
		}
		List<Product> products = ProductImpl.findAll();
		products.forEach(product->System.out.println(product.getName()));
		HibernateUtil.getSessionFactory().close();
	}
}
