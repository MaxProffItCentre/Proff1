package action09;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import data.Product;

public class HibernateMainProduct {
	
	public static void main(String[] args) {
		ProductDaoImpl ProductImpl = new ProductDaoImpl();
		ProductImpl.create(new Product("Productik",222));
//		Product[] arr = new Product[]{
//				new Product("Table",17),
//				new Product("Computer",18),
//				new Product("Mouse",19),
//				new Product("Keyboard",20),
//				};
//		for(Product product:arr){
//			ProductImpl.create(product);
//		}
//		List<Product> products = ProductImpl.findAll();
//		products.forEach(product->System.out.println(product.getName()));
//		System.out.println(ProductImpl.findProductsByBeginString("C"));
		ProductImpl.update(ProductImpl.findAll().get(1));
		
		
	}
	
}