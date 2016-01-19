package action09;

import java.util.List;

import dao.ProductDaoImpl;
import data.Product;
import util.HibernateUtil;

public class HibernateMainProduct {
	public static void main(String[] args) {
		ProductDaoImpl ProductImpl = new ProductDaoImpl();
		/*Product[] arr = new Product[]{
				new Product("Table",17),
				new Product("Computer",18),
				new Product("Mouse",19),
				new Product("Keyboard",20),
				};
		for(Product product:arr){
			//ProductImpl.create(product);
		}
		ProductImpl.delete(new Product("Moto",10));*/
		/*Product prd = ProductImpl.read(7l);
		System.out.println(prd);
		prd.setName("SuperBike1");
		ProductImpl.update(prd); 
		System.out.println(prd);
		System.out.println("*****");
		ProductImpl.delete(prd);
		System.out.println("DELETING SUPERBIKE");
		System.out.println("*************");*/
		
		List<Product> products = ProductImpl.findAll();
		products.forEach(product->System.out.println(product.getName()));
		List<Product> pr2 = ProductImpl.findProductsByBeginString("M");
		pr2.forEach(pr -> System.out.println(pr.getName()));
		
		HibernateUtil.getSessionFactory().close();
	}
}
