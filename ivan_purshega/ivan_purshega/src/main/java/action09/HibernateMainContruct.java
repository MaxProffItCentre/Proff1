package action09;

import java.util.List;

import dao.ContructorDaoImpl;
import dao.ProductDaoImpl;
import data.Product;
import data.contructor;

public class HibernateMainContruct {
		public static void main(String[] args) {
			ContructorDaoImpl ContructImpl = new ContructorDaoImpl();
			contructor[] arr = new contructor[]{
					new contructor("Vasya"),
					new contructor("Kolya"),
					new contructor("Petya"),
					};
			for(contructor contruct:arr){
				ContructImpl.create(contruct);
			}
			List<contructor> contructor = ContructImpl.findAll();
			contructor.forEach(contructors->System.out.println(contructors.getName()));
//			ProductDaoImpl ProductImpl = new ProductDaoImpl();
//			Product[] arr = new Product[]{
//					new Product("Table",17),
//					new Product("Computer",18),
//					new Product("Mouse",19),
//					new Product("Keyboard",20),
//					};
//			for(Product product:arr){
//				ProductImpl.create(product);
//			}
//			List<Product> products = ProductImpl.findAll();
//			products.forEach(product->System.out.println(product.getName()));
//			
			
		}
	}