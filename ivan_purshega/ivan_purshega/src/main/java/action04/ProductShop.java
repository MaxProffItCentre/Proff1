package HomeWork;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
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

		contructors.put(new Product("Bread White",TypeProduct.Bread, 10),"Firma 2");
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
	+	 1) ¬ывести уникальный список фирм в алфавитном пор€дке 
	+	2) ¬ывести уникальный список фирм в обратном пор€дке
	+	3) ¬ывести уникальные наименовани€ товаров по типу продуктов 
	+	 * */
		public void printContructor(){
			TreeSet <String> tree = new TreeSet<String>();
			for (Map.Entry<Product, String> entry: this.contructors.entrySet())
				tree.add(entry.getValue());
			System.out.println(tree);
		}
			
		
		public void printReverseContructor() {
			
			TreeSet<String> tree = new TreeSet<String>(new Sort());		
			for (Map.Entry<Product, String> entry: this.contructors.entrySet())
				tree.add(entry.getValue());
			System.out.println(tree);
			
		}
		
		public void printNameProductByParty(TypeProduct type){
			HashSet <Product> unical = new HashSet<Product>();
			for (Map.Entry<Product, String> entry: this.contructors.entrySet())
				if (entry.getKey().getType().equals(type)) unical.add(entry.getKey());
				
				System.out.println(unical);
		
		}
	}
		
		

	
	
	