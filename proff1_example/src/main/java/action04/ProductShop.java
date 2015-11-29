package action04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class ProductShop {
	Map<Product,String> contructors = new HashMap<Product,String>();
	public ProductShop(){
		contructors.put(new Product("Bread White",TypeProduct.Bread, 10),"Firma 3");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 10),"Firma 3");
		
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 12),"Firma 3");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 12),"Firma 3");
		
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 16),"Firma 1");
		contructors.put(new Product("Milk with Shokolate",TypeProduct.Milk, 14),"Firma 1");
		contructors.put(new Product("Simple Yogurt",TypeProduct.Yogurt, 14),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 16),"Firma 1");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 18),"Firma 1");

		contructors.put(new Product("Bread White",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Super Yogurt",TypeProduct.Yogurt, 20),"Firma 2");
		contructors.put(new Product("Bread Grey",TypeProduct.Bread, 20),"Firma 2");
		contructors.put(new Product("Yogurt for Java Developers",TypeProduct.Yogurt, 20),"Firma 2");
		
	}
	public static void main(String[] args) {
		ProductShop shop = new ProductShop();
		shop.printContructor();
		shop.printReverseContructor();
		shop.printNameProductByParty(TypeProduct.Yogurt);
	}
	/*
	+	 1) ������� ���������� ������ ���� � ���������� ������� 
	+	2) ������� ���������� ������ ���� � �������� �������
	+	3) ������� ���������� ������������ ������� �� ���� ���������
	+	 * */
	public void printContructor(){
	}
	public void printReverseContructor(){
	}
	public void printNameProductByParty(TypeProduct type){
	}
}

