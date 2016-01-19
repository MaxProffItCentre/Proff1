package controller;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImpl;
import data.Product;
import service.ProductService;
import service.ProductServiceImpl;

public class Test {
	public static void main(String[] args) {
		ProductDao productDaoImpl = new ProductDaoImpl();
		ProductService serviceProduct = new ProductServiceImpl(productDaoImpl); 
		List<Product> list = serviceProduct.getAllProducts();
		list.forEach(prod->System.out.println(prod));		
	}
}
